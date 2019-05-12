package com.sexam.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.sexam.dao.CustomHibernateDaoSupport;
import com.sexam.dao.ExamDAO;
import com.sexam.dao.entity.ExamTl;
import com.sexam.dao.entity.QuestionTl;
import com.sexam.dao.entity.ScoreTl;

@Repository
public class ExamDAOimpl extends CustomHibernateDaoSupport implements ExamDAO {

	@Override
	public Integer insertExam(ExamTl examTl) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(examTl);
	}

	@Override
	public List<ExamTl> getExams() {
		// TODO Auto-generated method stub
		return  (List<ExamTl>) getHibernateTemplate().loadAll(ExamTl.class);
	}

	@Override
	public Integer insertQuestion(QuestionTl questionTl) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(questionTl);
	}

	@Override
	public List<QuestionTl> getQuestions(Integer examId) {
		// TODO Auto-generated method stub
		return (List<QuestionTl>) getHibernateTemplate().find("from QuestionTl where examId=?",new Object[] {examId});
	}

	@Override
	public Map<Integer, String> getAnswer(Integer examId) {
		// TODO Auto-generated method stub
		Map<Integer,String> m = new HashMap<Integer, String>();
		List <Object[]> list = (List <Object[]>) getHibernateTemplate().find("select questionId,correctAnswer from QuestionTl where examId=?",new Object[] {examId});
		if(list != null && list.size()>0) {		
		
			ListIterator<Object[]> li = list.listIterator();			
			while (li.hasNext()) {
				Object[] obj = li.next();
				
				m.put((Integer) obj[0],(String)obj[1]);
							
			}
		}
		
		return m;
	}

	@Override
	public Integer insertScore(ScoreTl scoretl) {
		// TODO Auto-generated method stub		
		return (Integer) getHibernateTemplate().save(scoretl);
	}
	
	

}
