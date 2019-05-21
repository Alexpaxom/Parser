package com.company.Lexer;

public class BracketsLexToken implements LexToken
{
	String buffer = "";
	
	public String getToken()
	{
		return buffer;
	}
	
	public String getType()
	{
		return "Brackets";
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
				case '(':
				case ')':
				case '{':
				case '}':
				case '[':
				case ']':
					buffer = buffer + simbol;
					return true;
			}
		
		return false;
	}
}