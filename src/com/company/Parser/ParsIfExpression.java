package com.company.Parser;

import com.company.Lexer.Lexer;
import com.company.Lexer.Token;

import java.util.HashSet;

public class ParsIfExpression extends AbstractParser
{
	HashSet<String> expressionTypes = new HashSet<>();

	public ParsIfExpression()
	{
		expressionTypes.add("ConstantExpression");
		expressionTypes.add("BinaryExpression");
		expressionTypes.add("IfExpression");
		expressionTypes.add("CallExpression");
	}

	public Expression parse(Lexer.TokenList tokensList)
	{
		int start_idx = tokensList.getTokenIndex();
		
		boolean isIfExpr = true;
		
		Token t = tokensList.getNextToken();
		Expression condition = null;
		Expression ifTrueExpr = null;
		Expression ifFalseExpr = null;
		
		if(t.value.equals("["))
			condition = parseNextExpression(tokensList);
		else
			isIfExpr = false;

		String groupToken = "";

		if(isIfExpr && !condition.isEmpty() && expressionTypes.contains(condition.getType()))
			groupToken = tokensList.getNextToken().value + tokensList.getNextToken().value + tokensList.getNextToken().value;
		else
			isIfExpr = false;

		if(groupToken.equals("]?{"))
			ifTrueExpr = parseNextExpression(tokensList);
		else
			isIfExpr = false;

		if(isIfExpr && !ifTrueExpr.isEmpty() && expressionTypes.contains(ifTrueExpr.getType()))
			groupToken = tokensList.getNextToken().value + tokensList.getNextToken().value + tokensList.getNextToken().value;
		else
			isIfExpr = false;

		if(groupToken.equals("}:{"))
			ifFalseExpr = parseNextExpression(tokensList);
		else
			isIfExpr = false;

		if(isIfExpr && !ifFalseExpr.isEmpty() && expressionTypes.contains(ifFalseExpr.getType()))
			t = tokensList.getNextToken();
		else
			isIfExpr = false;

		if(t.value.equals("}"))
		{
			System.out.println("Success ifxpr;");
			return new IfExpression(condition, ifTrueExpr, ifFalseExpr);
		}

		tokensList.setTokenIndex(start_idx);
		return new Expression();
	}
}