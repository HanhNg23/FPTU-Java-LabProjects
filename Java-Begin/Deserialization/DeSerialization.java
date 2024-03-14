
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

class User implements Serializable{
	String name;
	String password;
	
		public void sayGoodBye() {
			System.out.println("Hello " + name);
	}
}

public class DeSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		User  user = null;
		FileInputStream fileIn = new FileInputStream("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\UserInform.ser ");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		user = (User)  in.readObject();
		in.close();
		fileIn.close();
		
		System.out.println(user.name);
		System.out.println(user.password);
		user.sayGoodBye();
		
		long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID); //See what its function in youtube BRocode
		
	}

}
