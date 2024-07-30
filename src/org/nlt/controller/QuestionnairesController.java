package org.nlt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.model.Questionnaires;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionnairesController extends MainController implements MainInterface
{
	@PostMapping("/submitQuestion")
	public ModelAndView submitQuestion(HttpServletRequest req, HttpServletResponse res)
	{
		Map m = new HashMap<>();
		HttpSession httpSession = req.getSession();
		
		try
		{
			String question = req.getParameter("question");
			String option1 = req.getParameter("option1");
			String option2 = req.getParameter("option2");
			String option3 = req.getParameter("option3");
			String option4 = req.getParameter("option4");
			String answer = req.getParameter("answer");
			
			m.put("questionValue", question);
			m.put("option1Value", option1);
			m.put("option2Value", option2);
			m.put("option3Value", option3);
			m.put("option4Value", option4);
			m.put("answerValue", answer);
			
			if(question.isEmpty())
			{
				m.put("error", "Please Enter Proper Data !");
				m.put("action", "./submitQuestion");
				m.put("buttonValue", "SUBMIT");
				questionnarieService.setQuestionMap();
				m.put("questionsList", questionHashMap.values());
				return new ModelAndView("questionnaires",m);
			}
			else
			{
				if(questionHashMap.values().stream().filter(P->P.getQuestions().equalsIgnoreCase(question)).findAny().orElse(null)!=null)
				{
					m.put("error", "This Question is already Available !");
					m.put("action", "./submitQuestion");
					m.put("buttonValue", "SUBMIT");
					questionnarieService.setQuestionMap();
					m.put("questionsList", questionHashMap.values());
					return new ModelAndView("questionnaires",m);
				}
				else
				{
					Questionnaires que = new Questionnaires();
					que.setQuestions(question);
					que.setOption1(option1);
					que.setOption2(option2);
					que.setOption3(option3);
					que.setOption4(option4);
					que.setAnswer(Integer.parseInt(answer));
					que.setStatus(1);
					que.setCreated(new Date());
					que.setModified(new Date());
					
					questionnarieService.submitQuestion(que);
					
					m.put("success", "Record Submitted Successfully");
					m.put("action", "./submitQuestion");
					m.put("buttonValue", "SUBMIT");
					questionnarieService.setQuestionMap();
					m.put("questionsList", questionHashMap.values());
					return new ModelAndView("questionnaires",m);
				}
				
			}
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			m.put("action", "./submitQuestion");
			m.put("buttonValue", "SUBMIT");
			questionnarieService.setQuestionMap();
			m.put("questionsList", questionHashMap.values());
			return new ModelAndView("questionnaires",m);
		}
	}
}
