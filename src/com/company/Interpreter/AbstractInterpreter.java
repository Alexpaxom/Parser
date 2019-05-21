package com.company.Interpreter;

import java.util.ArrayList;
import java.lang.reflect.*;
import java.text.ParseException;
import com.company.Parser.*;

public abstract class AbstractInterpreter
{	
	// регистрируем стандартный набор выражений
	ArrayList<Constructor> iterpretExpressions = new ArrayList<Constructor>();
	
	public AbstractInterpreter()
	{
		try
		{ 
			iterpretExpressions.add(InterpretateConstantExpression.class.getDeclaredConstructor());
			iterpretExpressions.add(InterpretateBinaryExpr.class.getDeclaredConstructor());
			iterpretExpressions.add(InterpretateIfExpr.class.getDeclaredConstructor());
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
	}

	protected Expression iterpretNextExpression(Expression inExpr) throws ParseException
	{
		for(Constructor constr : iterpretExpressions)
		{
			try
			{ 
				AbstractInterpreter curInterpreter = (AbstractInterpreter) constr.newInstance();
				Expression expr = curInterpreter.interpretate(inExpr);
				
				if(!expr.isEmpty())
					return expr;
			} 
			catch (Exception e) 
			{ 
				e.printStackTrace(); 
			}
		}
		
		System.out.println("Not found correct Interpreter in AbstractInterpreter.java");
		System.exit(1);
		return new Expression();
	}
	
	public abstract Expression interpretate(Expression inExpr) throws ParseException;
}
