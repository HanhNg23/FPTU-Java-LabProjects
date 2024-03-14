package Package1;

import Package2.*;

public class BClass {
	String defaultMessage = "This is the default in BClass";
	private String privateMessage = "This is the private in BClass";
	             public static void main(String[] args) {
	            	 BClass B = new BClass();
	            	 System.out.println(B.privateMessage);
	            	 AClass A = new AClass();
	            	 System.out.println(A.protectedMessage);
	            	 CClass C = new CClass();
	            	 System.out.println(C.publicMessage);
	             }

}
