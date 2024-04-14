package Service;

import java.time.LocalTime;

public class Util {
	public static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("[%s-%s]-------%s%n", threadName, LocalTime.now().toString(), message);
	}
}
