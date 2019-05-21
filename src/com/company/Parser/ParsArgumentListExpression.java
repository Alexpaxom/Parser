package com.company.Parser;

import com.company.Lexer.Lexer;
import com.company.Lexer.Token;

import java.util.HashSet;

public class ParsArgumentListExpression extends AbstractParser
{
	HashSet<String> expressionTypes = new HashSet<>();
	public ParsArgumentListExpression()
	{
		expressionTypes.add("ConstantExpression");
		expressionTypes.add("BinaryExpression");
		expressionTypes.add("IfExpression");
		expressionTypes.add("CallExpression");
	}

	public Expression parse(Lexer.TokenList tokensList, ProgrammTree programmTree)
	{
		int start_idx = tokensList.getTokenIndex();

		boolean isArgsList = true;

		ArgumentListExpression argsList = new ArgumentListExpression();
		Expression argument = null;

		Token t = tokensList.getNextToken();

		if(t.value.equals("("))
			argument = parseNextExpression(tokensList, programmTree);
		else
			isArgsList = false;

		while(true)
		{

			if (isArgsList && !argument.isEmpty() && expressionTypes.contains(argument.getType()))
			{
				argsList.addArgument(argument);
				t = tokensList.getNextToken();
				if(t.value.equals(")"))
				{
					return argsList;
				}
				else if(t.value.equals(","))
					argument = parseNextExpression(tokensList, programmTree);
				else
					break;
			}
			else
				break;
		}

		tokensList.setTokenIndex(start_idx);
		return new Expression();

	}
}