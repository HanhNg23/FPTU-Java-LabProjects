package read_and_create_File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*TODO search for more JAVA file Handling on google*/

public class file_read_write {

	public static void main(String[] args) {
		              /*create File*/
		try {
			FileWriter write= new FileWriter("First file.txt");
			write.write("Hello hello hello \n How are you \n I'm fine thank you and you !");
			write.append("\n I'm fine too ! ^_^");
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		              /*read File*/
		try {
			FileReader reader = new FileReader("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\FILEisFILE\\read_and_create_File\\file to read.txt");
			try {
				int data = reader.read();
				while(data != -1) {
					System.out.print((char)data);
					data = reader.read();
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
