package generics;
public class Generics_Method {

	public static void main(String[] args) {
		//Generics means parameterized types. The idea is to allow type (Integer, String, � etc., and user-defined types)
		//to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types. 
		//An entity such as class, interface, or method that operates on a parameterized type is a generic entity.
		
		Integer[] intArray = {1,2,3,4,5};
		Double[] doubleArray = {5.5, 5.6, 6.7};
		Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
		String[] stringArray = {"Bye", "Bye", "Bai", "bai"};
		
		displayArray(intArray);
		displayArray(doubleArray);
		displayArray(charArray);
		displayArray(stringArray);
		
		System.out.println("The first element of array intArray is "  + getFirst(intArray));
		System.out.println("The first element of array doubleArray is " + getFirst(doubleArray));
		System.out.println("The first element of array charArray is " + getFirst(charArray));
		System.out.println("The first element of array stringArray is " + getFirst(stringArray));
	}
		public static <Thing> void displayArray(Thing[] array) {
			System.out.println("Display array of type: " + array.getClass());
			for(Thing x : array) {
				System.out.print((x+ " "));
			}
			System.out.println();
			System.out.println("--------");
		}
		
		public static <Thing> Thing getFirst(Thing[] array) {
			return array[0];
		}
}

