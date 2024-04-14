package class_and_object.OOP.inheritance;

/***
 * <p>Java Inheritance: it is possible to inherit attributes and methods from one class to another.</p>
 * <p>We group the "inheritance concept" into two categories:</p>
 * <p> - subclass (child): the class that inherits from another class superclass </p>
 * <p> - (parent) : the class being inherited from To inherit from a class, use the *extends* keyword.</p>
 ***/
public class Inheritance {
	public static void main(String[] args) {
		
		Car myCar = new Car();
		System.out.println("Work with Car Object - Child of Vehicle");
		//call the go() method from the Vehicle class on the myCar object
	    myCar.go();
	    System.out.println(myCar.toString());
	    System.out.println("---------");
	    
	    System.out.println("Work with Bicycle Object - Child of Vehicle");
		//call the stop() method from the Vehicle class on the myBike object
	    Bicycle myBike = new Bicycle();
	    myBike.stop();
	    System.out.println("---------");
	    
	    System.out.println("Work with Vehicle Object - Parent");
	    Vehicle vehicle = new Vehicle();
	    vehicle.stop();
	    vehicle.go();
	    
		
	}

}
