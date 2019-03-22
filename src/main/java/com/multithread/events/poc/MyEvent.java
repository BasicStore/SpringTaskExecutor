package com.multithread.events.poc;
import org.springframework.context.ApplicationEvent;

import com.multithread.dm.Sheep;

public class MyEvent extends ApplicationEvent {
    private String message;
    private Sheep sheep;
    
    public MyEvent(Object source, String message, Sheep sheep) {
        super(source);
        this.message = message;
        this.sheep = sheep;
    }
    public String getMessage() {
        return message;
    }
	public Sheep getSheep() {
		return sheep;
	}
	public void setSheep(Sheep sheep) {
		this.sheep = sheep;
	}
    
}