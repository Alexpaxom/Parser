package com.company.Parser;
import com.company.Lexer.*;

import java.util.ArrayList;

public class Parser extends AbstractParser
{
	public Expression parse(Lexer.TokenList tokensList, ProgrammTree programmTree)
	{
		return parseNextExpression(tokensList, programmTree);
	}
}
