package class_and_object.OOP.polymorphism;
import java.util.Scanner;


public class dynamic_polymorphism {

	public static void main(String[] args) {
		Family family;
		int choice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Press 1 to listen to PAPA");
		System.out.println("Press 2 to listen to MAMA");
		System.out.print("INPUT : ");
		choice = input.nextInt();
		
		if(choice == 1) {
			family = new PAPA();
			family.speak();
		}
		else if(choice == 2) {
			family = new MAMA();
			family.speak();
		}
		else {
			System.out.println("Input wrong ");
		    family = new Family();
		    family.speak();
		}

	}

}

class Family{
	public void speak(){	
		System.out.println("We are family");
	}
}

class PAPA extends Family{	
	@Override
	    public void speak(){
		System.out.println("PAPA loves family");
	}
}
class MAMA extends Family{
	@Override
        public void speak(){
	     System.out.println("MAMA loves family");
    }	
}

