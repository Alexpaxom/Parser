package com.company.Lexer;

public class IfExprLexToken implements LexToken
{
	String buffer = "";
	
	public String getToken()
	{
		return buffer;
	}
	
	public String getType()
	{
		return "ifoperand";
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
				case '?':
				case ':':
					buffer = buffer + simbol;
					return true;
			}
		
		return false;
	}
}