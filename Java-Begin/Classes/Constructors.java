
public class Constructors {
	//constructor = special method that is called when an object is instantiated (= created)
	public static void main(String[] args) {
		Human human = new Human("Jony Wick", 65,70);
		Human human1 = new Human("MEME", 80,100);
		System.out.println(human.name);
		System.out.println(human1.name);
		human.eat();
		human1.drink();
		double sumageandweight = human.sum(human.age, human.weight);
		System.out.println(sumageandweight);
		System.out.println(human1.sum(human1.age, human1.weight));
	}
}
