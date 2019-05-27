package com.company.Parser;

import com.company.Lexer.Lexer;
import com.company.Lexer.Token;

import java.util.HashSet;

public class ParsFunDefinitionExpression extends AbstractParser
{
	HashSet<String> expressionTypes = new HashSet<>();
	public ParsFunDefinitionExpression()
	{
		expressionTypes.add("ConstantExpression");
		expressionTypes.add("BinaryExpression");
		expressionTypes.add("IfExpression");
		expressionTypes.add("CallExpression");
		expressionTypes.add("VariableExpression");
	}

	public Expression parse(Lexer.TokenList tokensList, ProgrammTree programmTree)
	{
		int start_idx = tokensList.getTokenIndex();

		boolean isFuncDiffinition = true;
		String name = "";
		Expression paramsList = null;
		Expression body = null;

		Token t = tokensList.getNextToken();

		if(t.type.equals("identifier"))
		{
			name = t.value;
			paramsList = parseNextExpression(tokensList, programmTree);
		}
		else
			isFuncDiffinition = false;

		if(isFuncDiffinition && !paramsList.isEmpty() && paramsList.getType().equals("ParametersListExpression"))
			t = tokensList.getNextToken();
		else
			isFuncDiffinition = false;

		if(isFuncDiffinition && t.value.equals("="))
			t = tokensList.getNextToken();
		else
			isFuncDiffinition = false;

		if(t.value.equals("{"))
			body = parseNextExpression(tokensList, programmTree);
		else
			isFuncDiffinition = false;

		if(isFuncDiffinition && !body.isEmpty() && expressionTypes.contains(body.getType()))
			t = tokensList.getNextToken();
		else
			isFuncDiffinition = false;

		if(isFuncDiffinition && t.value.equals("}"))
		{
			FunDifinitionExpression function = new FunDifinitionExpression(name, paramsList, body);
			programmTree.addFunction(name, function);
			return function;
		}
		
		tokensList.setTokenIndex(start_idx);
		return new Expression();
	}
}

