package com.company.Parser;

public class BinaryExpression extends Expression
{	
	public BinaryExpression(Expression oper1, Expression oper2, String operation)
	{
		this.value = operation;
		innerExpression.add(oper1);
		innerExpression.add(oper2);
		this.empty = false;
	}
	
	public String getType()
	{
		return "BinaryExpression";
	}	
} 