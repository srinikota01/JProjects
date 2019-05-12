package com.sexam.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.sexam.dao.AdminDAO;
import com.sexam.dao.CustomHibernateDaoSupport;
import com.sexam.dao.entity.AdminTl;

@Repository
public class AdminDAOimpl extends CustomHibernateDaoSupport implements AdminDAO{

	@Override
	public AdminTl getAdmin(String emailId, String password) {
		
		AdminTl admintl = null;
		
		List<AdminTl> admins = getHibernateTemplate().find("from AdminTl where emailId=? AND password=?",new Object[] {emailId,password});
		
		if(admins!=null && admins.size()>0) {
			admintl = admins.get(0);					
		}
		// TODO Auto-generated method stub
		return admintl;
	}

}
