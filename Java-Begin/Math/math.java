import java.util.Scanner;
import javax.swing.JOptionPane;


public class math {
	public static void main(String[] args) {
		//create object scanner
		Scanner input = new Scanner(System.in); 
		int x, y;
		//Input
		System.out.println("Hello math ");
		System.out.println("Input x: ");
		 x = input.nextInt();
		System.out.println("Input y: ");
		 y = input.nextInt();
		
/*
 Method             	Description
nextBoolean()	Reads a boolean value from the user
nextByte()	    Reads a byte value from the user
nextDouble()	Reads a double value from the user
nextFloat()	    Reads a float value from the user
nextInt()   	Reads a int value from the user
nextLine()  	Reads a String value from the user
nextLong()  	Reads a long value from the user
nextShort()  	Reads a short value from the user
*/
		//Output
		System.out.println("x + y = "+(x+y));
		System.out.println("x - y= " +(x-y));
		System.out.println("x * y = "+(x*y));
		System.out.println("x / y = "+(x/y));
		System.out.println("x % y = "+(x%y));
		//coppy this link to see more Math function https://www.w3schools.com/java/java_ref_math.asp
		System.out.print("acos(x) returns the arccosine of x, in radians = ");
		System.out.println(Math.acos(1));
		System.out.print("cos(x) returns the cosine of x, x in radians = ");
		System.out.println(Math.cos(1));
		System.out.print("max(x,y) returns the highest number ");
		System.out.println(Math.max(x, y));
		System.out.print("sqrt(x) Returns the square root of x ");
		System.out.println(Math.sqrt(x));
		System.out.print("pow(x,y) Returns the value of x to the power of y ");
		System.out.println(Math.pow(x, y));
		
		input.close(); //it doesn't necessary
		
		
		
		
		
		
		
		

	}

}
