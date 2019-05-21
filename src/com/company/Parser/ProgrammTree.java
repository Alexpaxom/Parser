package com.company.Parser;

import java.util.ArrayList;

public class ProgrammTree
{
	ArrayList<Expression> expressions = new ArrayList<Expression>();
	
	public void addExpression(Expression expression)
	{
		expressions.add(expression);
	}
}