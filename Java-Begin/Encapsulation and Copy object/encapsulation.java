/*We learn how the B class get the private variable from A class*/
 class CarCar {
		private String name ;
		private int year ;
		
//		CarCar(String name, int year){
//			this.name = name;
//			this.year = year;
//		}	
		
		CarCar(String name, int year){
			this.setName(name);
			this.setYear(year);
		}
		CarCar(CarCar x){
			this.copy(x);
		}
		
		public String pubName() {
			return name;
		}
		public int pubYear() {
			return year;
		}
 
		public void setName(String name) {
			this.name = name;
		}
		public void setYear(int year) {
			this.year = year;
		}
		
		public void copy(CarCar x) {
			this.setName(x.pubName());
			this.setYear(x.pubYear());
			
		}
 }


public class encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             CarCar car = new CarCar("TOYOTO", 2022 );//Initial the value in this first before you want to use setName or setYear
             car.setName("BANBAN");
             car.setYear(2045);
             System.out.println(car.pubName());
             System.out.println(car.pubYear());
             System.out.println("-------------------------------");
             System.out.println();
             
         
                                /*-----Lesson Copy Object-----*/
             CarCar car1 = new CarCar("EXANVO", 2018);
             CarCar car2 = new CarCar("KIV", 2003);
             
                               /*Now we copy data in car1 for car2*/
             
             /*Method 1*/
            // car2 = car1;
             /*Method 2*/
            // car2.copy(car1); //create copy method
             /*Method 3*/
             CarCar car3 = new CarCar(car1);
             
             
             //output
             System.out.println(car1); // | print the address memory
             System.out.println(car2); // |
             System.out.println(car3);
             System.out.println();
             System.out.println("Car1");
             System.out.println(car1.pubName());
             System.out.println(car1.pubYear());
             System.out.println();
             System.out.println("Car2");
             System.out.println(car2.pubName());
             System.out.println(car2.pubYear());
             System.out.println();
             System.out.println("Car3 copy from car1");
             System.out.println(car3.pubName());
             System.out.println(car3.pubYear());
             
             
             
             
             
             
             
           
	}

}
