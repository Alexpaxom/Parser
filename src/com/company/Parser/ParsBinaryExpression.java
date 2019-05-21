package com.company.Parser;
import com.company.Lexer.*;

import java.util.ArrayList;

public class ParsBinaryExpression extends AbstractParser
{
	public Expression parse(Lexer.TokenList tokensList)
	{
		int start_idx = tokensList.getTokenIndex();
		
		boolean isBinaryExpr = true;
		
		Token t = tokensList.getNextToken();
		Expression oper1 = new Expression();
		Expression oper2 = new Expression();
		String operation = "";
		
		if(t.value.equals("("))
			oper1 = parseNextExpression(tokensList);
		else
			isBinaryExpr = false;
		
		if((isBinaryExpr && !oper1.isEmpty()) && (oper1.getType().equals("ConstantExpression") || oper1.getType().equals("BinaryExpression")))
			t = tokensList.getNextToken();
		else	
			isBinaryExpr = false;
		
		if(isBinaryExpr && t.type.equals("operation"))
		{
			operation = t.value;
			oper2 = parseNextExpression(tokensList);
		}
		else
			isBinaryExpr = false;
		
		if((isBinaryExpr && !oper2.isEmpty()) && (oper2.getType().equals("ConstantExpression") || oper2.getType().equals("BinaryExpression")))
			t = tokensList.getNextToken();
		else	
			isBinaryExpr = false;
		
		if(isBinaryExpr && t.value.equals(")"))
		{
			System.out.println("Success binexpr;");
			return new BinaryExpression(oper1, oper2, operation);
		}
		else	
			isBinaryExpr = false;
		
		tokensList.setTokenIndex(start_idx);
		return new Expression();
	}
}