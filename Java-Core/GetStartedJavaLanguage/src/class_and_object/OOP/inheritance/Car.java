package class_and_object.OOP.inheritance;

public class Car extends Vehicle{//So The_Car class will inherit everything from Vehicle class
	int wheels = 4;
	String name = "KIV";
	
	 public String toString() {
		return "The name " + name + " the wheels is " + wheels;
	}
	


}
