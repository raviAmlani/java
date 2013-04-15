/* ----------------------------------------------------------------
 * Nombre de la Clase:  Thread_1.java
 * Version: 1.0
 * Fecha:Sep 19, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.main;

import java.util.ArrayList;
import java.util.List;

public class Thread_1 {
	
	static List<Thread> threads = new ArrayList<Thread>();
	public static  void main(String [] args){
		
		for(int i=0; i<10; i++){
			System.out.println("i is = "+i);
			Runnable task = new Thread_1_1(10, i);
			Thread t = new Thread(task);
			t.start();
			threads.add(t);
		}
		
		int running=0;
		do{
			running=0;
			for(Thread t:threads){
				if(t.isAlive()){
					running++;
				}
			}
			System.out.println("Total running outof 10 = "+running);
		}while(running>0);
	}
	
	
}

