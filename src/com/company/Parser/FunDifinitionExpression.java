package com.company.Parser;

public class FunDifinitionExpression extends Expression
{
	public FunDifinitionExpression(String name, Expression parmsLit, Expression body)
	{
		this.value = "name";
		innerExpression.add(parmsLit);
		innerExpression.add(body);
		this.empty = false;
	}
	
	public String getType()
	{
		return "FunDifinitionExpression";
	}	
} 