package com.java8;

public class RefernceToStaticMethod {

	public static void main(String[] args) {
		Thread thread = new Thread(()->System.out.println("Thread is running using lambda...."));
		thread.start();
		
		Thread t2 = new Thread(RefernceToStaticMethod::threadStatus);
		t2.start();

	}
	
	public static void threadStatus() {
		System.out.println("Thread is running....");
	}

}
