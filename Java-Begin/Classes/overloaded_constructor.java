//DO NOT WRITE public class Milktea{ } -->Error because each public required the own file
 class Milktea {
	
		String name;
		String topping;
		char size;
		int cost;
		String store = "ROCO";
		
		Milktea(String name, String topping, char size) {
			this.name = name;
			this.topping = topping;
			this.size = size;
		}
		
		
		Milktea(String name, String topping, char size, int cost) {
			this.name = name;
			this.topping = topping;
			this.size = size;
			this.cost = cost;
		}
}




public class overloaded_constructor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//overloaded constructors = multiple constructors w
		
		Milktea milktea = new Milktea("Traditional Milktea","Pudding Socola", 'M', 25000 );
		Milktea milktea1 = new Milktea("Traditional Milktea","Pudding Socola",'S' );
		System.out.println(milktea.name);
		System.out.println(milktea.topping);
		System.out.println(milktea.size);
		System.out.println(milktea.cost);
		System.out.println(milktea.store);
		
		System.out.println();
		
		System.out.println(milktea1.name);
		System.out.println(milktea1.topping);
		System.out.println(milktea1.size);
		System.out.println(milktea1.cost);
		System.out.println(milktea.store);
	}

}
