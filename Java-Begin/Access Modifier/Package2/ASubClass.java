package Package2;
import Package1.*;

public class ASubClass extends AClass { 
	public static void main(String[] args) {
		ASubClass Asub = new ASubClass();
		System.out.println(Asub.protectedMessage);
		CClass C = new CClass();
   	    System.out.println(C.publicMessage);

	}
      
 
}
