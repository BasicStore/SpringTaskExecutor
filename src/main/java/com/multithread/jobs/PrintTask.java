package com.multithread.jobs;

public class PrintTask extends GenericTask implements Runnable {
	
	public PrintTask(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		recordStart();
		System.out.println(name + " is running");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " is running out");
		
		recordEnd();
	}

}
