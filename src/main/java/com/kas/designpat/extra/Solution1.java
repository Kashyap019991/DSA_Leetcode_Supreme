
package com.kas.designpat.extra;
import java.util.*;

class Employee{
    static int emp_id =0;
    String name;
    int age;
    Scanner sc = new Scanner(System.in);
    public void getData(){
        this.name = sc.next();
        this.age = sc.nextInt();
    }
    public void putData(){
        System.out.println(this.name +" "+ this.age);
    }
}
class SuperVisor extends Employee{
    
    int num_of_staff;
    SuperVisor(){
        super.emp_id = super.emp_id+1;
    }
    public void getData(){
        String inp = sc.next();
        String[] ip = inp.split("\\s+");
        this.name = ip[0];
        this.age = Integer.parseInt(ip[1]);
        this.num_of_staff = Integer.parseInt(ip[2]);
        
    }
    public void putData(){
        System.out.println(this.name +" "+ this.age + " "+this.num_of_staff + " "+ super.emp_id);
    }
    
}
class DeliveryExec extends Employee{
    DeliveryExec(){
        super.emp_id = super.emp_id+1;
    }
    int[] distances = new int[6];
    int totalDistance =0;
    public void getData(){
        String inp = sc.next();
        String[] ip = inp.split("\\s+");
        this.name = ip[0];
        this.age = Integer.parseInt(ip[1]);
        
        for(int i=0;i<6;i++){
            distances[i] = sc.nextInt(); 
        }
        
        
    }
    public void putData(){
        
        for(int i=0;i<6;i++){
            totalDistance += distances[i];
        }
        System.out.println(this.name +" "+ this.age + " "+this.totalDistance + " "+ super.emp_id);
    }
}

public class Solution1 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
    
    Scanner sc1 = new Scanner(System.in);
    String s = sc1.nextLine();
    int n = sc1.nextInt();
    
    Employee[] empArr = new Employee[n];
    
    for(int i=0;i<n;i++){
        String type = sc1.next();
        if(type.equals("1")){
            empArr[i] = new SuperVisor();
        }
        else
            empArr[i] = new DeliveryExec();
        try{    
        empArr[i].getData();}
       catch(Exception e){
           
       } 
    }
    
    for(int i=0;i<n;i++)
    {
        empArr[i].putData();
    }
    
    }
}