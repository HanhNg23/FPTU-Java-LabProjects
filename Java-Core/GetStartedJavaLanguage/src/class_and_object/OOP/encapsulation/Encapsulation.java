package class_and_object.OOP.encapsulation;

/***
<p><strong>Controlling Access to Members of a Class</strong></p>
Access level modifiers determine whether other classes can use a particular field or invoke a particular method. There are two levels of access control:
<p>At the top level—public, or package-private (no explicit modifier)</p>
<p>At the member level—public, private, protected, or package-private (no explicit modifier)</p>
 ***/
public class Encapsulation {

	public static void main(String[] args) {
             CarCar car = new CarCar("TOYOTO", 2022 );
             car.setName("BANBAN");
             car.setYear(2045);
             System.out.println("Accessing the object CarCar");
             System.out.println("Car name: " + car.pubName());
             System.out.println("Car produced year: " + car.pubYear());
             System.out.println("-------------------------------");
             System.out.println();
             
             /*-----Lesson Copy Object-----*/
             
             CarCar car1 = new CarCar("EXANVO", 2018);
             CarCar car2 = new CarCar("KIV", 2003);
             
             /*Now we copy data in car1 for car2*/
             
             /*Method 1 - change the value reference of car2 to reference to car 1*/
            // car2 = car1;
             
             /*Method 2 - using method copy of CarCar*/
            // car2.copy(car1); //create copy method
             
             /*Method 3 - using constructor of CarCar which receives object type CarCar as argument*/
             CarCar car3 = new CarCar(car1);
             
             //output
             System.out.println("car1 " + car1); // | print the address memory
             System.out.println("car2 " + car2); // |
             System.out.println("car3 " + car3);
             System.out.println();
             System.out.println("Car1");
             System.out.println("name: " + car1.pubName());
             System.out.println("produced year" + car1.pubYear());
             System.out.println();
             System.out.println("Car2");
             System.out.println("name: " + car2.pubName());
             System.out.println("produced year" + car2.pubYear());
             System.out.println();
             System.out.println("Car3 copy from car1");
             System.out.println("name: " + car3.pubName());
             System.out.println("produced year" + car3.pubYear());
             System.out.println("car3 " + car3);
  
	}
	


}
