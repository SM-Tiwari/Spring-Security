package com.multithreading;

public class LoopTask implements Runnable{
	
	private String loopTaskName;
	
	public LoopTask(String name) {
		super();
		this.loopTaskName=name;
		
	}

	@Override
	public void run() {
		System.out.println("Starting "+loopTaskName);
		for(int i=1;i<=10;i++) {
			System.out.println("Executing "+ loopTaskName +" with "+Thread.currentThread().getName()+"===="+i);
		}
		System.out.println("Ending "+ loopTaskName);
		
	}

}
