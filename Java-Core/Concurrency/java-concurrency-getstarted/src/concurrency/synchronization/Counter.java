package concurrency.synchronization;

import Service.Util;

public class Counter {
	private int c = 5;
	Object lockCountDown = new Object();
	Object lockCountUp = new Object();

	public int increment() {
		return c = c + 1;
	}

	public int decrement() {
		return c = c - 1;
	}

	public void countUp() {
		for (int i = 0; i <= c; i++) {
			Util.threadMessage(" i : " + i);

		}

	}

	public void countDown() {
		for (int i = c; i >= 0; i--) {
			Util.threadMessage(" i : " + i);
		}

	}

	public synchronized void countUpSync() {
		this.countUp();

	}

	public synchronized void countDownSync() {
		this.countDown();

	}
	
	public void countUpSyncIntrinsicLock() {
		synchronized (lockCountUp) {
			this.countUp();
		}

	}

	public void countDownSyncIntrinsicLock() {
		synchronized (lockCountDown) {
			this.countDown();
		}

	}

	public int getValue() {
		return c;
	}
}
