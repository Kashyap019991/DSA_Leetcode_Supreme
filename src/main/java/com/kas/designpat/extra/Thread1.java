package com.kas.designpat.extra;
public class Thread1 extends Thread
{
  Table t; // Declaration of variable t of class type Table.

// Declare one parameterized constructor and pass variable t as a parameter.
   Thread1(Table t)
   {  
      this.t = t;  
   }  
  public void run()
  {  
    t.printTable(2);  
  }  
}
