package arrays;
import java.util.ArrayList;


/***
 * <span>An Array List is a dynamic version of array. It is similar to Dynamic
 * Array class where we do not need to predefine the size. The size of array
 * list grows automatically as we keep on adding elements.</span>
 * <p>
 * 2D ArrayList = a dynamic list of lists --> You can change the size of these lists during runtime
 * </p>
 * <p>
 * reference <a>https://iq.opengenus.org/2d-array-list-java/</a>
 * </p>
 * 
 ***/
public class twoD_Arraylist {
	public static void main(String[] args) {	
		
		//Create separated one dimension_lists
		ArrayList<String> bakeryList = new ArrayList();
		bakeryList.add("Bimm");
		bakeryList.add("Donuts");
		bakeryList.add("Pasta");
		
		ArrayList<String> numocake = new ArrayList();
		numocake.add("six");
		numocake.add("seven");
		numocake.add("ten");
		
		ArrayList<String> personOrder = new ArrayList();
		personOrder.add("Anna");
		personOrder.add("Anina");
		personOrder.add("Cansa");
		
		//create multidimension array
		ArrayList<ArrayList<String>> groceryList = new ArrayList();
		groceryList.add(bakeryList);
		groceryList.add(numocake);
		groceryList.add(personOrder);

		System.out.println("Grocery 2DList: " + groceryList);
		System.out.println("\n----- Accessing each item in 2DList -----");

		for(int i = 0; i < groceryList.size(); i++) {
			for(int j=0; j < groceryList.get(0).size(); j++) {
				System.out.println("index["+i+"]["+j+"] " + groceryList.get(i).get(j));
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	
	

}
