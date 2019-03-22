package com.multithread.events.poc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import com.multithread.jobs.SheepJob;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
	
	@Autowired
    private ThreadPoolTaskExecutor sheepExec; // actually, this is the very same task executor used in SpringTaskExecutorApplication
			
	@Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage() + " \n======>" + event.getSheep().toString());
        
        System.out.println("Now, save the sheep to the database in a new thread......");
        sheepExec.execute(new SheepJob(event.getSheep()));
    }

	
}
