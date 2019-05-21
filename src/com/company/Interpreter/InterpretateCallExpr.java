package com.company.Interpreter;

import com.company.Parser.*;

import java.text.ParseException;

public class InterpretateCallExpr extends AbstractInterpreter
{
	public Expression interpretate(Expression inExpr, ProgrammTree programmTree) throws ParseException
	{
		CallExpression callExpr = null;
		if(inExpr.getType().equals("CallExpression"))
			callExpr = (CallExpression) inExpr;
		else
			return new Expression();

		FunDifinitionExpression func = (FunDifinitionExpression)programmTree.getFunciton(callExpr.value);

		ParametersListExpression paramsList = (ParametersListExpression)func.getChild(0);
		ArgumentListExpression argumentList = (ArgumentListExpression)callExpr.getChild(0);

		if(paramsList.getNumParams() == argumentList.getNumArgs())
		{
			ParametersListExpression newParamsList = new ParametersListExpression();
			VariableExpression param = null;
			Expression arg = null;

			for (int i = 0; i < paramsList.getNumParams(); ++i)
			{
				param = (VariableExpression)paramsList.getChild(i);
				arg = argumentList.getChild(i);
				newParamsList.addParametr(new VariableExpression(param.value, iterpretNextExpression(arg, programmTree)));
			}

			FunDifinitionExpression newFunc = new FunDifinitionExpression(func.value, newParamsList, func.getChild(1));

			programmTree.pushOnFunctionStack(newFunc);
			Expression resExpr = iterpretNextExpression(func.getChild(1), programmTree);
			programmTree.popFromFunctionStack();

			return resExpr;
		}


		return new Expression();
	}
}