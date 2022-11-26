// Program implements concepts of Abstract Classes.
// Driver.java contains other classes such as Cd.java and Classic.java.
// Author: Johnny Liang
// Date: September 28, 2022
// Course: Data Structure 

public class Driver {
    public static void main(String[] args)  
   { 
         
      System.out.println("\nCalling through Classic Object..."); 
      System.out.println("*************************************");
      // create an object of Classic class and call Report method. Use the below data: 
      
      Classic classicDisk = new Classic("Fantasia in C", "Alfred Brendel", "Philips", 2, 57.17);
      classicDisk.Report();
   
   
      System.out.println("\nCalling through CD Object..."); 
      System.out.println("*************************************"); 
      
      // create another object of Classic class and assign it to the reference of the   
      //   parent class (CD class). Finally, call the Report method using the reference of  
      //   the parent class. Use the below data: 
   
      Classic classicDisk2 = new Classic(null, "Beatles", "Capitol", 14, 35.5);
      Cd Cd2 = classicDisk2;
      Cd2.Report();
   }
}
