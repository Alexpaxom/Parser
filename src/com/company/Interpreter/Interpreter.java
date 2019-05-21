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
		Expression expr = parser.parse(lexer.parse(prog), porogTree);
		
		porogTree.addExpression(expr);
		
		return interpretate(expr, porogTree);
	}

	public Expression interpretate(Expression inExpr, ProgrammTree programmTree) throws ParseException
	{
		return  iterpretNextExpression(inExpr, programmTree);
	}
}