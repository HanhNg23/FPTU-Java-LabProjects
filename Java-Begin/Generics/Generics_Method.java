
public class Generics_Method {

	public static void main(String[] args) {
		//Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types)
		//to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types. 
		//An entity such as class, interface, or method that operates on a parameterized type is a generic entity.
		
		Integer[] intArray = {1,2,3,4,5};
		Double[] doubleArray = {5.5, 5.6, 6.7};
		Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
		String[] stringArray = {"Bye", "Bye", "Bai", "bai"};
		
		displayArray(intArray);
		displayArray(doubleArray);
		displayArray(charArray);
		displayArray(stringArray );
		
		System.out.println(getFirst(intArray));
		System.out.println(getFirst(doubleArray));
		System.out.println(getFirst(charArray));
		System.out.println(getFirst(stringArray));
	}
		public static <Thing> void displayArray(Thing[] array) {
			for(Thing x : array) {
				System.out.print((x+" "));
			}
			System.out.println();
		}
		
		public static <Thing> Thing getFirst(Thing[] array) {
			return array[0];
		}
}

