
import java.util.Scanner;

public class usingWhile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = "";
		
		while(name.isBlank()) {
			System.out.println("Enter your name: ");
			name = input.nextLine();
		}
		System.out.println("Your name is: "+name);
		
    	do {
	    	System.out.println("Enter your name: ");
	    	name = input.nextLine();	
    	}while(name.isBlank());
     	System.out.println("Your name2 is: "+name);
     	
     	for(int i = 0; ; i++) {
     		System.out.println("      **");
     		System.out.println("     **");
     		System.out.println("    **");
     		System.out.println("   **");
     		System.out.println("  **");
     		System.out.println(" **");
     		System.out.println(" **");
     		System.out.println("  **");
     		System.out.println("   **");
     		System.out.println("    **");
     		System.out.println("     **");
     		System.out.println("      **");
     		System.out.println("      **");
     		System.out.println("     **");
     		System.out.println("    **");
     		System.out.println("   **");
     	}
	
	
	} 
}
/*Note: String.isBlank() - return True if the string is "empty" or contains only "white space codepoints"
- otherwise false
String.isEmpty() - returns true if, and only if, string length is 0.
System.out.println( "ABC".isEmpty() );   //false
System.out.println( "  ".isEmpty() );   //false
System.out.println( "".isEmpty() );    //True
*/