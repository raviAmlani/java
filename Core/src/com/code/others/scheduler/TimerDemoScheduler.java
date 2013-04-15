/* ----------------------------------------------------------------
 * Nombre de la Clase:  TimerDemoScheduler.java
 * Version: 1.0
 * Fecha:Mar 17, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others.scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> TimerDemoScheduler.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Mar 17, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class TimerDemoScheduler extends TimerTask{

	private int id = 0;
	private static int inc = 0;
	
	public TimerDemoScheduler(){
		// Do nothing.
	}
	
	public TimerDemoScheduler(int id){
		this.id = id;
	}
	
	@Override
	public void run() {

		System.out.println("task run : --------------------------------------- "+ new Date() + " - "+id + " - "+inc);
		inc++;
		//cancel();
		
	}
}

