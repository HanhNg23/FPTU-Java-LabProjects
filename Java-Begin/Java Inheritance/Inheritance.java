
public class Inheritance {
	public static void main(String[] args) {
		/*TODO
		   Java Inheritance: it is possible to inherit attributes and methods from one class to another. 
		   We group the "inheritance concept" into two categories:
              subclass (child) - the class that inherits from another class
              superclass (parent) - the class being inherited from
           To inherit from a class, use the *extends* keyword.*/
		//For example: now we create 3 class : Vehicle class - superclass, the_Car - subclass, the_Bicycle - subclass
		
		The_Car myCar = new The_Car();
		//call the go() method from the Vehicle class on the myCar object
	    myCar.go();
	    System.out.println(myCar.toString());
	    System.out.println();
	    
		//call the stop() method from the Vehicle class on the myBike object
	    the_Bicycle myBike = new the_Bicycle();
	    myBike.stop();
	    System.out.println();
	    
	    Vehicle vehicle = new Vehicle();
	    vehicle.stop();
	    vehicle.go();
	    
		
	}

}
