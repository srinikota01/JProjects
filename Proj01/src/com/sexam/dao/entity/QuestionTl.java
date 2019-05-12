package com.sexam.dao.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_Tl")
public class QuestionTl implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="question_Id")
	private Integer questionId;
	@Column(name="exam_Id")
	private Integer examId;
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	@Column(name="question")
	private String question;
	@Column(name="answer1")
	private String answer1;
	@Column(name="answer2")
	private String answer2;
	@Column(name="answer3")
	private String answer3;
	@Column(name="answer4")
	private String answer4;
	@Column(name="correct_Answer")
	private String correctAnswer;
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
}
