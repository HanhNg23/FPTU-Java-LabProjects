import java.util.Scanner;

public class Logical {
	public static void main(String[] args) {
		/*Logical operators = used to connect two or more expressions
		 *                   && = (AND)
		 *                   || = (OR)
		 *                   !  = (NOT) reverse boolean value of condition
		 */
		char choo = 'e';
		Scanner input = new Scanner(System.in);
		System.out.println("You are playing game ! Press p or Q to quit");
		String choose = input.nextLine();
		System.out.println(choose);
		if (choo == 'e') System.out.println("that is choo"); 
		//Kha báo kí tự rồi so sánh với ki tự thì đc nhưng nhập chuỗi mà kêu nó so sánh với kí tự 
		//là không đc phải dùng lệnh equals để so sánh chuỗi
		if(choose.equals("p") || choose.equals("Q")) 
			System.out.println("You quit the game");
		else System.out.println("You are still playing the game hehe");	
	}
}
