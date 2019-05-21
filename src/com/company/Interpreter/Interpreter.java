package com.company.Interpreter;
import com.company.Parser.*;
import com.company.Lexer.*;

import java.text.ParseException;

public class Interpreter extends AbstractInterpreter
{	
	Parser parser = new Parser();
	ProgrammTree porogTree = new ProgrammTree();
	
	public Expression interpretateProg(String prog) throws ParseException
	{	
		Lexer lexer = new Lexer();
		System.out.println("Start Interpreter!");
		Expression expr = parser.parse(lexer.parse(prog));
		
		porogTree.addExpression(expr);
		
		return interpretate(expr);
	}
	
	public Expression interpretate(Expression inExpr) throws ParseException
	{
		return  iterpretNextExpression(inExpr);
	}
}