package com.company.Parser;

import com.company.Lexer.Lexer;
import com.company.Lexer.Token;

import java.util.HashSet;

public class ParsCallExpression extends AbstractParser
{
	public ParsCallExpression()
	{
	}

    public Expression parse(Lexer.TokenList tokensList, ProgrammTree programmTree)
	{
		int start_idx = tokensList.getTokenIndex();
		
		boolean isCallExpr = true;
		
		Token t = tokensList.getNextToken();
		String name = "";
		Expression args = null;
		
		if(t.type.equals("identifier"))
		{
			name = t.value;
			args = parseNextExpression(tokensList, programmTree);
		}
		else
			isCallExpr = false;
		
		if(isCallExpr && !args.isEmpty() && args.getType().equals("ArgumentListExpression"))
		{
			return  new CallExpression(name, args);
		}

		tokensList.setTokenIndex(start_idx);
		return new Expression();
	}
}