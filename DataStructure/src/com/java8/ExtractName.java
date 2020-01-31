package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractName {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Ram", 19));
		list.add(new Person("shyam", 20));
		list.add(new Person("Rahul", 21));
		list.add(new Person("Raghu", 22));
		list.add(new Person("Rokda", 33));
		list.add(new Person("Bharat", 44));
		list.add(new Person("Laxman", 23));
		List res = list.stream().map(Person::getName).collect(Collectors.toList());
		System.out.print(res);           
	}
	
}
