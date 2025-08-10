package com.kas.dsasupreme.extra_classes;/*

//Java program to illustrate
//how hashCode() and equals() methods work
import java.io.*;
import java.util.HashMap;

class Geek
{
	
	public String name;
	public int id;
		
	Geek(String name, int id)
	{
			
		this.name = name;
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		
	// checking if both the object references are
	// referring to the same object.
	if(this == obj)
			return true;
		
		// it checks if the argument is of the
		// type Geek by comparing the classes
		// of the passed argument and this object.
		// if(!(obj instanceof Geek)) return false; ---> avoid.
		if(obj == null || obj.getClass()!= this.getClass())
			return false;
		
		// type casting of the argument.
		Geek geek = (Geek) obj;
		
		// comparing the state of argument with
		// the state of 'this' Object.
		return (geek.name == this.name && geek.id == this.id);
	}
	
	@Override
	public int hashCode()
	{
		
		// We are returning the Geek_id
		// as a hashcode value.
		// we can also return some
		// other calculated value or may
		// be memory address of the
		// Object on which it is invoked.
		// it depends on how you implement
		// hashCode() method.
		return this.id;
	}
	
}

//Driver code
class GFG
{
	
	public static void main (String[] args)
	{//personList.stream()
		//.sorted(Comparator.comparing(Person::getPersonId)
		//.thenComparing(Person::getAge))
		//.forEach(person -> System.out.println(person.getName())); //Sorting by person id and then by age.
	
		// creating the Objects of Geek class.
		Geek g1 = new Geek("aa", 1);
		Geek g2 = new Geek("aa", 1);
		
		// comparing above created Objects.
		HashMap<Geek, String> hm =new HashMap<>();
		hm.put(g1,"one");
		hm.put(g2, "two");
		
		System.out.println(hm.get(g1));
		System.out.println(hm.get(g2));
		
		System.out.println(hm.get(new Geek("aa", 1)));
		if(g1.hashCode() == g2.hashCode())
		{

			if(g1.equals(g2))
				System.out.println("Both Objects are equal. ");
			else
				System.out.println("Both Objects are not equal. ");
	
		}
		else
		System.out.println("Both Objects are not equal. ");
	}
}
*/

/*import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
  
public class Hashone {
    public static void main(String[] args)
    {
  
        // Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map
            = new ConcurrentHashMap<String, Integer>();
  
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);
  
        // Getting an Iterator from map
        Iterator it = map.keySet().iterator();
  
        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.println(key + " : " + map.get(key));
  
            // This will reflect in iterator.
            // Hence, it has not created separate copy
            map.put("SEVEN", 7);
        }
    }
}*/
/*import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;
  
public class Hashone {
    public static void main(String args[])
    {
        CopyOnWriteArrayList<Integer> list
            = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Integer no = (Integer)itr.next();
            System.out.println(no);
            if (no == 8)
  
                // This will not print,
                // hence it has created separate copy
                list.add(14);
        }
        System.out.println(list);
    }
}*/

interface k1
{
    default String getGreeting() {
        return "Good Morning!";
    }
}

interface k2
{
    default String getGreeting() {
        return "Good Afternoon!";
    }
}

public class Hashone implements k1,k2 // won't compile
{
    public static void main(String[] args)
    {
        System.out.println(new Hashone().getGreeting());
    }

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return k1.super.getGreeting();
	}

	
}
