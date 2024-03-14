/*-----Observation 1----
  an instance of an abstract class cannot be created, we can have references to abstract class type though.*/

//class 1 - abstract class
abstract class Parents1{
	abstract void statement();
}
//class 2
class Child1 extends Parents1{
	void statement() {
		System.out.println("My family is very happy!!!");
	}
}


//class 3 - main class
public class observation1 {
	public static void main(String[] args) {
		Child1 child = new Child1();
		child.statement();
	}

	
}
