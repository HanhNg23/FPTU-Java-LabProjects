
public class Milk_tea {
	String name = "Matcha";
	String topping = "Pudding cafe";
	char size = 'L';
	int cost = 56000;
	String store = "ROCO";
	
	
	public String toString() {
		String oneline = name + "\n" + topping + "\n" + size + "\n" + cost + "\n" + store;
		//return name + "\n" + topping + "\n" + size + "\n" + cost + "\n" + store; 
		return oneline;
	}
}
