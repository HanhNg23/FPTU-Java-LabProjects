package serialization;

import java.io.Serializable;

class User implements Serializable{
	//you have to create the separately project for file deserialization so that this file can return UID to 1
	private static final long serialVersionUID = 1; 
	String name;
	String password;
	
	public void sayGoodBye() {
		System.out.println("Hello " + name);
	}
}
