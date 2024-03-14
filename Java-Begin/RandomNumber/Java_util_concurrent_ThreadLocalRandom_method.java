//We use java.util.concurrent.ThreadLocalRandom class
//This class is introduced in java 1.7 to generate random numbers of * type integers, doubles, booleans etc*
import java.util.concurrent.ThreadLocalRandom;

public class Java_util_concurrent_ThreadLocalRandom_method {

	public static void main(String[] args) {
		int first = ThreadLocalRandom.current().nextInt();
		double second = ThreadLocalRandom.current().nextDouble();
		boolean third = ThreadLocalRandom.current().nextBoolean();
		System.out.println("Random Int -> " +first);
		System.out.println("Random Double -> " +second);
		System.out.println("Random boolean -> " +third);

	}

}
