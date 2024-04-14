package concurrency.threadobject.interrupt_and_join;

import java.time.LocalTime;

import Service.Util;


public class SimpleInterruptWithJoin {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownRunnables countdownRunnable = new CountDownRunnables();		
						
		long startTime = System.currentTimeMillis();
		Thread threadCountDownV1 = new Thread(countdownRunnable.countdonwnVer1);
		
		int maxMiliSecondsTimeWaiting = 8000;
		Util.threadMessage("I will start the threadCountDownV1 and waiting for threadCountDownV1 countdown at most " + maxMiliSecondsTimeWaiting + " mili seconds,"
				+ "\n                              when the max time waiting times up, no matter threadCountDownV1 done yet, i will continue my next execution !\n");
		threadCountDownV1.start();
		threadCountDownV1.join(maxMiliSecondsTimeWaiting);
		
		if (threadCountDownV1.isAlive()) {
			Util.threadMessage("The maximum patience time i can wait is " + maxMiliSecondsTimeWaiting
					+ " mili seconds, but the threadCountDownV1 has not done it thread yet (threadCountDownV1 has not terminated yet)"
					+ "\n                              I am tired of waiting for threadCountDownV1 and i will decide to interrupt the threadCountDownV1 for fun although the threadCountDownV1 is still alive\n");
			threadCountDownV1.interrupt();
			System.out.println("");
			Util.threadMessage("Check the 1st time - threadCountDownV1 is still Alive " +  threadCountDownV1.isAlive() + " - Is interrupted: " + threadCountDownV1.isInterrupted());
			Util.threadMessage("Main is interrupted: " + Thread.currentThread().isInterrupted());
			Util.threadMessage("Check the 2nd time - threadCountDownV1 is still Alive " +  threadCountDownV1.isAlive() + " - Is interrupted: " + threadCountDownV1.isInterrupted());
			Util.threadMessage("Main thread go to sleep 6 seconds - at this period of time, threadCountDownV1 still keeps working");
			Thread.sleep(6000);
			Util.threadMessage("After 6 seconds - Main thread wakes up and decides to wait until the threadCountDownV1 finish the final work !\n");
			threadCountDownV1.join();
		}
		System.out.println("");
		Util.threadMessage("Check The 3nd time - threadCountDownV1 is still Alive " +  threadCountDownV1.isAlive() + " - Is interrupted: " + threadCountDownV1.isInterrupted());
		Util.threadMessage("Done all my work!");
	}
	
	

}
