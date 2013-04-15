/* ----------------------------------------------------------------
 * Nombre de la Clase:  ClassAB.java
 * Version: 1.0
 * Fecha:Jan 24, 2013
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.ravi.inheritanceTest;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> ClassAB.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Jan 24, 2013
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class ClassAB implements InterfaceA, InterfaceB{

	@Override
	public void add() {
		
		System.out.println("Inside add");
		
	}
	
	public static void main(String [] args){
		
		ClassAB classAB = new ClassAB();
		classAB.add();
		
		InterfaceA interfaceA = new ClassAB();
		interfaceA.add();
		
		InterfaceB interfaceB = new ClassAB();
		interfaceB.add();
		
	}

}

