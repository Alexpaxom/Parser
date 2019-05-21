package com.company.Parser;

import com.company.Lexer.Lexer;
import com.company.Lexer.Token;

import java.util.HashSet;

public class ParsParametersListExpression extends AbstractParser
{
	public ParsParametersListExpression()
	{
	}

	public Expression parse(Lexer.TokenList tokensList, ProgrammTree programmTree)
	{
		int start_idx = tokensList.getTokenIndex();

		boolean isParamsList = true;

		ParametersListExpression paramsList = new ParametersListExpression();
		VariableExpression parametr = null;

		Token t = tokensList.getNextToken();

		if(t.value.equals("("))
            t = tokensList.getNextToken();
		else
            isParamsList = false;

		while(true)
		{
			if (isParamsList && t.type.equals("identifier"))
			{
				if(paramsList.containsParam(t.value))
					break; // TODO найдено две переменных с одним названием
				parametr = new VariableExpression(t.value, null);
                paramsList.addParametr(parametr);
				t = tokensList.getNextToken();

				if(t.value.equals(")"))
				{
                    return paramsList;
                }
				else if(t.value.equals(","))
                    t = tokensList.getNextToken();
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