package com.company.Parser;

public class ConstantExpression extends Expression
{	
	public ConstantExpression(String val)
	{
		this.value = val;
		this.empty = false;
	}
	
	public String getType()
	{
		return "ConstantExpression";
	}	
} 