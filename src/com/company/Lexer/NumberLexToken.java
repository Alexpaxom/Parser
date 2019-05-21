package com.company.Lexer;

public class NumberLexToken implements LexToken
{
	String buffer = "";
	
	public String getToken()
	{
		return buffer;
	}
	
	public String getType()
	{
		return "number";
	}
	
	public void restart()
	{
		buffer = "";
	}
	
	public boolean addToToken(char simbol)
	{
		switch(simbol)
		{
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				buffer = buffer + simbol;
				return true;
		}
		
		return false;
	}
}