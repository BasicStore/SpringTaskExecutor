package com.multithread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.multithread.dm.Sheep;
import com.multithread.events.poc.MyEvent;
import com.multithread.events.poc.MyEventListener;
import com.multithread.events.poc.MyEventPublisher;
import com.multithread.jobs.PrintTask;


@SpringBootApplication
public class SpringTaskExecutorApplication implements CommandLineRunner {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
	
    @Autowired
    private MyEventPublisher myEventPublisher;
    
    @Autowired
    private MyEventListener myEventListener;
    
    
	public static void main(String[] args) {
		SpringApplication.run(SpringTaskExecutorApplication.class, args);
	}
		
	@Override  
	public void run(String... args) throws Exception {
	    System.out.println("=========> preparing to set tasks running..........");
	    
	    taskExecutor.execute(new PrintTask("Thread 1"));
	    taskExecutor.execute(new PrintTask("Thread 2"));
	    taskExecutor.execute(new PrintTask("Thread 3"));
	    taskExecutor.execute(new PrintTask("Thread 4"));
	    taskExecutor.execute(new PrintTask("Thread 5"));
	    
		///////////////////////////////////////////////
		System.out.println("=========> now sending a sheep event..........");
		Sheep sheep = new Sheep("sheepName", "sheepAlias", "greenGrass", "prince");
		MyEvent event = new MyEvent(this, "Some message goes here", sheep);
		myEventPublisher.publishAnEvent(event);
		///////////////////////////////////////////////
	    
		// shutdown the executor once all the threads have completed
		for (;;) { // infinite for loop
			int count = taskExecutor.getActiveCount();
			System.out.println("Active Threads : " + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count == 0) {
				taskExecutor.shutdown();
				break; // cuts out of infinite for loop
			}
		}
	}
		
}
	


