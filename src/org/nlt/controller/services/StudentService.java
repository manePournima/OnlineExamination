package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.controller.MainInterface;
import org.nlt.model.Users;
import org.springframework.stereotype.Service;

@Service 
public class StudentService implements MainInterface
{
	public Users validateUser(String username, String password)
	{
		ses.beginTransaction();
		Query query = ses.createQuery("from Users where status=1 and username='"+username+"' and password='"+password+"'");
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
}
