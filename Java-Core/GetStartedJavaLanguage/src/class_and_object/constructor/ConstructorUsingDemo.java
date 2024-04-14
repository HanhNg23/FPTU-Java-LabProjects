package class_and_object.constructor;

public class ConstructorUsingDemo {
	//constructor = special method that is called when an object is instantiated (= created)
	public static void main(String[] args) {
		Human human1 = new Human("MEME", 80,100);
		Human human2 = new Human("Jony Wick", 65,70);
		
		System.out.println("Human 1: " + human1.name);
		System.out.println("Human 2: " + human2.name);
		
		human1.drink();
		human2.eat();
		
		double sumageandweight = human2.sum(human2.age, human2.weight);
		System.out.println("Sum age and weight of " + human2.name + ": " + sumageandweight);
	}
}
