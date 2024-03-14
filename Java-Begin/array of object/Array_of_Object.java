
public class Array_of_Object {

	public static void main(String[] args) {
		Store product1 = new Store("Vegetables", "Salad");
		Store product2 = new Store("Bakery", "Bread");
		Store product3 = new Store("Beverages", "Milk");
		
		                                                //Declare Array1
		Store[] store = new Store[3];
		store[0] = product1;
		store[1] = product2;
		store[2] = product3;
		                                                     //Output
		for(int i = 0; i < 3; i++) {
			System.out.println(""+store[i].type + " - " + store[i].sale );
		}
		
		System.out.println("------------------------");
		
		                                               //Declare Array2
		Store[] store_store = {product1,  product2, product3};	
		                                                    //Output
		for(int i = 0; i < 3; i++) {
			System.out.println(""+store_store[i].type + " - " + store_store[i].sale );
		}
		
		System.out.println("------------------------");
		
		System.out.println(store[0].sale);
		System.out.println(store[0].type);
		                                      
		
	
	
	}

}
