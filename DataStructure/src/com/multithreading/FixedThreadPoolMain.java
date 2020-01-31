package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolMain {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		for(int i=1;i<=6;i++) {
			LoopTask loopTask = new LoopTask("LoopTask "+i);
			es.submit(loopTask);
		}
		es.shutdown();

	}

}
