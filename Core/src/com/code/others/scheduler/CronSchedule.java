/* ----------------------------------------------------------------
 * Nombre de la Clase:  CronSchedule.java
 * Version: 1.0
 * Fecha:Mar 17, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others.scheduler;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> CronSchedule.java
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
public class CronSchedule {
	
	public static void startScedule() throws Exception {
		
		SchedulerFactory sf = new StdSchedulerFactory();
		//Scheduler sched = sf.getScheduler();
		JobDetail jd = new JobDetail("job1", "group1", CronJob.class);
		CronTrigger ct = new CronTrigger("cronTrigger", "group2", "0 0/1 * * * ?");
		//sched.scheduleJob(jd,ct);
		//sched.start();
	} // startScedule() ends...

} // class CronSchedule ends...

