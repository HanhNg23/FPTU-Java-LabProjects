package class_and_object.constructor;

public class Human {
	String name;
	int age;
	double weight;
	
	Human(String name, int age, double weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	void eat() {
		System.out.println(this.name + " is eating in HONGKONG FOOD");
	}
	void drink() {
		System.out.println(this.name +" is drinking Coca Cola");
	}
	double sum(int  a, double b) {
		return a+b;
	}
	

}
