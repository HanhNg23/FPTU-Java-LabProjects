
public class object_passing {
	public static void main(String[] args) {
		car Car = new car("BENBEN", 2021);
		garage Garage = new garage();
		Garage.buy(Car);
		//System.out.println(Garage.buy(Car)); --> error
		
		
	}

}
