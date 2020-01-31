package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Sayable{
	
	void say(String msg);
	
}


public class FunctionalInterfacesExample {

	public static void main(String[] args) {
		
		//lambda expression
		Sayable sayable = (msg)->{System.out.println(msg); };
		sayable.say("Say something.....");
		
		//predefined Predicate Functional interface
		Predicate<Person> predicate = (person)->person.getAge()>28;
		
		boolean result = predicate.test(new Person("ramesh", 29));
		System.out.println(result);
		
		
		//predefined Function Functional interface
		//convert centigrade to farenheit
		Function<Integer, Double> centigradeToFarenheitInt = x-> new Double((x*9/5)+32);
		
		//convert String to an Integer
		Function<String, Integer> stringToInt = x-> Integer.valueOf(x);
		System.out.println("String to Int: "+ stringToInt.apply("4"));
		
		Function<Person, PesrosnDto> function = entity->{
			return new PesrosnDto(entity.getName(), entity.getAge());
		};
		
		PesrosnDto persondto = function.apply(new Person("ramesh", 29));
		System.out.println(persondto.getName());
		System.out.println(persondto.getAge());
		
		//predefined Supplier Functional interface
		Supplier<Person> supplier = ()->{
			return new Person("umesh", 30);
		};
		
		Person p = supplier.get();
		System.out.println(p.getName()+" "+ p.getAge());
		
		
		//predefined Consumer Functional interface
		List<Person> listOfPerson = new ArrayList<Person>();
		listOfPerson.add(new Person("abc", 27));
		listOfPerson.add(new Person("mno", 29));
		listOfPerson.add(new Person("pqr", 28));
		listOfPerson.add(new Person("xyz", 26));
		
		listOfPerson.forEach((person)->{
			System.out.println("Person name: "+person.getName());
			System.out.println("Person age: "+person.getAge());
		});
		
		Consumer<Person> consumer = (person)->{
			System.out.println("Person name: "+person.getName());
			System.out.println("Person age: "+person.getAge());
		};
		
		consumer.accept(new Person("Siddhesh", 35));
		
		
		
		
		

	}

}
