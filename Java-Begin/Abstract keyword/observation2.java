/*----Observation2----
 * an abstract class can contain constructors in Java.
 * And a constructor of abstract class is called
 * when an instance of an inherited class is created.*/

//class 1 - abstract class
abstract class Parents2{
	
	//constructor of class 1
	Parents2(){
		System.out.println("My family is enjoying this moment !!!");
		
	}
	
	void statement(){
		System.out.println("My family is very happy !!!");
	}
	
	abstract void fun();
	
}

//class 2
class Child2 extends Parents2{
	//constructor of class 2
	Child2(){
		System.out.println("Hello this statement from Child2");
	}
	
	void fun() {
		System.out.println("Hello this statement is overrided");
	}
	void statement2() {
		System.out.println("Are you OK");
	}
	
}




public class observation2 {
	public static void main(String[] args) {
		//Parents2 parents = new Parents2();
		Child2 child = new Child2();
//		 child.fun();
//		 child.statement();
//		 child.statement2();
//		 
		 
	}

}
