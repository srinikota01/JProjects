package com.sexam.ui.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sexam.dao.ExamDAO;
import com.sexam.dao.StudentDAO;
import com.sexam.dao.entity.ExamTl;
import com.sexam.dao.entity.QuestionTl;
import com.sexam.dao.entity.ScoreTl;
import com.sexam.dao.entity.StudentTl;
import com.sexam.ui.command.LoginCommand;
import com.sexam.ui.command.StudentCommand;

@Controller
public class StudentController{
	
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ExamDAO examDAO;
	
	@RequestMapping(method=RequestMethod.GET,value="/studentlogin.htm")
	public String showStudentLogin() {	
		
		return "studentlogin" ;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/studentlogin.htm")
	public String studentLogin(LoginCommand logincommand,HttpServletRequest request) {
		
		StudentTl studenttl= studentDAO.getStudent(logincommand.getEmailid(), logincommand.getPassword());
		if(studenttl != null) {
			HttpSession session = request.getSession();
			session.setAttribute("student", studenttl);
			return "redirect:studentexams.htm";
		}
		else
		{
			request.setAttribute("errormessage", "invaliduser");
			return "studentlogin";
		}
		
	}
	@RequestMapping(method=RequestMethod.GET,value="/student.htm")
	public String showStudent() {	
		
		return "student" ;
	}
	

@RequestMapping(method=RequestMethod.GET, value="/studentreg.htm")
	public String showAddStudent() {		
		return "studentregistration";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/studentreg.htm")
	public String addStudent(StudentCommand studentcommand) {
		StudentTl studenttl = new StudentTl();
		studenttl.setName(studentcommand.getName());
		studenttl.setEmailId(studentcommand.getEmailId());
		studenttl.setPassword(studentcommand.getPassword());
		studenttl.setCollege(studentcommand.getCollege());
		studenttl.setAddress(studentcommand.getAddress());
		studenttl.setPhoneNum(studentcommand.getPhoneNum());	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date udate = sdf.parse(studentcommand.getDob());
			java.sql.Date sdate = new java.sql.Date(udate.getTime());
			studenttl.setDob(sdate);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Integer studentId = studentDAO.insertStudent(studenttl);
		if(studentId!=null && studentId >0) {
			return "redirect:studentexams.htm";
			}
		else
		{
			return "studentregistration";
		}
		
		
	}

	@RequestMapping(method=RequestMethod.GET, value="/studentexams.htm")
	public String adminExams(HttpServletRequest request ) {
		
		List<ExamTl> exams = examDAO.getExams();
		request.setAttribute("exams", exams);
		return "studentexams" ;
		
	}

	@RequestMapping(method=RequestMethod.POST, value="/studentquestions.htm")
	public String adminQuestions(HttpServletRequest request ) {
		String eid= request.getParameter("examId");
		List<QuestionTl> questions = examDAO.getQuestions(new Integer(eid));
		request.setAttribute("questions", questions);
		return "studentquestions" ;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/studentlogout.htm")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession(false);
		if(session !=null)
		{
			session.invalidate();
		}
		
		return "redirect:studentlogin.htm";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/submitexam.htm")
	public String submitexam(HttpServletRequest request) {
		String examId = request.getParameter("examId");
		String [] questions = request.getParameterValues("question");
		Map<Integer,String> answers = examDAO.getAnswer(new Integer(examId));
		Integer score = 0;
		for(String qid:questions) {
			
			String option = request.getParameter("question"+qid);
			Integer questionId = new Integer(qid);
			String correctAnswer = answers.get(questionId);
			if(option!=null && correctAnswer!=null && option.equalsIgnoreCase(correctAnswer)) {
				score++;
			}
		}
		
		ScoreTl scoretl = new ScoreTl();
		scoretl.setExamId(new Integer (examId));
		scoretl.setScore(score);
		scoretl.setWrittenDate(new java.sql.Date(new java.util.Date().getTime()));
		HttpSession session = request.getSession();
		StudentTl studenttl = (StudentTl) session.getAttribute("student");
		scoretl.setStudentId(studenttl.getStudentId());
		Integer scoreId = examDAO.insertScore(scoretl);			
	    return "redirect:result.htm";
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/result.htm")
	public String result() {
				
		return "result";
	
	}
	
}