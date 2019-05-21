package com.company.Lexer;

public class IdentifierLexToken implements LexToken
{
	String buffer = "";
	
	public String getToken()
	{
		return buffer;
	}
	
	public String getType()
	{
		return "identifier";
	}
	
	public void restart()
	{
		buffer = "";
	}
	
	public boolean addToToken(char simbol)
	{
		switch(simbol)
		{
			 case 'A' :
			 case 'B' :
			 case 'C' :
			 case 'D' :
			 case 'E' :
			 case 'F' :
			 case 'G' :
			 case 'H' :
			 case 'I' :
			 case 'J' :
			 case 'K' :
			 case 'L' :
			 case 'M' :
			 case 'N' :
			 case 'O' :
			 case 'P' :
			 case 'Q' :
			 case 'R' :
			 case 'S' :
			 case 'T' :
			 case 'U' :
			 case 'V' :
			 case 'W' :
			 case 'X' :
			 case 'Y' :
			 case 'Z' :
			 case 'a' :
			 case 'b' :
			 case 'c' :
			 case 'd' :
			 case 'e' :
			 case 'f' :
			 case 'g' :
			 case 'h' :
			 case 'i' :
			 case 'j' :
			 case 'k' :
			 case 'l' :
			 case 'm' :
			 case 'n' :
			 case 'o' :
			 case 'p' :
			 case 'q' :
			 case 'r' :
			 case 's' :
			 case 't' :
			 case 'u' :
			 case 'v' :
			 case 'w' :
			 case 'x' :
			 case 'y' :
			 case 'z' :
			 case '_' :
				buffer = buffer + simbol;
				return true;
		}
		
		return false;
	}
}