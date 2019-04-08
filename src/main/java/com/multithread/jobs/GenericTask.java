package com.multithread.jobs;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class GenericTask {

	private static Map<String, State> taskMap = new HashMap<String, State>();
	
	private ResourceBundle bundle = ResourceBundle.getBundle("application");
	
	private String taskId;
	
	private State state;
	
	protected String name;
	
	
	public GenericTask(String name) {
		this.name = name;
	}
	
	
	private boolean isProfilingOn() {
		String profilingOn = bundle.getString("profiling.on");
		return (profilingOn != null && profilingOn.toUpperCase().equals("TRUE")) ? true : false;		
	}
	
	
	public void recordStart() {
		if (isProfilingOn()) {
			state = new State();
			System.out.println(name + ": " + state.toString());
		}
	}
	
	
	public void recordEnd() {
		if (isProfilingOn()) {
			state.completeTask();
			System.out.println(name + ": " + state.toString());
		}
	}
    
	
	
	public class State {
		
		private LocalDateTime startTime;
		private long start;
		
		private LocalDateTime endTime;
		private long end;

		private Long duration;
		private boolean complete;
		
		public State() {
			this.startTime = LocalDateTime.now();
			start = System.currentTimeMillis();
		}

		public void completeTask() {
			endTime = LocalDateTime.now();
			end = System.currentTimeMillis();
			duration = end - start;
			this.complete = true;
		}
		
		
		public LocalDateTime getStartTime() {
			return startTime;
		}

		public LocalDateTime getEndTime() {
			return endTime;
		}

		public boolean isComplete() {
			return complete;
		}
		
		public String toString() {
			if (startTime != null) {
				StringBuilder output = new StringBuilder("Started: " + startTime.toString());
				
				if (duration != null) {
					output.append(" Completed: " + endTime.toString());
					output.append(" Duration: " + duration + "ms  ");
				}
				
				return output.toString();
			}
			
			return "Profiling not available";
		}
		
	}
	
}
