import java.io.File;

public class FILEisFILE {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\FILEisFILE\\NONO.txt");
		
		if(file.exists()) {
			System.out.println("YES YES YES YES YES");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getName());
			
		}else System.out.println("NO NO NO");
	}
		
}
