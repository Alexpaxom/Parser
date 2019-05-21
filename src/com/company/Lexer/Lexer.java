package com.company.Lexer;
import java.util.ArrayList;
import java.text.ParseException;


public class Lexer
{
	// регистрируем стандартный набор токенов
	LexToken checkTokens[] = {
		new NumberLexToken(),
		new IdentifierLexToken(),
		new BracketsLexToken(),
		new OperationsLexToken(),
		new	IfExprLexToken()
	}; 
	ArrayList<Token> tokensList = new ArrayList<Token>();
	
	public TokenList parse(String prog) throws ParseException
	{
		System.out.println("Lexer Start!");
		
		
		char[] simols = prog.toCharArray();
		
		int i = 0;
		int lexerNum = 0;
		
		
		do 
		{
			if(checkTokens[lexerNum].addToToken(simols[i]))
			{
				do
				{
					i+=1;
				} while(i < simols.length && checkTokens[lexerNum].addToToken(simols[i]));
				
				tokensList.add( new Token(checkTokens[lexerNum].getType(), checkTokens[lexerNum].getToken()) );
				checkTokens[lexerNum].restart();
				lexerNum = 0;
			}
			else
			{
				if(lexerNum+1 >= checkTokens.length)
				{
					String err = "Unknown character str. 1 " + "pos. " + Integer.toString (i+1) + ": '" + simols[i] + "'";
					throw new ParseException(err, 0);
				}
				lexerNum+=1;
			}
				
		} while(i < simols.length);
		
		for(Token token : tokensList)
		{
			System.out.println(token.type+" : "+token.value);
		}
		
		return new TokenList(tokensList);
	}
	
	public class TokenList
	{
		ArrayList<Token> tokensList;
		int curToken = 0;
		
		public TokenList(ArrayList<Token> tokensList)
		{
			this.tokensList = tokensList;
		}
		
		public int getTokenIndex()
		{
			return curToken;
		}
		
		public void setTokenIndex(int inx)
		{
			curToken = inx;
		}
		
		
		public Token getNextToken()
		{
			if(tokensList.size() > curToken)
			{
				Token t = tokensList.get(curToken);
				this.curToken+=1;
				return t;
			}
			else
				return new Token();
		}
		
		public boolean endOfList()
		{
			if(tokensList.size() <= curToken)
				return true;
			return false;
		}
		
	}
}