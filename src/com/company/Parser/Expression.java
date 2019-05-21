package com.company.Parser;

import java.util.ArrayList;

public class Expression
{	
	ArrayList<Expression> innerExpression = new ArrayList<Expression>();

	public Expression getChild(int inx)
	{
		return innerExpression.get(inx);
	}
	
	public String value = "";
	
	public String getType()
	{
		return "Expression";
	}		
	
	public  boolean isEmpty()
	{
		return empty;
	}
	
	protected boolean empty = true;
} 