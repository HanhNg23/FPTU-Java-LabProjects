


public class Static_key {
	//Create static method
	static void myStaticMethod() {
		System.out.println("Static  methods can be called without creating objects");
	}
    //Create public method
	public void myPublicMethod() {
		System.out.println("Public methods must be called by creating objects");
	}
	public static void main(String[] args) {
		//to learn more about Static key --> please enter this link
		//https://topdev.vn/blog/tu-khoa-static-va-final-trong-java/#:~:text=Trong%20Java%2C%20t%E1%BB%AB%20kh%C3%B3a%20static,(th%E1%BB%83%20hi%E1%BB%87n)%20c%E1%BB%A7a%20l%E1%BB%9Bp.
        //Now we take the advantage of Static key for Counting
		Pencil tree1 = new Pencil("Red");
		Pencil tree2 = new Pencil("Blue");
		Pencil tree3 = new Pencil("Green");
		
		System.out.println(Pencil.numberofPencil);
		//System.out.println(Pencil.in()); -->error because Pencil.in() is method	
	    Pencil.in();
	    myStaticMethod();
	    Static_key different_to_public = new Static_key();
	    different_to_public.myPublicMethod();
	   
	    
	    //OK let's try by deleting static in pencil class
	}

}
