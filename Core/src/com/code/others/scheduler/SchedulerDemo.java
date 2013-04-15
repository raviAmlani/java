/* ----------------------------------------------------------------
 * Nombre de la Clase:  SchedulerDemo.java
 * Version: 1.0
 * Fecha:Mar 17, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others.scheduler;

import java.util.Date;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> SchedulerDemo.java
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
public class SchedulerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("DEMO OF CRON JOB...STARTED AT : "+new Date());
		
		try {
			CronSchedule.startScedule();
		} catch (Exception e) {
			System.out.println("EXECUTION TERMINATED... !!!");
			e.printStackTrace();
		}
	}

}

