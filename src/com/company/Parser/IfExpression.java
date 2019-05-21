package com.company.Parser;

public class IfExpression extends Expression
{
	public IfExpression(Expression condition, Expression ifTrueExpr, Expression ifFalseExpr)
	{
		this.value = "if";
		innerExpression.add(condition);
		innerExpression.add(ifTrueExpr);
		innerExpression.add(ifFalseExpr);
		this.empty = false;
	}
	
	public String getType()
	{
		return "IfExpression";
	}	
} 