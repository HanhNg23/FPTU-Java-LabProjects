package arrays;
import java.util.ArrayList;
import java.util.Collections;
public class Arraylist {
	public static void main(String[] args)
	{
		//create ArrayList object called food that will store srings:
		//ArrayList<String> food = new ArrayList<String>();
		ArrayList<String> food = new ArrayList<>();
		//ArrayList<String> food = new ArrayList();
		
		//add Items use.add();
		food.add("Banana");
		food.add("Mutha");
		food.add("Hamburger");
		food.add("Sausage");
		food.add("Farmina");
		System.out.println(food); //show all elements in under row format of array
		System.out.println(food.get(3));
		//change an Item
		food.set(0,"BEBE");
		//remove an item
		food.remove(1);
		//remove all items
		//food.clear();
		//sort the items
		Collections.sort(food);
		
		//show all elements in list by using for
		for(int i=0; i<food.size(); i++){
			System.out.println(food.get(i));
		}
		//another method for list the elements
		for(String j : food) {
			System.out.println(j);
		}
	 }
		
}
	


