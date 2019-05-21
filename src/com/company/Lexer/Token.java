package com.company.Lexer;

public class Token
{
	public String type = "";
	public String value = "";
	
	public Token()
	{
	}
	
	public Token(String type, String value)
	{
		this.type = type;
		this.value = value;
	}
}