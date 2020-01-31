package com.multithreading;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectTaskHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		FetchDataFromFile fdff = (FetchDataFromFile) r;
		System.out.println("Sorry!! We won't to read file: "+ fdff.getFileName());
		
	}

}
