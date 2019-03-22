package com.multithread.jobs;

import com.multithread.dm.Sheep;

public class SheepJob implements Runnable {

	private Sheep sheep;
	
	private String status;
		
	public SheepJob(Sheep sheep) {
		this.sheep = sheep;
		this.status = "hungry";
	}
	
	@Override
	public void run() {
		System.out.println("Saving "+ status + " sheep to database.");
		System.out.println("Sheep:  "+ sheep.toString() + "     ======> SUCCESSFULLY saved to DATABASE");
	}
	
}
