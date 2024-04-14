package concurrency.synchronization.memory_consistency;

import Service.Util;

public class MemoryConsistencyError {
	private static int initialValue = 0;
	public static void main(String[] args) {
		Runnable incrementRunnable = new Runnable() {
			@Override
			public void run() {
				Util.threadMessage("The value before increment: " + initialValue);
				Util.threadMessage("After increment: " + ++initialValue);
				
			}
		};
		Util.threadMessage("Demonstrate Memory Consistency Error when the change from threadIncrement might be not visible to thread main ! ");
		
		Thread threadIncrement = new Thread(incrementRunnable, "Thread Increment");
		threadIncrement.start();
		Util.threadMessage("Get final counter value in thread main: " + initialValue 
						 + " (If value = initialValue --> the main thread does not know the change from the threadIncrement");

	}

}
