/* ----------------------------------------------------------------
 * Nombre de la Clase:  CronJob.java
 * Version: 1.0
 * Fecha:Mar 17, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others.scheduler;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> CronJob.java
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
public class CronJob implements Job{
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		 System.out.println("Welcome to Delogico  :"+new Date());		
	}
	
}

