package keyconcepts.statickey;

public class StaticKey {
	// Create static method
	static void myStaticMethod() {
		System.out.println("Static  methods can be called without creating objects");
	}

	// Create public method
	public void myPublicMethod() {
		System.out.println("Public not static methods must be called by creating objects");
	}

	public static void main(String[] args) {
		Pencil tree1 = new Pencil("Red");
		Pencil tree2 = new Pencil("Blue");
		Pencil tree3 = new Pencil("Green");

		System.out.println(Pencil.numberofPencil);
		// System.out.println(Pencil.in()); -->error because Pencil.in() is method
		Pencil.in();
		StaticKey.myStaticMethod();
		StaticKey different_to_public = new StaticKey();
		different_to_public.myPublicMethod();
	}

}
