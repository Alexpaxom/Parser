package com.company.Lexer;

public interface LexToken
{

    String getToken();
	String getType();
	boolean addToToken(char simbol);
	void restart();
}