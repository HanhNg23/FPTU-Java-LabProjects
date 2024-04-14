package arrays;

/***
 * <strong>Topic: Creating, Initializing, and Accessing an One Direction Array</strong>
 ***/
public class One_D_Array {
		public static void main(String[] args) {
			/*Type 1*/ 
			String[] food_array = {" " ," " ," " ," " }; 
			food_array[0] = "Banana";
			food_array[1] = "Campuchia";
			food_array[2] = "Sandwitch";
			food_array[3] = "Dooki";
			System.out.println("food[0]: " + food_array[0]);
			
			int[] integer_aray = { 0, 0, 0, 0};
			integer_aray[0] = 1;
			integer_aray[1] = 2;
			integer_aray[2] = 3;
			integer_aray[3] = 4;
			System.out.println("integer_aray[0]: " + food_array[0]);
			
			/*Type 2*/
			String[] food_array2 = {"Banana", "Campuchia", "Sandwitch", "Dooki"};
			int[] integer_aray2 = {1, 2, 3, 4};
			System.out.println("food_array2[0]: " + food_array2[0]);
			System.out.println("integer_aray2[0]: " + integer_aray2[0]);
			
			
			/*Type 3*/
			String[] food_array3 = new String[5];
			food_array3[0] = "Banana";
			food_array3[1] = "Campuchia";
			food_array3[2] = "Sandwitch";
			food_array3[3] = "Dooki";	
			System.out.println("food_array3[0]: " + food_array3[0]);
		}
	}

