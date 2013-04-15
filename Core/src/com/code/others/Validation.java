/* ----------------------------------------------------------------
 * Nombre de la Clase:  Validation.java
 * Version: 1.0
 * Fecha:Feb 1, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.util.Scanner;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> Validation.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Feb 1, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class Validation {

	
		//String input = "2000_2012_12";
		//[0-9]{4}_[0-9]{4}_[0-9]+ 
	
	public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        /*System.out.print("Enter Name: ");
        String name = console.nextLine();
        while (validateName(name) != true) {
                System.out.print("Invalid Name!");
                System.out.println();
                System.out.print("Enter Name: ");
                name = console.nextLine();
        }*/
        
        String input = "2000_2012_1236546";
        System.out.println(validateName(input));
        
        
	} // main() ends...
	
	public static boolean validateName(String name) {
        //return name.matches("\\p{Upper}(\\p{Lower}+\\s?)");
		//return name.matches("[0-9]{4}_[0-9]{4}_[0-9]+");
		return name.matches("\\d{4}_\\d{4}_\\d+");
	}
	
} // Class ends...

