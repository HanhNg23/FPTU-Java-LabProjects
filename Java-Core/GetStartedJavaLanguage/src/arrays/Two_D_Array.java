package arrays;

/***
 * <strong>Topic: Creating, Initializing, and Accessing Two Directions Array</strong>
 ***/
public class Two_D_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] cars = {{"Red car", "Orange car", "Yellow car"}, 
				           {"Green car", "Lam car", "Blue car"}};
		System.out.println("----- List the car items -----");
		System.out.println("cars row count: " + cars.length);
		System.out.println("cars column count: " + cars[0].length);
		
		for(int row = 0; row < cars.length; row++)
		{
			for(int col = 0; col < cars[0].length; col++) {
				System.out.print("["+row+"]["+col+"] " + cars[row][col] + "    ");
			}
			System.out.println();
		}
		
		int[][] num = new int[2][3];
		//int[][] number = new int[2][3] = {{1,2,3}, {4,5,6}};
		num[0][0]= 1;
		num[0][1]= 2;
		num[0][2]= 3;
		num[1][0]= 4;
		num[1][1]= 5;
		num[1][2]= 6;
		System.out.println("\n----- List the number in the integer 2D arrays -----");
		for(int i = 0; i < 2; i++) {
			for(int j=0; j < 3; j++) {
				System.out.println("index["+i+"]["+j+"] " + num[i][j]);
			}
			System.out.println();
		}
		

		
	}
}
