package com.sexam.dao;
import com.sexam.dao.entity.StudentTl;

public interface StudentDAO {

	public StudentTl getStudent(String emailId,String password);
	public Integer insertStudent(StudentTl studenttl);
	
	
}
