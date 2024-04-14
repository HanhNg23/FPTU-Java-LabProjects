package concurrency.synchronization;

import Service.Util;
import concurrency.synchronization.Counter;

public class CounterRunnable {	
	public Runnable getIncrementCounterRunnable(Counter counter) {
		Runnable incrementCounterRun = new Runnable() {
			@Override
			public void run() {
				Util.threadMessage("Current counter value: " + counter.getValue());
				Util.threadMessage("After increment: " + counter.increment());
			}
		};
		return incrementCounterRun;
	}

	public Runnable getDecrementCounterRunnable(Counter counter) {
		Runnable decrementCounterRun = new Runnable() {
			@Override
			public void run() {
				Util.threadMessage("Current counter value: " + counter.getValue());
				Util.threadMessage("After decrement: " + counter.decrement());
			}
		};
		return decrementCounterRun;
	}
	
	public Runnable getCountUpSync(Counter counter) {
		Runnable countUpRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countUpSync();
			}
		};
		return countUpRunnable;
	}

	public Runnable getCountDownSync(Counter counter) {
		Runnable countDownRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countDownSync();
			}
		};
		return countDownRunnable;
	}
	
	public Runnable getCountUp(Counter counter) {
		Runnable countUpRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countUp();
			}
		};
		return countUpRunnable;
	}

	public Runnable getCountDown(Counter counter) {
		Runnable countDownRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countDown();
			}
		};
		return countDownRunnable;
	}
	
	public Runnable getCountUpSyncWithIntrinsicLock(Counter counter) {
		Runnable countUpRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countUpSyncIntrinsicLock();
			}
		};
		return countUpRunnable;
	}

	public Runnable getCountDownSyncWithIntrinsicLock(Counter counter) {
		Runnable countDownRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countDownSyncIntrinsicLock();
			}
		};
		return countDownRunnable;
	}
}
