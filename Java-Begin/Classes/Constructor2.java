/*Create a class directly */
//Create a class named Constructure2
public class Constructor2 {
	int modelYear;
	String modelName;
//create a class constructor for the Constructor2 class
 public Constructor2(int year, String name){
	 this.modelYear = year;
	 this.modelName = name;
   }

 public static void main(String[] args) {
	 Constructor2 human3 = new Constructor2(2022, "KIV");
	 System.out.println(human3.modelYear);
	 System.out.println(human3.modelName);
 }

   } 
