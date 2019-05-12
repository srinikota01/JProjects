package com.sexam.dao;
import com.sexam.dao.entity.AdminTl;

public interface AdminDAO {
	
	public AdminTl getAdmin(String emailId,String password);
	
	

}
