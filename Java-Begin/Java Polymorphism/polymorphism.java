/*TODO POLYMORPHISM
  Polymorphism means "many forms", and it occurs when we have many classes that are related
  to each other by inheritance.

  Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods 
  from another class. Polymorphism uses those methods to perform different tasks. 
  This allows us to perform a single action in different ways.

  For example, think of a superclass called Animalnew that has a method called animalSound(). 
  Subclasses of Animalnews could be Pigs, Cats, Dogs, Birds - And they also have their own 
  implementation of an animal sound (the pig oinks, and the cat meows, etc.):

 */
class Animalnew{
	public void animalSound() {
		
	}
	
}
class Pig extends Animalnew{
	@Override
	public void animalSound() {
		System.out.println("The Pig says: wee wee");
	}
}
class Dognew extends Animalnew{
	public void animalSound() {
		System.out.println("The Dog says: gau gau");
	}
}
class Cat extends Animalnew{
	public void animalSound() {
	    System.out.println("The Cat says: meow meow");
    }
}
public class polymorphism {
	public static void main(String[] args) {
	//Method 1 of using POLYMORPHISM
//	Animalnew pig = new Pig();
//	Animalnew dog = new Dognew();
//	Animalnew cat = new Cat();
 
	
	//Method 2 of using POLYMORPHISM
	Pig pig = new Pig();
	Dognew dog = new Dognew();
	Cat cat = new Cat();
	Animalnew[] animal = {pig, dog, cat};

    //Output type1 
	pig.animalSound();
	dog.animalSound();
	cat.animalSound();
	//Output simultaneously
	System.out.println();
	for(Animalnew x : animal) {
		  x.animalSound();
	   }
    }
}
