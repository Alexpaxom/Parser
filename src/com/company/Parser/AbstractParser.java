package com.company.Parser;
import com.company.Lexer.*;

import java.util.ArrayList;
import java.lang.reflect.*;

public abstract class AbstractParser
{	
	// регистрируем стандартный набор выражений
	ArrayList<Constructor> checkExpressions = new ArrayList<Constructor>();
	
	public AbstractParser()
	{
		try
		{ 
			checkExpressions.add(ParsBinaryExpression.class.getDeclaredConstructor());
			checkExpressions.add(ParsConstantExpression.class.getDeclaredConstructor());
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
	}

	protected Expression parseNextExpression(Lexer.TokenList tokensList)
	{
		//if(tokensList.isEmpty())
			//return new Expression();
		
		for(Constructor constr : checkExpressions)
		{
			try
			{ 
				AbstractParser curParser = (AbstractParser) constr.newInstance();
				Expression expr = curParser.parse(tokensList);
				
				if(!expr.isEmpty())
					return expr;
			} 
			catch (Exception e) 
			{ 
				e.printStackTrace(); 
			}
		}
		
		System.out.println("Not found correct parser in AbstractParser.java");
		System.exit(1);
		return new Expression();
	}
	
	public abstract Expression parse(Lexer.TokenList tokensList);
}
