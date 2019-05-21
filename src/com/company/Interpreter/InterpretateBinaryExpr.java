package com.company.Interpreter;
import com.company.Parser.*;

import java.text.ParseException;

public class InterpretateBinaryExpr extends AbstractInterpreter
{
	public Expression interpretate(Expression inExpr)  throws ParseException
	{
		BinaryExpression binExpr = null;
		if(inExpr.getType().equals("BinaryExpression"))
			binExpr = (BinaryExpression) inExpr;
		else
			return new Expression();
		
		ConstantExpression oper1 = (ConstantExpression)iterpretNextExpression(binExpr.getChild(0));
		ConstantExpression oper2 = (ConstantExpression)iterpretNextExpression(binExpr.getChild(1));
		
		int operand1 = Integer.parseInt(oper1.value);
		int operand2 = Integer.parseInt(oper2.value);
		int resalt = 0;
		
		switch(binExpr.value)
		{
			case "+": 
				resalt = operand1 + operand2;
				break;
			case "-": 
				resalt = operand1 - operand2;
				break;
			case "*": 
				resalt = operand1 * operand2;
				break;
			case "/":
				if(operand2 == 0)
				{
					System.out.println("ZeroDivision");
					return new Expression();
				}
				resalt = operand1 / operand2;
				break;
			case "%": 
				if(operand2 == 0)
				{
					System.out.println("ZeroDivision");
					return new Expression();
				}
				resalt = operand1 % operand2;
				break;
			case ">":
				if(operand1 > operand2)
					resalt = 1;
				else
					resalt = 0;
				break;
			case "<":
				if(operand1 < operand2)
					resalt = 1;
				else
					resalt = 0;
				break;
			case "=":
				if(operand1 == operand2)
					resalt = 1;
				else
					resalt = 0;
				break;
			default:
				return new Expression();
		}
			
		return new ConstantExpression(Integer.toString(resalt));
	}
}