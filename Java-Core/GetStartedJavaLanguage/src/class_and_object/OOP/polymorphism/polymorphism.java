package class_and_object.OOP.polymorphism;


/***
 * POLYMORPHISM
  <p>Polymorphism means "many forms", and it occurs when we have many classes that are related
  to each other by inheritance.</p>

  <p>Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods 
  from another class. Polymorphism uses those methods to perform different tasks. 
  This allows us to perform a single action in different ways.</p>

  <p>For example, think of a superclass called Animal that has a method called animalSound(). 
  Subclasses of Animalnews could be Pigs, Cats, Dogs, Birds - And they also have their own 
  implementation of an animal sound (the pig oinks, and the cat meows, etc.):</p>

 ***/
class Animal{
	public void animalSound() {
		System.out.println("Amimal is parent class");
	}
	
}
class Pig extends Animal{
	@Override
	public void animalSound() {
		System.out.println("The Pig says: wee wee");
	}
}
class Dog extends Animal{
	@Override
	public void animalSound() {
		System.out.println("The Dog says: gau gau");
	}
}
class Cat extends Animal{
	@Override
	public void animalSound() {
	    System.out.println("The Cat says: meow meow");
    }
}

class Hourse extends Animal{
}
public class polymorphism {
	public static void main(String[] args) {
	//Method 1 of using POLYMORPHISM
//	Animal pig = new Pig();
//	Animal dog = new Dog();
//	Animal cat = new Cat();
 
	
	//Method 2 of using POLYMORPHISM
	Pig pig = new Pig();
	Dog dog = new Dog();
	Cat cat = new Cat();
	Hourse hourse = new Hourse();
	Animal theanimal = new Animal();
	Animal[] animal = {pig, dog, cat, hourse, theanimal};

    //Output type1 
	pig.animalSound();
	dog.animalSound();
	cat.animalSound();
	hourse.animalSound();
	theanimal.animalSound();
	
	//Output simultaneously
	System.out.println();
	for(Animal x : animal) {
		  x.animalSound();
	   }
    }
}
