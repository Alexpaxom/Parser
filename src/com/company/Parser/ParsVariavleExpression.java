package com.company.Parser;

import com.company.Lexer.Lexer;
import com.company.Lexer.Token;

public class ParsVariavleExpression extends AbstractParser
{
	public Expression parse(Lexer.TokenList tokensList, ProgrammTree programmTree)
	{	
		int start_idx = tokensList.getTokenIndex();
		
		Token t = tokensList.getNextToken();

		if(t.type == "identifier")
		{
			return new VariableExpression(t.value, null);
		}
		else
		{
			tokensList.setTokenIndex(start_idx);
			return new Expression();
		}
	}
}