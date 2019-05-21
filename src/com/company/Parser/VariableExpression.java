package com.company.Parser;

public class VariableExpression extends Expression
{
	public VariableExpression(String name, Expression value)
	{
		this.value = name;
		innerExpression.add(value);

		this.empty = false;
	}
	
	public String getType()
	{
		return "VariableExpression";
	}	
} 