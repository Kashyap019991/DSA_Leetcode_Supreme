package com.kas.designpat.Factory2;
public class TestFactory {
	///https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}
}

/*
The Factory pattern can almost be seen as a simplified version of the Builder pattern.

In the Factory pattern, the factory is in charge of creating various subtypes of an object depending on the needs.

The user of a factory method doesn't need to know the exact subtype of that object. An example of a factory method createCar might return a Ford or a Honda typed object.

In the Builder pattern, different subtypes are also created by a builder method, but the composition of the objects might differ within the same subclass.

To continue the car example you might have a createCar builder method which creates a Honda-typed object with a 4 cylinder engine, or a Honda-typed object with 6 cylinders. The builder pattern allows for this finer granularity.
*/