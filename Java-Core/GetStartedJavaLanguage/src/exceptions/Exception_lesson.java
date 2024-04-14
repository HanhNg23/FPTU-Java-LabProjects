package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;


/***
 * Java Exceptions - When executing Java code, different errors can
 * occur: coding errors made by the programmer, errors due to wrong input, or
 * other unforeseeable things. ---> When an error occurs, Java will normally stop
 * and generate an error message. The technical term for this is: Java will
 * throw an exception (throw an error).
 * 
 * JAVA *try* and *catch 
 * - The "try" statement allows you to define a block of
 * code to be tested for errors while it is being executed.The try statement
 * allows you to define a block of code to be tested for errors while it is
 * being executed. 
 * - The "catch" statement allows you to define a block of
 * code to be executed, if an error occurs in the try block. 
 * --> The try and catch keywords come in pairs
 ***/
public class Exception_lesson {
     public static void main(String[] args) {
    	 
    	 Scanner scanner = new Scanner(System.in);
    	 int x, y, z;
    	 try {
    	 System.out.print("Input x: \n");
    	 x = scanner.nextInt();
    	 System.out.println("Input y: \n");
    	 y = scanner.nextInt();
    	 z = x / y;
    	 System.out.println("Input z = x / y : \n" +z);
    	 }
    	  catch(ArithmeticException e) {
    		  System.out.println("Error: Can't devided by zero");
    		  e.printStackTrace();
    	  }catch(InputMismatchException e) {
    		   System.out.println("Error: Input mismatch to the number type");
    		   e.printStackTrace();
    	  }catch(Exception e) {
    		  System.out.println("Error: Something went wrong");
    		  e.printStackTrace();
    	  }finally {
    		  System.out.println("\"Finish\" - This statement alway appears");
    	  }
    	  
	
     }
}
