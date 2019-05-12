package com.sexam.dao.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score_tl")
public class ScoreTl implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="score_Id")
	private Integer scoreId;
	@Column(name="student_Id")
	private Integer studentId;
	@Column(name="exam_Id")
	private Integer examId;
	@Column(name="written_Date")
	private java.sql.Date writtenDate;
	public java.sql.Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(java.sql.Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	@Column(name="score")
	private Integer score;
	
	public Integer getScoreId() {
		return scoreId;
	}
	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
