package methods;
/*
 * method overriding = Declaring a method in sub class,
 *                     which is already present in parent class.
 *                     done so that a child class can give its own implementation */


//Base Class
 class Animal {
	void Speak() {
		System.out.println("Oh my God! This animal is speaking !");
	}
}
//Inherit Class
 class Dog extends Animal {
	//this method overrides do() of superclass Animal
	@Override
	 void Speak() {
			System.out.println("Oh my God! This Dog is speaking !");
	 }
}


//Driver class
public class method_overriding {
	public static void main(String[] args) {
	Dog myDog = new Dog();
	myDog.Speak();
	Animal animal = new Animal();
	animal.Speak();
	}

}
 