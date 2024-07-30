package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.controller.services.StudentService;
import org.nlt.model.Questionnaires;
import org.nlt.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController extends MainController implements MainInterface
{
	@PostMapping("/validatestudentlogin")
	public ModelAndView validateadminlogin(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession = req.getSession();
		
		try
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			Users user = studentService.validateUser(username, password);
			if(user==null)
			{
				m.put("error", "Invalid Login! Plase Try With Different Username & Password");
				return new ModelAndView("studentlogin",m);
			}
			else
			{
				httpSession.setAttribute("StudentUser", user);
				
				questionnarieService.setQuestionMap();
				int questionNo=0;
				while(true)
				{
					Random r = new Random();
					questionNo = r.nextInt(questionHashMap.size()+1);
					
					if(questionNo!=0 && questionHashMap.containsKey(questionNo))
					{
						break;
					}
				}
				Questionnaires question = questionHashMap.get(questionNo);
				
				
				m.put("question", question);
				m.put("action", "./submitAnswer");
				m.put("buttonValue", "NEXT");
				return new ModelAndView("examination",m);	
			}
			
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return new ModelAndView("studentlogin");
	}
	
	@PostMapping("/submitAnswer")
	public ModelAndView submitAnswer(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession = req.getSession();
		
		try
		{
			String id = req.getParameter("id");
			String answer = req.getParameter("questionoption");
			
			Questionnaires currentQuestion = questionHashMap.get(Integer.parseInt(id));
			
			if(currentQuestion.getAnswer()==Integer.parseInt(answer))
			{
				System.out.println("Correct Answer");	
			}
			else
			{
				System.out.println("Incorrect Answer");
			}
				
				int questionNo=0;
				while(true)
				{
					Random r = new Random();
					questionNo = r.nextInt(questionHashMap.size()+1);
					
					if(questionNo!=0 && questionHashMap.containsKey(questionNo))
					{
						break;
					}
				}
			Questionnaires question = questionHashMap.get(questionNo);
			m.put("question", question);
			m.put("action", "./submitAnswer");
			m.put("buttonValue", "SUBMIT");
			return new ModelAndView("examination",m);	
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		m.put("action", "./submitAnswer");
		m.put("buttonValue", "SUBMIT");
		return new ModelAndView("examination",m);	
	}
}
