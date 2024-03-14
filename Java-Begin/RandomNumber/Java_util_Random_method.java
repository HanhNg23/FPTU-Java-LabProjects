/* Java provides three ways to generate random numbers using some built-in methods and classes as listed below:
- java.util.Random class
- Math.random method : Can Generate Random Numbers of double type.
- ThreadLocalRandom class*/
//Teacher Bro teach to use java.util.Random class
import java.util.Random;

public class Java_util_Random_method {
	public static void main(String[] args) {
		// create instance of random class
		Random random = new Random();

		int first = random.nextInt();
		double second = random.nextDouble();
		boolean third = random.nextBoolean();
		// generate random number in range 0 to 9
		int fourth = random.nextInt(10);
		// generate random number in range 1 to 10
		int fifth = random.nextInt(10) + 1;

		// output
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		System.out.println(fourth);
		System.out.println(fifth);
		System.out.println();
		for (int i = 0; i < 35; i++) {
			int z = random.nextInt(10) + 1;
			System.out.println(z);
		}
	}

}