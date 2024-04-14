package concurrency.synchronization.synchronized_method;

import concurrency.synchronization.Counter;
import concurrency.synchronization.CounterRunnable;

public class SychronizedMethod {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("This is going to test that, while the count up is synchorinizing by the Thread-CountUp-Sync, \n"
				+ "the count down by the Thread-CountDown-Sync has been block and have to wait until the Thread-CountUp-Sync done its work. \n"
				+ "But this synchronization does not affect the process of execute async task in the Thread-CountDown-ASync\n");
		
		System.out.println("The count up start from 0 -> 5; The count down start from 5 -> 0\n");
		
		Counter counter = new Counter();
		CounterRunnable counterRunnable = new CounterRunnable();
		
		Thread countUpSyncThread = new Thread(counterRunnable.getCountUpSync(counter), "Thread-CountUp-Sync");
		Thread countdownSyncThread = new Thread(counterRunnable.getCountDownSync(counter), "Thread-CountDown-Sync");
		Thread countDownAsyncThread = new Thread(counterRunnable.getCountDown(counter), "Thread-CountDown-ASync");
		
		countDownAsyncThread.start();
		countUpSyncThread.start();
		Thread.sleep(1000); //wait 1000 mili seconds before starting the countdownSyncThread
		countdownSyncThread.start();
		
		
	}
}
