package com.company.Lexer;

public class FunctionExprLexToken implements LexToken
{
	String buffer = "";
	
	public String getToken()
	{
		return buffer;
	}
	
	public String getType()
	{
		return "func";
	}
	
	public void restart()
	{
		buffer = "";
	}
	
	public boolean addToToken(char simbol)
	{
		if(buffer.length() < 1)
			switch(simbol)
			{
				case ',':
					buffer = buffer + simbol;
					return true;
			}
		
		return false;
	}
}