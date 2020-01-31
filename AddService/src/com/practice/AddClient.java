package com.practice;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

public class AddClient {

	public static void main(String[] args) {
		Calculator cal = new Calculator(); 
		CalculatorSoap calSoap = cal.getCalculatorSoap();  //stub
		System.out.println("Addition : "+calSoap.add(12, 14));
		System.out.println("Subtraction : "+calSoap.subtract(50, 25));

	}

}
