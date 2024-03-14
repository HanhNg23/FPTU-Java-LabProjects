import java.util.ArrayList;

class myGenericClass <Thing, Thing2>{
	Thing x;
	Thing2 y;
	myGenericClass(Thing x, Thing2 y){
		this.x = x;
		this.y = y;
	}
	public void getValue() {
		System.out.println(x +" " +y);
		
	}
	
//	public Thing2 getValue2() {
//		return y;
//	}
	
}

public class Generics_Classes {
	public static void main(String[] args) {
	  myGenericClass<Integer, Integer> myInt = new myGenericClass<>(4,5);
	  myGenericClass<Double, Double> myDouble = new myGenericClass<>(3.14, 5.6);
	  myGenericClass<Character, String> myChar = new myGenericClass<>('#', "Good bye");
	  myGenericClass<String, Character> myString = new myGenericClass<>("HELLO", 'O');
	  
	  //quite the same as
	  ArrayList<String> myFriend = new ArrayList<>(); 
	  
//	  System.out.println(myInt.getValue());
//	  System.out.println(myDouble.getValue());
//	  System.out.println(myChar.getValue());
//	  System.out.println(myString.getValue());
	  
	  myInt.getValue();
	  myDouble.getValue();
	  myChar.getValue();
	  myString.getValue();
	  
	  
		
	}

}
