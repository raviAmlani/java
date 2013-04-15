/* ----------------------------------------------------------------
 * Nombre de la Clase:  Operators.java
 * Version: 1.0
 * Fecha:Mar 18, 2013
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.ravi.scjp;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> Operators.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Mar 18, 2013
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class Operators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ------------------- instance of ------------------------------------------
		
		System.out.println("\n------------------- instance of ------------------------------------------");
		int []a = new int[3];
		System.out.println("a instanceof Object: "+a instanceof Object);
		System.out.println("a[0] instanceof Object: "+a[0] instanceof Object);
		
		Operators []op = new Operators[1];
		op[0] = new Operators();
		System.out.println("op instanceof Object: "+op instanceof Object);
		//System.out.println(op instanceof Operators);  // Compilation Error
		System.out.println("op[0] instanceof Object: "+op[0] instanceof Object);
		
		//"op[0] instanceof Object: "+
		System.out.println(op[0] instanceof Operators);
		

		// ------------------- Concatenation ------------------------------------------
		
		System.out.println("\n------------------- Concatenation ------------------------------------------");
		String s = "abc";
		int b = 3;
		int c = 3;
		// in "+" operator, if left side of operands starts with String or Char then concatenation will be done. Otherwise addition.
		System.out.println(s + b + c);
		System.out.println(b + c + s);
		System.out.println("" + b + c + s);
		System.out.println("" + (b + c) + s);
		System.out.println(s + 1);
		
		// ------------------- XOR and bitwise right ------------------------------------------
		
		System.out.println("\n------------------- XOR and bitwise right ------------------------------------------");
		System.out.println(findNumberOfBits(12, 16));
		
	}
	
	
	
	public static int findNumberOfBits(int x, int y)
	{
	int bitCount = 0;

	int z = x ^ y;  //XOR x and y

	while (z != 0)
	{
	  //increment count if last binary digit is a 1:
	  bitCount += z & 1; 
	  z = z >> 1;  //shift Z by 1 bit to the right
	}

	return bitCount;
	}


}

