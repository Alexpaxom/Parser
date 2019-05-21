package com.company.Parser;

public class CallExpression extends Expression
{
	public CallExpression(String name, Expression argsList)
	{
		this.value = name;
		innerExpression.add(argsList);
		this.empty = false;
	}
	
	public String getType()
	{
		return "CallExpression";
	}	
} 