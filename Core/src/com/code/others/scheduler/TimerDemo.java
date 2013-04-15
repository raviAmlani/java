package com.code.others.scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("STARTING TimerDemo -- "+new Date());

		TimerDemoScheduler task = new TimerDemoScheduler(6);
		Timer timer = new Timer();
		timer.schedule(task, new Date(), 1000);
//		timer.cancel();
		
		/*for(int i = 0; i < 100; i++){
			System.out.println("--------> "+ i);
		}*/
	}

}
