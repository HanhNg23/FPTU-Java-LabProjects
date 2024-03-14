import java.util.ArrayList;

public class twoD_arraylist {
	public static void main(String[] args) {
	//reference https://iq.opengenus.org/2d-array-list-java/
	/*An Array List is a dynamic version of array. 
	  It is similar to Dynamic Array class where we do not need to predefine the size.
	  The size of array list grows automatically as we keep on adding elements.*/
	//2D ArrayList = a dynamic list of lists
	//You can change the size of these lists during runtime
		
		
	
		
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

		System.out.println(groceryList);
		System.out.println(groceryList.get(0).get(1));
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	
	

}
