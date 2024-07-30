package org.nlt.controller;

import java.util.LinkedHashMap;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Questionnaires;
import org.nlt.model.Users;

public interface MainInterface 
{
	public SessionFactory sf=getSession();
	public Session ses = sf.openSession();
	
	public LinkedHashMap<Integer, Users> userHashMap = new LinkedHashMap<>();
	public LinkedHashMap<Integer, Questionnaires> questionHashMap = new LinkedHashMap<>();
	
	
	
	public static SessionFactory getSession()
	{
		return new Configuration().configure("org/nlt/database/hibernate.cfg.xml").buildSessionFactory();
	}
}
