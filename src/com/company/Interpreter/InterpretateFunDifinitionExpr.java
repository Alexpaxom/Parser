package com.company.Interpreter;

import com.company.Parser.*;

import java.text.ParseException;

public class InterpretateFunDifinitionExpr extends AbstractInterpreter
{
	public Expression interpretate(Expression inExpr, ProgrammTree programmTree) throws ParseException
	{
		if(inExpr.getType().equals("FunDifinitionExpression"))
			return new VariableExpression("funcion", null);
		else
			return new Expression();


	}
}