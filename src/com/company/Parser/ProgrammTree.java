package com.company.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ProgrammTree
{
	ArrayList<Expression> expressions = new ArrayList<Expression>();
	Map<String, Expression> functions = new HashMap<String, Expression>();
	Stack<Expression> functionStack = new Stack<>();

	public void addExpression(Expression expression)
	{
		expressions.add(expression);
	}
	public void addFunction(String name, Expression expression)
	{
		functions.put(name, expression);
	}
	public void pushOnFunctionStack(Expression expr)
	{
		functionStack.push(expr);
	}
	public Expression popFromFunctionStack()
	{
		return functionStack.pop();
	}
	public Expression peekFromFunctionStack()
	{
		return functionStack.peek();
	}


	public Expression getFunciton(String name)
	{
		return functions.get(name);
	}
}