package com.company.Interpreter;

import com.company.Parser.IfExpression;
import com.company.Parser.ConstantExpression;
import com.company.Parser.Expression;

import java.text.ParseException;

public class InterpretateIfExpr extends AbstractInterpreter
{
	public Expression interpretate(Expression inExpr)  throws ParseException
	{
		IfExpression ifExpr = null;
		ConstantExpression res;
		if(inExpr.getType().equals("IfExpression"))
			ifExpr = (IfExpression) inExpr;
		else
			return new Expression();
		
		ConstantExpression condition = (ConstantExpression)iterpretNextExpression(ifExpr.getChild(0));

		if(Integer.parseInt(condition.value) != 0)
			res = (ConstantExpression)iterpretNextExpression(ifExpr.getChild(1));
		else
			res = (ConstantExpression)iterpretNextExpression(ifExpr.getChild(2));
			
		return res;
	}
}