package com.company.Interpreter;
import com.company.Parser.*;

import java.text.ParseException;

public class InterpretateConstantExpression extends AbstractInterpreter
{
	public Expression interpretate(Expression inExpr, ProgrammTree programmTree) throws ParseException
	{
		if(inExpr.getType().equals("ConstantExpression"))
			return inExpr;
		
		return new Expression();
	}
}