
package org.nlt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.controller.services.AdminService;
import org.nlt.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController extends MainController implements MainInterface
{
	@GetMapping("/")
	public ModelAndView registration(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession=req.getSession();
		
		//if already login
		if(httpSession.getAttribute("AdminUser")!=null)
		{
			m.put("action", "./studentRegistration");
			m.put("buttonValue", "submit");
			m.put("studentList", "");
			return new ModelAndView("registration",m);
		}
		else if(httpSession.getAttribute("StudentUser")!=null)
		{
			m.put("action", "#");
			m.put("buttonValue", "submit");
			m.put("studentList", "");
			return new ModelAndView("examination",m);
		}
		
		m.put("action", "./validatestudentlogin");
		return new ModelAndView("studentlogin",m);
	}
	
	@GetMapping("/admin")
	public ModelAndView admin(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession=req.getSession();
		//if already login
		if(httpSession.getAttribute("AdminUser")!=null)
		{
			m.put("action", "./studentRegistration");
			m.put("buttonValue", "SUBMIT");
			m.put("studentList", "");
			return new ModelAndView("registration",m);
		}
		
		
		return new ModelAndView("adminlogin");
	}
	
	@PostMapping("/validateadminlogin")
	public ModelAndView validateadminlogin(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession = req.getSession();
		
		try
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			Users user = adminService.validateUser(username, password);
			if(user==null)
			{
				m.put("error", "Invalid Login! Plase Try With Different Username & Password");
				return new ModelAndView("adminlogin",m);
			}
			else
			{
				httpSession.setAttribute("AdminUser", user);
				m.put("action", "./studentRegistration");
				m.put("buttonValue", "SUBMIT");
				adminService.setUserList();
				m.put("studentList", userHashMap.values());
				return new ModelAndView("registration",m);	
			}
			
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return new ModelAndView("adminlogin");
	}
	
	
	@PostMapping("/studentRegistration")
	public ModelAndView studentRegistration(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession = req.getSession();
		
		try
		{
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String phone = req.getParameter("phone");
			
			m.put("nameValue", name);
			m.put("emailValue", email);
			m.put("usernameValue", username);
			m.put("phoneValue", phone);
			
			if(name.isEmpty()||email.isEmpty())
			{
				m.put("error", "Please Enter Proper Data !");
				m.put("action", "./studentRegistration");
				m.put("buttonValue", "SUBMIT");
				adminService.setUserList();
				m.put("studentList", userHashMap.values());
				return new ModelAndView("registration",m);
			}
			else
			{
				Random r = new Random();
				int password = r.nextInt(10000);
				
				Users user = new Users();
				user.setPassword(password+"");
				user.setName(name);
				user.setUsername(username);
				user.setEmail(email);
				user.setPhone(Long.parseLong(phone));
				user.setCreated(new Date());
				user.setModified(new Date());
				user.setStatus(1);
				
				adminService.submitUser(user); 
				
				m.put("success", "Record Submitted Successfully");
				m=this.resetData(m);
				m.put("action", "./studentRegistration");
				m.put("buttonValue", "SUBMIT");
				adminService.setUserList();
				m.put("studentList", userHashMap.values());
				return new ModelAndView("registration",m);
			}
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			m.put("action", "./studentRegistration");
			m.put("buttonValue", "SUBMIT");
			adminService.setUserList();
			m.put("studentList", userHashMap.values());
			return new ModelAndView("registration",m);
		}
	}
	
	@GetMapping("/questions")
	public ModelAndView question(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession = req.getSession();
		
		try
		{
			m.put("buttonValue", "SUBMIT");
			m.put("action", "./submitQuestion");
			questionnarieService.setQuestionMap();
			m.put("questionsList", questionHashMap.values());
			return new ModelAndView("questionnaires",m);
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return new ModelAndView("questionnaires",m);
		}
	}
	
	
	
	public Map resetData(Map m)
	{
		m.put("nameValue", "");
		m.put("emailValue", "");
		m.put("usernameValue", "");
		m.put("phoneValue", "");
		return m;
	}
}
