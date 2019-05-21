package com.company;

import java.util.Scanner;
import java.text.ParseException;
import com.company.Interpreter.*;
import com.company.Parser.*;

public class Main
{
	public static void main(String argv[])
	{
		Interpreter itnterp = new Interpreter();
		Scanner in = new Scanner(System.in);
		String prog = "";
		Expression result = null;
		
		while(true)
		{
			System.out.print(">> ");
			prog = in.nextLine();
			if(prog.equals("~"))
				break;
			else if(!prog.equals(""))
			{
				try
				{
					result = itnterp.interpretateProg(prog);
				}
				catch(ParseException e)
				{
					System.out.println(e.getMessage());
					System.exit(0);
				}
				if(result.getType().equals("ConstantExpression"))
					System.out.println(result.value);
			}
		} 
		
		
	}
}