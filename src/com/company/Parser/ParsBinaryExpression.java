package com.company.Parser;
import com.company.Lexer.*;

import java.util.HashSet;

public class ParsBinaryExpression extends AbstractParser
{
	HashSet<String> expressionTypes = new HashSet<>();
	public ParsBinaryExpression()
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
		
		boolean isBinaryExpr = true;
		
		Token t = tokensList.getNextToken();
		Expression oper1 = new Expression();
		Expression oper2 = new Expression();
		String operation = "";
		
		if(t.value.equals("("))
			oper1 = parseNextExpression(tokensList, programmTree);
		else
			isBinaryExpr = false;
		
		if(isBinaryExpr && !oper1.isEmpty() && expressionTypes.contains(oper1.getType()))
			t = tokensList.getNextToken();
		else	
			isBinaryExpr = false;
		
		if(isBinaryExpr && t.type.equals("operation"))
		{
			operation = t.value;
			oper2 = parseNextExpression(tokensList, programmTree);
		}
		else
			isBinaryExpr = false;
		
		if(isBinaryExpr && !oper2.isEmpty() && expressionTypes.contains(oper2.getType()))
			t = tokensList.getNextToken();
		else	
			isBinaryExpr = false;
		
		if(isBinaryExpr && t.value.equals(")"))
		{
			return new BinaryExpression(oper1, oper2, operation);
		}
		
		tokensList.setTokenIndex(start_idx);
		return new Expression();
	}
}