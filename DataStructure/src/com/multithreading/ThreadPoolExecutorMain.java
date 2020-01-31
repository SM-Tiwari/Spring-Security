package com.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMain {

	public static void main(String[] args) {
		BlockingQueue queue = new LinkedBlockingQueue(4);
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		RejectTaskHandler rth = new RejectTaskHandler();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2, 10L, TimeUnit.MILLISECONDS, queue, rth);
		for(int i=0;i<10;i++) {
			FetchDataFromFile fdff = new FetchDataFromFile("File"+i);
			System.out.println("A new File has been to read file: "+fdff.getFileName());
			threadPoolExecutor.execute(fdff);
		}
		
		threadPoolExecutor.shutdown();

	}

}
