package com.sexam.dao.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_tl")
public class StudentTl implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="student_Id")
	private Integer studentId;
	@Column(name="name")
	private String  name;
	@Column(name="email_Id")
	private String emailId;
	@Column(name="password")
	private String password;	
	@Column(name="phone_Num")
	private String phoneNum;
	@Column(name="address")
	private String address;
	@Column(name="dob")
	private java.sql.Date dob;
	public java.sql.Date getDob() {
		return dob;
	}
	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Column(name="college")
	private String college;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhonenum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
