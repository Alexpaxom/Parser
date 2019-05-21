package com.company.Parser;

import java.util.HashMap;

public class ParametersListExpression extends Expression
{
	int numParams = 0;
	HashMap<String, Expression> indexParams = new HashMap<String, Expression>();

	public ParametersListExpression()
	{
		this.value = "ParamList";
		this.empty = false;
	}

	public void addParametr(VariableExpression var)
	{
		innerExpression.add(var);
		indexParams.put(var.value, var);
		numParams+=1;
	}

	public Expression getParamByName(String name)
	{
		//TODO бросить исключение если нету такого параметра
		return indexParams.get(name);
	}

	public boolean containsParam(String name)
	{
		return indexParams.containsKey(name);
	}

	public int getNumParams()
	{
		return numParams;
	}
	
	public String getType()
	{
		return "ParametersListExpression";
	}	
} 