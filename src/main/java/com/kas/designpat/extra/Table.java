package com.kas.designpat.extra;
public class Table 
{
void printTable(int n) // Here, method is not synchronized.
{
for(int i = 1; i <= 50; i++)
{  
 System.out.println(Thread.currentThread() + "   :"+n * i);  
/*try
 {  
    Thread.sleep(400);  
 }
catch(InterruptedException ie)
{
   System.out.println(ie);
 } */
 }}  
}
