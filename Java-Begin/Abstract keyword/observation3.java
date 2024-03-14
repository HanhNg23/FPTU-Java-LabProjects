/*----Observation3----*/
/*we can have an abstract class without any abstract method.
 *This allows us to create classes that cannot be instantiated but can only be inherited. */

//class1
abstract class Parents3{
	void fun() {
		System.out.println("My family is very happy 333");
	}
}

//class2
class Child3 extends Parents3{
	
}

//class3
public class observation3 {
	public static void main(String[] args) {
		Child3 child = new Child3();
		child.fun();
	}


}
