package Package1; //Create package
import Package2.*;

public class AClass {
	protected String protectedMessage = "This is the protected in AClass";
	public static void main(String[] args) {
		
		CClass C = new CClass();
		BClass B = new BClass();
		/*----Check with default----*/
		
		//System.out.println(C.defaultMessage); // --Error because it is invisible - fault caused by default Modifier
		System.out.println(B.defaultMessage);
		
		/*----Check with private----*/
		
	    //System.out.println(C.privateMessage);|--> error because Private Modifier
	    //System.out.println(B.privateMessage);|
		
		/*----Check with protector in ASubClass----*/
		/*----Check with public----*/
		System.out.println(C.publicMessage);
		
		
		
	}
	


}
