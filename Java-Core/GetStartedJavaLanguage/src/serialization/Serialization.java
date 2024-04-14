package serialization;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class Serialization {
	public static void main(String[] args) throws IOException {
		/* Serialization = The process of converting an object into a byte stream.
		 *                 Persists (save the state) the object after program exist
		 *                 This byte stream can be saved as a file or sent over a network
		 *                 Can be sent to a different machine
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
		
		System.out.println("Object info saved !");
		long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID); 
	}
	
	
	

}
