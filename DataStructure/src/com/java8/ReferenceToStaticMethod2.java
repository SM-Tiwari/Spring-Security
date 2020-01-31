package com.java8;

import java.util.function.BiFunction;

class Arithmetic{
	public static int add(int a, int b) {
		
		return a+b;
		
		}
	
	public static float add(int a, float b) {
		
		return a+b;
		
	}
	
	public static float add(float a, float b) {
		
		return a+b;
		
	}
}

public class ReferenceToStaticMethod2 {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
		BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
		BiFunction<Float, Float, Float> adder3 = Arithmetic::add;
		int result1 = adder1.apply(5, 10);
		float result2 = adder2.apply(10, 20.5f);
		float result3 = adder3.apply(10.0f, 20.05f);
		System.out.println("first result:" + result1);
		System.out.println("second result:" + result2);
		System.out.println("third result:" + result3); 
	}
}
