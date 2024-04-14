package arrays.object_arrays;

public class Array_of_Object {

	public static void main(String[] args) {
		Store product1 = new Store("Vegetables", "Salad");
		Store product2 = new Store("Bakery", "Bread");
		Store product3 = new Store("Beverages", "Milk");
		
		                                                //Declare Array1
		Store[] store1 = new Store[3];
		store1[0] = product1;
		store1[1] = product2;
		store1[2] = product3;
		 
		//Output
		System.out.println("Store 1");
		for(int i = 0; i < 3; i++) {
			System.out.println("product " + i + " - " + store1[i].type + " - " + store1[i].sale);
		}
		
		System.out.println("------------------------");
		
		                                               //Declare Array2
		Store[] store2 = {product1,  product2, product3};	
		     
		System.out.println("Store 2");
		for(int i = 0; i < 3; i++) {
			System.out.println("product " + i + " - " + store2[i].type + " - " + store2[i].sale );
		}
		
		System.out.println("------------------------");                                   	
	}

}
