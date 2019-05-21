package com.company.Parser;
import com.company.Lexer.*;

import java.util.ArrayList;

public class ParsConstantExpression extends AbstractParser
{
	public Expression parse(Lexer.TokenList tokensList)
	{	
		int start_idx = tokensList.getTokenIndex();
		
		Token t = tokensList.getNextToken();
		
		String res_val = "";

		if(t.value.equals("-"))
		{
			t = tokensList.getNextToken();
			//System.out.println(t.value);
			res_val = "-";
		}
		
		if(t.type == "number")
		{
			res_val = res_val + t.value;
			System.out.println("Success constexpr;");
			return new ConstantExpression(res_val);
		}
		else
		{
			tokensList.setTokenIndex(start_idx);
			return new Expression();
		}
	}
}