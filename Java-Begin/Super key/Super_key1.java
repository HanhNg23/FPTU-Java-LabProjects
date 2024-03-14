
class Family{
	int numofMember;
	String address;
	
	Family(int numofMember, String address){
		this.numofMember = numofMember;
		this.address = address;
	}
	
	public String toString() { 
		return numofMember + ", " + address;	
	}
	void describe() {
		System.out.println("This family is very happy !!!");
	}
}

class Person extends Family{
	String nameofMember;
	int age;
	String role;
	
	Person(String nameofMember , int age, String role, int numofMember, String address){
		super(numofMember, address);
		this.nameofMember = nameofMember;
		this.age = age;
		this.role = role;
		
	}
	
	public String toString() { 
		return nameofMember + ", " + age + ", " + role + ", " + super.toString();	
	}
	
	void new_toString() {
		System.out.println(nameofMember + ", " + age + ", " + role + ", " + super.numofMember + ", " + super.address);	
	}
	void statement() {
		System.out.println(nameofMember + "'s family has " + Person.super.numofMember + " people");
	}
	
}
public class Super_key1 {
	public static void main(String[] args) {
		Person member1 = new Person("Nguyen Van Hiep", 45, "Father", 4, "Ho Chi Minh");
		Person member2 = new Person("Hoang Thi Thuy", 40, "Mother", 4, "Ho Chi Minh");
		
		System.out.println(member1.nameofMember);
		System.out.println(member2.nameofMember);
		System.out.println(member1.address);
		System.out.println(member2.address);
		member1.describe();
		member2.statement();
		System.out.println("------------------------");
		System.out.println(member1.toString());
		System.out.println(member2);
		System.out.println("------------------------");
		member1.new_toString();
	    member2.new_toString();
	}

}
