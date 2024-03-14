package OOP;// do chuyển vào package mới nên mới có nó
public class objects {

	public static void main(String[] args) {
		/* TODO 
		 * OOP- Object-Oriented Programming = an instance class that may contain 
		 * attributes(characteristics of object) and method(action can do by this object)*/ 
        Car_class myCar = new Car_class();
        
        System.out.println(myCar.color);
        System.out.println(myCar.year);
        myCar.drive();
        myCar.brake();
        
	}

}
