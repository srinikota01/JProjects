package com.sexam.dao;
import java.util.List;
import java.util.Map;

import com.sexam.dao.entity.ExamTl;
import com.sexam.dao.entity.QuestionTl;
import com.sexam.dao.entity.ScoreTl;

public interface ExamDAO {
	
	public Integer insertExam(ExamTl examTl);
	public List<ExamTl> getExams();
	public Integer insertQuestion(QuestionTl questionTl);
	public List<QuestionTl> getQuestions(Integer examId);
	public Map<Integer,String> getAnswer(Integer examId);
	public Integer insertScore(ScoreTl scoretl);
	
	

}
