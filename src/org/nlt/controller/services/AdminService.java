package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.controller.MainInterface;
import org.nlt.model.Users;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements MainInterface
{
	public Users  validateUser(String username, String password)
	{
		ses.beginTransaction();
		Query query = ses.createQuery("from Users where status=2 and username='"+username+"' and password='"+password+"'");
		ses.getTransaction().commit();
		List<Users> userList = query.list();
		if(userList.size()==1)
		{
			return userList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public void submitUser(Users user)
	{
		ses.beginTransaction();
		ses.save(user);
		ses.getTransaction().commit();
	}
	
	public void setUserList()
	{
		Query query = ses.createQuery("from Users where status=1");
		List<Users> userList = query.list();
		
		userHashMap.clear();
		for(Users user : userList)
		{
			userHashMap.put(user.getId(), user);
		}
	}
}
