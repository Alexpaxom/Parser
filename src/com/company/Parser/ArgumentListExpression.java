package com.company.Parser;

public class ArgumentListExpression extends Expression
{
	int numArgs = 0;
	public ArgumentListExpression()
	{
		this.value = "ArgsList";
		this.empty = false;
	}

	public void addArgument(Expression var)
	{
		innerExpression.add(var);
		numArgs+=1;
	}

	public int getNumArgs()
	{
		return numArgs;
	}

	public String getType()
	{
		return "ArgumentListExpression";
	}	
} 