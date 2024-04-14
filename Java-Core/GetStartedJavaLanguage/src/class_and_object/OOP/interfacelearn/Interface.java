package class_and_object.OOP.interfacelearn;
/***
<p>Another way to achieve abstraction in Java, is with interfaces.</p>

<p>- An interface is a completely "abstract class" that is used to group related methods with empty bodies.</P>
<p>- To access the interface methods, the interface must be "implemented" (kinda like inherited) by another </P>
  class with the "implements" keyword (instead of extends). The body of the interface method is provided by the "implement" class</P>

<p><strong>+ Notes on Interfaces:</strong></P>
<p>--> Like abstract classes, interfaces cannot be used to create objects (in the example above, it is not 
    possible to create an "Animal" object in the MyMainClass)</P>
<p>--> Interface methods do not have a body - the body is provided by the "implement" class</P>
<p>--> On implementation of an interface, you must override all of its methods</P>
<p>--> Interface methods are by default "abstract" and "public"</P>
<p>--> Interface attributes are by default "public", "static" and "final"</P>
<p>--> An interface cannot contain a constructor (as it cannot be used to create objects)</P>

<p><strong>+ Why And When To Use Interfaces?</strong></P>
<p>1) To achieve security - hide certain details and only show the important details of an object (interface).</P>

<p>2) Java does not support "multiple inheritance" (a class can only inherit from one superclass).</P>
    <p>However, it can be achieved with interfaces, because the class can implement multiple interfaces.</P>
    <p>Note: To implement multiple interfaces, separate them with a comma (see example below).</P>
    
    <p>lINK: https://www.w3schools.com/java/java_interface.asp</P>

****/

public class Interface {

	public static void main(String[] args) {
	 
		Rabbit rabbit = new Rabbit();
		Hawk hawk = new Hawk();
		Fish fish = new Fish();
		
		rabbit.flee();
		hawk.hunt();
		fish.flee();
		fish.hunt();
		
	}

}

//You can create a file interface Prey instead
interface Prey  {
	void flee();
	
}
interface Predator{
	void hunt();
}

class Rabbit implements Prey{

	@Override
	public void flee() {
		System.out.println("The rabbit is fleeing from the hunter.");
		
	}
}
class Hawk implements Predator{

	@Override
	public void hunt() {
		System.out.println("The hawk is hunting the rabbit.");	
	}
}
class Fish implements Prey, Predator{

	@Override
	public void hunt() {
		System.out.println("The fish is hunting the smaller fish.");
		
	}

	@Override
	public void flee() {
		System.out.println("The fish is fleeing from the larger fish");
		
	}
	
}





