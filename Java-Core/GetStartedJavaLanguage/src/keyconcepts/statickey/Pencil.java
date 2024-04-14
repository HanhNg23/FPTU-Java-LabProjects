package keyconcepts.statickey;

public class Pencil {
	String colorofPencil;
	static int numberofPencil;

	Pencil(String colorofPencil) {
		this.colorofPencil = colorofPencil;
		numberofPencil++;
	}

	static void in() {
		System.out.println("You have " + numberofPencil);
	}
}
