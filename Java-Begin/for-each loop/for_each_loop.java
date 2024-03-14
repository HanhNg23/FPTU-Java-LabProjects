import java.util.ArrayList;

public class for_each_loop {
	public static void main(String[] args) {
	//Create array list
		//Method 1
		System.out.println("----Method 1----");
		String[] food = { "Banana", "Coca", "Coconut", "Bimbim"};
		for(String i : food) { //this is call for_each_loop
			System.out.println(i);
		}
		
		//Method 2
		System.out.println("----Method 2----");
		ArrayList<String> food1 = new ArrayList<String>();
		food1.add("Banna");
	    food1.add("Soju");
	    food1.add("Banda");
	    food1.add("dog");
	    for(String j : food1) {
	    	System.out.println(j);
		   
	   }		
		
	}
}
