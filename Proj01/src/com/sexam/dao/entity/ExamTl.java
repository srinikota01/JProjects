package com.sexam.dao.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_Tl")
public class ExamTl implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="exam_Id")
	private Integer examId;
	@Column(name="exam_Title")
	private String examTitle;
	@Column(name="exam_Code")
	private String examCode;
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getExamTitle() {
		return examTitle;
	}
	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	
}
