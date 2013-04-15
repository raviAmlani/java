/* ----------------------------------------------------------------
 * Nombre de la Clase:  SCJP_Ch5_IfElse.java
 * Version: 1.0
 * Fecha:Jun 11, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.main;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> SCJP_Ch5_IfElse.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Jun 11, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class SCJP_Ch5_IfElse {

	public static void main(String [] args){
		
		/**
		 * Below code states that 
		 * Inside IF one stmt allowed without braces. 
		 * But it its an IF block as an insider then also it will work.
		 */
		int a = 0;
		if(a<1)
		if(a<2)
			System.out.println("Inside inner IF");
		else
			System.out.println("Inside inner ELSE");
		
		boolean b = false;
		if(b = true){
			System.out.println("b became true");
		}
		
		b = true;
		if(b = false){
			System.out.println("b became false");
		}
		System.out.println(b);
		
		/**
		 * in below code,
		 * If IF does not have braces then also ELSE can have.
		 * But IF must have only one stmt OR another IF block.
		 */
/*		if(a<1)
			System.out.println("Inside 2nd IF 1");
			System.out.println("Inside 2nd IF 2");
			else{
				
			}*/
	}
}

