import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

class User implements Serializable{
	
	private static final long serialVersionUID = 1; //you have to create the separately project for file deserialization so that this file can return UID to 1
	String name;
	String password;
	
	public void sayGoodBye() {
		System.out.println("Hello " + name);
	}
}

public class Serialization {
	public static void main(String[] args) throws IOException {
		/* Serialization = The process of converting an object into a byte stream.
		 *                 Persits (save the state) the object after program exist
		 *                 This byte stream can be saved as a file or sent over a network
		 *                 Can be sent to a differrent machine
		 *                 Byte stream can be save as file (.ser) which is platform independent
		 *                 (Think of this as if you are saving a file with the object's information)*/
		/* Deserialization = The reverse process of converting a byte stream into an object.
		 *                    (Think of this as if you are loading a saved file)*/
	
		User user = new User();
		
		user.name = "Bro Code";
		user.password = "AAAA";
		
		FileOutputStream fileOut = new FileOutputStream("UserInform.ser"); //the file UserInform.ser can be sent over the Internet
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(user);
		out.close();
		fileOut.close();
		
		System.out.println("object info saved! :");
		long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID); //See what its function in youtube BRocode
	}
	
	
	

}
