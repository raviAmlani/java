
package com.code.main;

public class Thread_1_1 implements Runnable{
	
	private final int limit;
	private volatile int sum;
	private int num;
	
	public Thread_1_1(int i, int num) {
		this.limit = i;
		this.num = num;
	}

	@Override
	public void run() {
		synchronized (this) {	// try removing sync.
			 for(int i=0; i < limit; i++){
				 	System.out.println("Inside for : "+num);
					sum+=5;
				}
				System.out.println("Thread --> "+num+", Sum --> "+sum);	
		}
	}
	
	
}

