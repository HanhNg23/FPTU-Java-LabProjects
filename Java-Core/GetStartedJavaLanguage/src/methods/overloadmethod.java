package methods;
public class overloadmethod {

	public static void main(String[] args) {
		//method overloading, multiple methods can have the same name with different parameters:
		//Example:
		System.out.println(plus(1,2));
		System.out.println(plus(1,2.5,3.4));
		System.out.println(plus(1,2,3,4));
	}
	static int plus(int a, int b) {
		return a+b;
		}
	static double plus(double a, double b, double c) {
		return a+b+c;
		}
	static int plus(int a, int b, int c, int d) {
		return a+b+c+d;
	}
}


