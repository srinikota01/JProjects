package com.sexam.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.sexam.dao.StudentDAO;
import com.sexam.dao.CustomHibernateDaoSupport;
import com.sexam.dao.entity.StudentTl;

@Repository
public class StudentDAOimpl extends CustomHibernateDaoSupport implements StudentDAO{

	@Override
	public StudentTl getStudent(String emailId, String password) {
		
		StudentTl studenttl = null;
		
		List<StudentTl> students = getHibernateTemplate().find("from StudentTl where emailId=? AND password=?",new Object[] {emailId,password});
		
		if(students!=null && students.size()>0) {
			studenttl = students.get(0);					
		}
		// TODO Auto-generated method stub
		return studenttl;
	}

	@Override
	public Integer insertStudent(StudentTl studenttl) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(studenttl);
	}

}
