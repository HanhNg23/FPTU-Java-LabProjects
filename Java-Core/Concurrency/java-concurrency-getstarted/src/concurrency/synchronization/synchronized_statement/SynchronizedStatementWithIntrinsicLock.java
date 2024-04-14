package concurrency.synchronization.synchronized_statement;

import concurrency.synchronization.Counter;
import concurrency.synchronization.CounterRunnable;

public class SynchronizedStatementWithIntrinsicLock {
	
	public static void main(String[] args) {
			
			Counter counter = new Counter();
			CounterRunnable counterRunnable = new CounterRunnable();
			System.out.println("Demo 2 Threads access the synchronized methods, each method synchronized with their own intrinsic lock. "
							 + "\n--> So the synchorization of Thread-CountUp-Sync-IntrinsicLock will not interleave Thread-CountDown-Sync-IntrinsicLock\n");		
			System.out.println("The count up start from 0 -> 5; The count down start from 5 -> 0\n");
			
			Thread countUpThreadSyncIntrinsicLock = new Thread(counterRunnable.getCountUpSyncWithIntrinsicLock(counter), "Thread-CountUp-Sync-IntrinsicLock");
			Thread countDownThreadSyncIntrinsicLock = new Thread(counterRunnable.getCountDownSyncWithIntrinsicLock(counter), "Thread-CountDown-Sync-IntrinsicLock");
			
			countUpThreadSyncIntrinsicLock.start();
			countDownThreadSyncIntrinsicLock.start();
			
	}

}
