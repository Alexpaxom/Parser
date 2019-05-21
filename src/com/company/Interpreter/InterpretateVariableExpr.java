package com.company.Interpreter;

import com.company.Parser.*;

import java.text.ParseException;

public class InterpretateVariableExpr extends AbstractInterpreter
{
	public Expression interpretate(Expression inExpr, ProgrammTree programmTree) throws ParseException
	{
		VariableExpression varExpr = null;
		ConstantExpression res;
		if(inExpr.getType().equals("VariableExpression"))
			varExpr = (VariableExpression) inExpr;
		else
			return new Expression();


		FunDifinitionExpression func = (FunDifinitionExpression)programmTree.peekFromFunctionStack();

		ParametersListExpression paramList = (ParametersListExpression)func.getChild(0);

		return iterpretNextExpression(paramList.getParamByName(varExpr.value).getChild(0), programmTree);
	}
}