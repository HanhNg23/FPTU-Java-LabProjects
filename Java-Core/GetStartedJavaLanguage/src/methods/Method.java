package methods;
public class Method {
	public static void main(String[] args) {
		//method = a block of code that is executed wheneveer it is called upon
		hello();
		String name = "H'Hen";
		goodbye(name);
		goodbye("MyName");
		saybye("See you tomorrow", 9);
		System.out.println("Do math sum 1 and 8: " + math(1,8));


	}
	
	static void  hello() { //phải thêm static nếu muốn tạo hàm mới
		System.out.println("Hello");	
	}
	static void goodbye(String nameinput) {
		System.out.println("Goodnight  " +nameinput);
	}
	static void saybye(String statement, int number) {
		System.out.println(""+statement+" "+number+" !");
	}
	static int math(int num1, int num2) {
		return (num1 + num2);
	}

}
