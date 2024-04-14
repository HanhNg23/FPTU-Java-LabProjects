package basic_io.read_write_file;
import java.io.File;

public class FILEisFILE {

	public static void main(String[] args) {
		File file = new File("src\\basic_io\\read_write_file\\NONO.txt");
		
		if(file.exists()) {
			System.out.println("YES YES YES YES YES");
			System.out.println("File absolute path" + file.getAbsolutePath());
			System.out.println("File name" + file.getName());
			
		}
		else System.out.println("File does not exist");
	}
		
}
