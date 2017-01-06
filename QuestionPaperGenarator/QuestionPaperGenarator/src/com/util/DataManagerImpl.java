package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;

public class DataManagerImpl implements DataManager 
{
	DatabaseConnectionManager dcm=new DatabaseConnectionManager();
	@Override
	public List<Question> populateData()
	{
		List<Question> list=new ArrayList<Question>();
		Connection c=dcm.getConnection();
		
		try {
			Statement 	st = c.createStatement();
			ResultSet rs=st.executeQuery("select * from questionbank");
			while(rs.next())
			{
				Question q=new Question(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), Category.valueOf(rs.getString(8)),
						Complexity.valueOf(rs.getString(9)));
				list.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Question> getQuestionByCategory(Category category,
			List<Question> questionsList)
	{
		List<Question> small=new ArrayList<Question>();
		for (Question question : questionsList)
		{
			if(question.getCategory().equals(category))
				small.add(question);
		}
		return small;
	}

	
	@Override
	public List<Question> getQuestionByComplexity(Complexity complexity,
			List<Question> questionsList)
			{
		List<Question> small=new ArrayList<Question>();
		for (Question question : questionsList)
		{
			if(question.getComplexity().equals(complexity))
				small.add(question);
		}
		return small;
	}

	@Override
	public Set<Question> generateQuestionPaper(List<Question> list,
			List<Criteria> template) 
			{
		Set<Question> set=new LinkedHashSet<Question>();
		int s=0;
		for (Criteria criteria : template)
		{
			 s=criteria.getNoOfQuestion()+s;
			List<Question> catList=getQuestionByCategory(criteria.getCategory(),list);
			List<Question> comList=getQuestionByComplexity(criteria.getComplexity(), catList);
			while(set.size()!=s)
			{
				set.add(comList.get((int)(Math.random()*comList.size())));
			}
		}
	
		
		return set;
	}

	@Override
	public void sortByCategory(List<Question> questionList) 
	{
		Collections.sort(questionList, new Comparator<Question>()
		{
			@Override
			public int compare(Question o1, Question o2) 
			{
				return o1.getCategory().compareTo(o2.getCategory());
			}
		});
	}

	@Override
	public void sortByComplexity(List<Question> questionList) 
	{
		Collections.sort(questionList, new Comparator<Question>()
				{
					@Override
					public int compare(Question o1, Question o2) 
					{
						return o1.getComplexity().compareTo(o2.getComplexity());
					}
				});
		
	}
}