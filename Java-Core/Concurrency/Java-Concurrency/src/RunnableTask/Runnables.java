package RunnableTask;

import java.time.LocalTime;

import RunnableTask.Deadlock.Friend;

public class Runnables {

	String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too" };

	public Runnable countdonwnVer1 = new Runnable() {
		@Override
		public void run() {
			int i = 0;
			while (i <= 5) {
				System.out.println("In Thread: " + Thread.currentThread().getName());
				System.out.println("  - i: " + i);
				System.out.println("  - Start 2 seconds sleeping");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("  - Is Thread Interrupted :" + Thread.interrupted());
				}
				i++;
			}
		}
	};

	public Runnable countdonwnVer2 = new Runnable() {
		@Override
		public void run() {
			int i = 0;
			while (i <= 5) {
				System.out.println("In Thread: " + Thread.currentThread().getName());
				System.out.println("  - i: " + i);
				System.out.println("  - Start 1 seconds sleeping");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("  - Thread Interrupted :" + Thread.interrupted());
					e.printStackTrace();
				}
				i++;
			}

		}
	};

	public int incrementCounter(Counter counter) {
		Runnable incrementCounterRun = new Runnable() {
			@Override
			public void run() {
				counter.increment();
			}
		};
		Thread incrementCounterThread = new Thread(incrementCounterRun, "incrementCounterThread");
		incrementCounterThread.start();

		return counter.value();
	}

	public int decrementCounter(Counter counter) {
		Runnable decrementCounterRun = new Runnable() {
			@Override
			public void run() {
				counter.decrement();
			}
		};
		Thread decrementCounterThread = new Thread(decrementCounterRun, "decrementCounterThread");
		decrementCounterThread.start();
		return counter.value();
	}

	public void countUpSync(Counter counter) {
		Runnable countUpRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countUpSync();
			}
		};
		Thread countUpThread = new Thread(countUpRunnable, "count-Up-Sync");
		countUpThread.start();
	}

	public void countDownSync(Counter counter) {
		Runnable countDownRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countDownSync();
			}
		};
		Thread countDownThread = new Thread(countDownRunnable, "count-Down-Sync");
		countDownThread.start();
	}

	public void countUpSyncIntrinsic(Counter counter) {
		Runnable countUpRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countUpSyncIntrinsic();
			}
		};
		Thread countUpThread = new Thread(countUpRunnable, "count-Up-Sync-Intrinsic");
		countUpThread.start();
	}

	public void countDownSyncIntrinsic(Counter counter) {
		Runnable countDownRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countDownSyncIntrinsic();
			}
		};
		Thread countDownThread = new Thread(countDownRunnable, "count-Down-Sync-Intrinsic");
		countDownThread.start();
	}

	public void countUpASync(Counter counter) {
		Runnable countUpRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countUpASync();
			}
		};
		Thread countUpThread = new Thread(countUpRunnable, "count-Up-ASync");
		countUpThread.start();
	}

	public void countDownASync(Counter counter) {
		Runnable countDownRunnable = new Runnable() {
			@Override
			public void run() {
				counter.countDownASync();
			}
		};
		Thread countDownThread = new Thread(countDownRunnable, "count-Down-ASync");
		countDownThread.start();
	}

	public SynchronizedRGB setSynchronizedRGB(int red, int green, int blue, String name) {
		SynchronizedRGB color = new SynchronizedRGB();
		Runnable setColorRunnable = new Runnable() {
			@Override
			public void run() {
				color.set(red, green, blue, name);
			}
		};
		Thread setColorThread = new Thread(setColorRunnable, "color-set-thread");
		setColorThread.start();
		return color;
	}

	public void viewSynchronizedRGB(SynchronizedRGB color) {
		
		Runnable getColorRunnable = new Runnable() {
			@Override
			public void run() {
				color.getColor();
			}
		};
		Thread getColorThread = new Thread(getColorRunnable, "color-get-thread");
		getColorThread.start();
	}

	public void viewImmutableRGB(ImmutableRGB color) {
		Runnable getColorRunnable = new Runnable() {
			@Override
			public void run() {
				int myColorInt = color.getRGB(); //statement 1
	    	    String myColorName = color.getName(); //statement 2
	    	    System.out.println("[" + Thread.currentThread().getName() + "]" + " - Time :" + LocalTime.now()
				+ " - Get color name: " + myColorName + " - value: " + myColorInt + " - object color: "
				+ color.hashCode());
			}
		};
		Thread getColorThread = new Thread(getColorRunnable, "color-get-thread");
		getColorThread.start();
	}
	
}
