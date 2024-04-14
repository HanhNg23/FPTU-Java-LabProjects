package class_and_object.object;


/*** 
 * OOP- Object-Oriented Programming = an instance class that may contain 
 * attributes(characteristics of object) and method(action can do by this object)
 ***/ 
public class ObjectInstantiation {

	public static void main(String[] args) {
		/* 
		 * OOP- Object-Oriented Programming = an instance class that may contain 
		 * attributes(characteristics of object) and method(action can do by this object)*/ 
        Car myCar = new Car();
        
        System.out.println(myCar.color);
        System.out.println(myCar.year);
        myCar.drive();
        myCar.brake();
        
	}

}
