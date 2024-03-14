
public class Two_D_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] cars = { {"Red car", "Orange car", "Yellow car"}, 
				            {"Green car", "Lam car", "Blue car"}    };
		System.out.println(cars[1][2]);
		
		int[][] num = new int[2][3];
		num[0][0]= 1;
		num[0][1]= 2;
		num[0][2]= 3;
		num[1][0]= 4;
		num[1][1]= 5;
		num[1][2]= 6;
		
		for(int i = 0; i < 2; i++) {
			for(int j=0; j < 3; j++) {
				System.out.print("   " +num[i][j]);
			}
			System.out.println();
		}
		
		//ko khai bao kieu nay dc 
		//int[][] number = new int[2][3] = {{1,2,3}, {4,5,6}};
		
	}
}
