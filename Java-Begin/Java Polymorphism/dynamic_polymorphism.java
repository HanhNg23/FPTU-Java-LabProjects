import java.util.Scanner;

class FAMILYnew{
	public void speak(){	
		System.out.println("Akruuuuuuuu");
	}
}

class PAPA extends FAMILYnew{	
	@Override
	    public void speak(){
		System.out.println("PAPA loves family");
	}
}
class MAMA extends FAMILYnew{
	@Override
        public void speak(){
	     System.out.println("MAMA loves family");
    }	
}
public class dynamic_polymorphism {

	public static void main(String[] args) {
		FAMILYnew family;
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
			System.out.println("Input wrong");
		    family = new FAMILYnew();
		    family.speak();
		}

	}

}
