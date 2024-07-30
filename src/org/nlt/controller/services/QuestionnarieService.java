package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.controller.MainInterface;
import org.nlt.model.Questionnaires;
import org.springframework.stereotype.Service;

@Service
public class QuestionnarieService implements MainInterface 
{
	public void setQuestionMap()
	{
		Query query = ses.createQuery("from Questionnaires where status=1");
		List<Questionnaires> questionList = query.list();
		
		questionHashMap.clear();
		for(Questionnaires que : questionList)
		{
			questionHashMap.put(que.getId(), que);
		}
	}
	
	public void submitQuestion(Questionnaires question)
	{
		ses.beginTransaction();
		ses.save(question);
		ses.getTransaction().commit();
	}
}
