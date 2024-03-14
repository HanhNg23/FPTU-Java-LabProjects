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
