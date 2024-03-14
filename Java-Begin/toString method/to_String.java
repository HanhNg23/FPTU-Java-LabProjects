
public class to_String {

	public static void main(String[] args) {
		/* TODO 
		 * toString() = special method that all objects inherits
		 *            = that returns a string that "textually represents" an object.
		 *            = can be used both implicitly and explicitly
		 * Basic example:         
		 *   short a = 515; int b = 345;
             // using toString()
             System.out.println("String value: "
                           + Short.toString(a)); 
             System.out.println("String value: "
                           + Integer.toString(b)); */ 
		
		
		                                        /*---------Start--------*/
		/*In this lesson we learn how to express  simultaneously all attributes of a class with different types */
		
		Milk_tea milktea = new Milk_tea();
	  //System.out.println(milktea); //Remember when we haven't yet overwriting the method toString 
		                            //The drafting of this clause will output the address of the CLASS Milk_tea in the memory
		
		//How to get expected result --> we move the class Milk_tea and overwriting the method toString();
	    System.out.println("syntax 1 \n" +milktea.toString());
	    System.out.println();
	    System.out.println("syntax 2 \n" +milktea);
		
		
		 
		

		
		
		
		
		
		
		
		
		
		
	}
}
