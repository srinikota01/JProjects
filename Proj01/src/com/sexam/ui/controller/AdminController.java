package com.sexam.ui.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sexam.dao.AdminDAO;
import com.sexam.dao.ExamDAO;
import com.sexam.dao.entity.AdminTl;
import com.sexam.dao.entity.ExamTl;
import com.sexam.dao.entity.QuestionTl;
import com.sexam.ui.command.LoginCommand;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private ExamDAO examDAO; 

	
	@RequestMapping(method=RequestMethod.GET,value="/adminlogin.htm")
	public String showAdminLogin() {	
		
		return "adminlogin" ;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/adminlogin.htm")
	public String adminLogin(LoginCommand logincommand,HttpServletRequest request) {
		
		AdminTl admintl= adminDAO.getAdmin(logincommand.getEmailid(), logincommand.getPassword());
		if(admintl != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admintl);
			return "redirect:adminexams.htm";
		}
		else
		{
			request.setAttribute("errormessage", "invaliduser");
			return "adminlogin";
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addexam.htm")
	public String showAddExam() {		
		return "adminaddexam";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addexam.htm")
	public String addExam(ExamTl examtl) {
		Integer examId = examDAO.insertExam(examtl);
		if(examId!=null && examId >0) {
			return "redirect:adminexams.htm";
			}
		else
		{
			return "adminaddexam";
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/adminexams.htm")
	public String adminExams(HttpServletRequest request ) {
		
		List<ExamTl> exams = examDAO.getExams();
		request.setAttribute("exams", exams);
		return "adminexams" ;
		
	}
	


@RequestMapping(method=RequestMethod.GET, value="/addquestion.htm")
	public String showAddQuestion(HttpServletRequest request) {	
	List<ExamTl> exams= examDAO.getExams();
    request.setAttribute("exams",exams);
		return "adminaddquestion";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addquestion.htm")
	public String addQuestion(QuestionTl questiontl) {
		Integer questionId = examDAO.insertQuestion(questiontl);
		if(questionId!=null && questionId >0) {
			return "redirect:adminquestions.htm?examId="+questiontl.getExamId();
			}
		else
		{
			return "adminaddquestion";
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/adminquestions.htm")
	public String adminQuestions(HttpServletRequest request ) {
		String eid= request.getParameter("examId");
		List<QuestionTl> questions = examDAO.getQuestions(new Integer(eid));
		request.setAttribute("questions", questions);
		return "adminquestions" ;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/logout.htm")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession(false);
		if(session !=null)
		{
			session.invalidate();
		}
		
		return "redirect:adminlogin.htm";
		
	}
	
	
	
}
