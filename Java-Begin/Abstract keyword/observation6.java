/*----Observation6----
 * Similar to the interface we can define static methods in an abstract class 
 * that can be called independently without an object. 
 * 
 */
//class1
abstract class Helper{
	static void demoFun() {
		System.out.println("FUN FUN FUN");
	}
}
//class2 main class extending Helper class 
public class observation6 extends Helper{

	public static void main(String[] args) {
		Helper.demoFun();
		

	}

}
