package com.kas.designpat.Factory;
public class TestFactoryPattern {
  public static void main(String[] args) {
    System.out.println(CarFactory.buildCar(CarType.SMALL));
    System.out.println(CarFactory.buildCar(CarType.SEDAN));
    System.out.println(CarFactory.buildCar(CarType.LUXURY));
  }
}

//https://howtodoinjava.com/design-patterns/creational/implementing-factory-design-pattern-in-java/
//https://howtodoinjava.com/design-patterns/creational/abstract-factory-pattern-in-java/