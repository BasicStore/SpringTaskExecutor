package com.multithread.events.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher {

	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
 
    public void publishAnEvent(final MyEvent event) {
        System.out.println("Publishing custom event. ");        
        applicationEventPublisher.publishEvent(event);
    }
	
}
