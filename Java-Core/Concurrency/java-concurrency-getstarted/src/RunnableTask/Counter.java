package RunnableTask;

import java.time.LocalTime;

public class Counter {
	private int c = 5;
	private Object lockForCountDownThread = new Object();

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public synchronized void countUpSync() {
		for (int i = 0; i <= c; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + " i: " + i + " - time: " + LocalTime.now());
		}
		// c++;
	}

	public synchronized void countDownSync() {
		for (int i = c; i >= 0; i--) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + " i: " + i + " - time: " + LocalTime.now());
		}
		// c--;
	}

	public void countUpASync() {
		for (int i = 0; i <= c; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + " i: " + i + " - time: " + LocalTime.now());

		}
		// c++;
	}

	public void countDownASync() {
		for (int i = c; i >= 0; i--) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + " i: " + i + " - time: " + LocalTime.now());
		}
		// c--;
	}

	public void countUpSyncIntrinsic() {
		synchronized (this) {
			for (int i = 0; i <= c; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "]" + " i: " + i + " - time: " + LocalTime.now());


			}
		}
		// c++;
	}

	public void countDownSyncIntrinsic() {
		synchronized (lockForCountDownThread) {
			System.out.println("By apply synchronized on lock object \"lockForCountDownThread\", the countDownSyncIntrinsic process  "
					+ "\nwill continue going anyway though countUpSyncIntrinsic lock any thread try to access lock object \"this\" "
					+ "\nwhile it is asynchronizing ");
			for (int i = c; i >= 0; i--) {
				System.out.println("[" + Thread.currentThread().getName() + "]" + " i: " + i + " - time: " + LocalTime.now());

			}
		}
		// c--;
	}

	public int value() {
		return c;
	}
}
