/* Unlike if-then and if-then-else statements, the switch statement can
 * have a number of possible execution paths. 
 * A switch works with *\ the byte, short, char, and int \* primitive data types.
 * It also works with enumerated types (discussed in Enum Types), *\ the String class \*, and a few special classes 
 * that wrap certain primitive types: Character, Byte, Short, and Integer (discussed in Numbers and Strings).*/
public class Switchcase {

	public static void main(String[] args) {
		String name = "KA";
		switch(name) {
		case "KA":
			System.out.println("DUNG ROI");
			break;
		case "HA":
		    System.out.println("NONO");
		    break;
		default: 
		System.out.println("KO TRUNG CAI NAO");
		}
	}

}
