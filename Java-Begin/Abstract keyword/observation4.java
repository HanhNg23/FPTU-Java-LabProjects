/*----Observation4---*/
// Abstract classes can also have final methods (methods that cannot be overridden)

//class1
abstract class Parents4{
	final void fun() {
		System.out.println("My family is very happy 444");
	}
}

//class2
class Child4 extends Parents4{
	//void fun() {} -->Error because we can't override the fun method
}



public class observation4 {
	public static void main(String[] args) {
		Child4 child = new Child4();
		child.fun();
	}

}
