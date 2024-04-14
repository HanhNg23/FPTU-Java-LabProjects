package concurrency.synchronization.thread_interference;

import Service.Util;
import concurrency.synchronization.Counter;
import concurrency.synchronization.CounterRunnable;

public class ThreadInteference {

	public static void main(String[] args) {
		System.out.println("Demo the thread interference occurs when the 2 operation increment\n"
				+ " and decrement in 2 seperated threads try to change the shared conter value\n"
				+ " but the final counter value get from the final operation on that counter \n ");
		
		CounterRunnable counterRunnable = new CounterRunnable();
		Counter counter = new Counter();
		Util.threadMessage("Initial value: " + counter.getValue());
		Runnable incrementCounterRunnable = counterRunnable.getIncrementCounterRunnable(counter);
		Thread incrementThread = new Thread(incrementCounterRunnable, "Thread-increment");
		Runnable decrementCounterRunnable = counterRunnable.getDecrementCounterRunnable(counter);
		Thread decrementThread = new Thread(decrementCounterRunnable, "Thread-decrement");
		
		incrementThread.start();
		decrementThread.start();
		try {
			Thread.sleep(4000); //sleep for 4 seconds to let the incrementThread and decrementThread done at all
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Util.threadMessage("Get final counter value: " + counter.getValue());

		int c = 5;
		//System.out.println("c: " + c + " -> c++: " + c++ + " -> c 2nd: " + c + "; c--: " + c-- + " -> c 2nd: " + c);
		int e = 5;
		//System.out.println("e: " + e + " -> ++e: " + ++e + " -> e 2nd: " + e + "; --e: " + --e + " -> e 2nd: " + e);
	}
}
