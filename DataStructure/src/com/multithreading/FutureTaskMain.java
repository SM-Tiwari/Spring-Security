package com.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskMain {

	public static void main(String[] args) {
		MultiplyingTask multiplyingTask1 = new MultiplyingTask(10, 20, 2000L);
		MultiplyingTask multiplyingTask2 = new MultiplyingTask(20, 40, 4000L);
		FutureTask<Integer> futureTask1 = new FutureTask<>(multiplyingTask1);
		FutureTask<Integer> futureTask2 = new FutureTask<>(multiplyingTask2);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(futureTask1);
		es.execute(futureTask2);
		while(true) {
			try {
				if(!futureTask1.isDone()) {
					System.out.println("FutureTask1 output="+futureTask1.get());
				}
				if(!futureTask2.isDone()) {
					System.out.println("Waiting for FutureTask2 for completion");
					System.out.println("FutureTask2 output "+futureTask2.get());
				}
				if(futureTask1.isDone() && futureTask2.isDone()) {
					System.out.println("Completed both the FutureTasks, Shutting down the executors");
					es.shutdown();
					return;
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}catch(ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
