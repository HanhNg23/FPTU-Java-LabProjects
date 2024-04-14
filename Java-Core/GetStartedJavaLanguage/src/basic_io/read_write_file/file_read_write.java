package basic_io.read_write_file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file_read_write {

	public static void main(String[] args) {
		              /*create File*/
		try {
			FileWriter write= new FileWriter("src/basic_io/read_write_file/filewrite.txt");
			write.write("Hello hello hello \n How are you \n I'm fine thank you and you !");
			write.append("\n I'm fine too ! ^_^");
			write.close();
			System.out.println("FINISH WRITE FILE !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Start read file from fileread.txt");
		              /*read File*/
		try {
			FileReader reader = new FileReader("src/basic_io/read_write_file/fileread.txt");
			try {
				int data = reader.read();
				while(data != -1) {
					System.out.print((char)data);
					data = reader.read();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
