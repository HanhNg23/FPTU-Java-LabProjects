package Service;


import RunnableTask.Consumer;
import RunnableTask.Counter;
import RunnableTask.Deadlock;
import RunnableTask.Drop;
import RunnableTask.HelloRunnable;
import RunnableTask.HelloThread;
import RunnableTask.ImmutableRGB;
import RunnableTask.Producer;
import RunnableTask.Runnables;
import RunnableTask.SynchronizedRGB;

public class ConcurrencyService {
	private HelloRunnable helloRunnableObj = new HelloRunnable();
	private Thread threadHelloBuildFrRunnable = new Thread(helloRunnableObj);
	private HelloThread threadHelloBuildFrExtThread = new HelloThread();
	
	private Runnables runnables = new Runnables();

	public void startMySubThreads() {
		System.out.println("Start Thread " + Thread.currentThread().getName());
		threadHelloBuildFrRunnable.start();
		threadHelloBuildFrExtThread.start();
	}

	public void pausingExecWithSleepMessage() {
		System.out.println("Start Thread " + Thread.currentThread().getName() + " - Task: "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		StackTraceElement stacktrace[] = Thread.currentThread().getStackTrace();
		for (int x = 0; x < stacktrace.length; x++) {
			System.out.println("stack frame: " + stacktrace[x].getMethodName());
		}
		System.out.println("==========================");
		int i = 0;
		while (i <= 10) {
			System.out.println("In Thread: " + Thread.currentThread().getName());
			System.out.println("i: " + i);
			try {
				System.out.println("Start 2 seconds sleeping");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out
						.print("Current Thread Terminated because exceptions occur" + Thread.currentThread().getName());
				e.printStackTrace();
			}
			System.out.println("Call i at the time i++ directly: " + (i++) + " >><< after i++ the value is - the 2nd call: " + i);
			System.out.println("Is Thread Interrupted :" + Thread.interrupted());
			System.out.println("-----");
		}
	}
	public void implementJoin() throws InterruptedException {
		Thread threadCountDownV1 = new Thread(runnables.countdonwnVer1, "thread v1");
		Thread threadCountDownV2 = new Thread(runnables.countdonwnVer2, "thread v2");
		System.out.println("Starting Calling 2 thread join == thread v2 count down will wait for thread v1 count down finish");
		threadCountDownV1.start();
		threadCountDownV1.join(); //this indicate wait for thread 1 for ever until thread 1 finish
		threadCountDownV2.start();
		threadCountDownV2.join();
	
		//can't restore the threadCountDownV1 and threadCountDownV2
		Thread threadCountDownV3 = new Thread(runnables.countdonwnVer1, "thread v3");
		Thread threadCountDownV4 = new Thread(runnables.countdonwnVer2, "thread v4");
		System.out.println("\nStarting Calling 2 thread join == thread v4 count down will wait\n "
				+ " for thread v3 count down for a specific milisection time (in here i set 0,0010 milisec), after this period of time,\n"
				+ " not matter thread v3 finish or not, thread 4 will start anyway\n");
		threadCountDownV3.start();
		threadCountDownV3.join(100); //this indicate wait for thread 1 for ever until thread 1 finish
		threadCountDownV4.start();
	}
	
	public void demoThreadInterence() {
		Counter counter = new Counter();
		System.out.println("initial value: " + counter.value());
		runnables.incrementCounter(counter);
		System.out.println("increment call first - value is: " +  counter.value());
		System.out.println("increment call second - value is: " +  counter.value());
		runnables.decrementCounter(counter);
		System.out.println("decrement call first - value is: " +  counter.value());
		System.out.println("decrement call second - value is: " +  counter.value());
		System.out.println("Final value of counter is: " + counter.value());
	}
	
	public void demoSynchronizedThread() {
		System.out.println("This is going to test that, while the count up is synchorinizing, \n"
				+ "the count down thread has to wait until the count up thread dơn. \n"
				+ "But this synchronization does not affect the process of async task like countDownASync()");
		
		Counter counter = new Counter();
		
//		runnables.countUpASync(counter);
//		runnables.countDownASync(counter);
		
		runnables.countUpSync(counter);
		runnables.countDownSync(counter);
		
		//Call these function to test that in the period of time, the count up is synchronizing, thread async is allow to work ?
		runnables.countDownASync(counter);

	}
	public void demoSynchronizeWithIntrinsicLocks () {
		
		Counter counter = new Counter();
			
		runnables.countUpSyncIntrinsic(counter);
		runnables.countDownSyncIntrinsic(counter);
		
	}

	public void demoDeadlock() {
		System.out.println("When Deadlock runs, it's extremely likely that both threads will block when"
				+ "\n they attempt to invoke bowBack. Neither block will ever end, because each thread is"
				+ "\n waiting for the other to exit bow");
		System.out.println("==> no ones can bowback because of deadlock when try to call the sychronize"
						+ " method bowback() in synchronize method bow() ");
		final Deadlock.Friend alphonse = new Deadlock.Friend("Alphonse");
		final Deadlock.Friend gaston = new Deadlock.Friend("Gaston");
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();
	}
	
	public void demoGuardedBlocksWithProducerAndConsumerThreads() {
		Drop drop = new Drop();
		Producer producerRunnable = new Producer(drop);
		Consumer consumerRunnable = new Consumer(drop);
		Thread producerThread = new Thread(producerRunnable, "producer-thread");
		Thread consumerThread = new Thread(consumerRunnable, "consumer-thread");
		producerThread.start();
		consumerThread.start();
	}
	
	public void demoMutableObjectWithSynchronizedRGB() {
		SynchronizedRGB color = runnables.setSynchronizedRGB(8, 1, 2, "Putple");
		runnables.viewSynchronizedRGB(color);
		//color.set(8, 1, 3, "Puttple V2");
		color.invert();
		runnables.viewSynchronizedRGB(color);
		//SynchronizedRGB color2 = runnables.setSynchronizedRGB(8, 1, 5, "Apple");
		//runnables.getSynchronizedRGB(color2);
	}
	public void demoImmutableObjectWithImmutableRGB() {
		ImmutableRGB color = new ImmutableRGB(8, 1, 2, "Putple");	
		runnables.viewImmutableRGB(color);
		color = color.invert();
		runnables.viewImmutableRGB(color);
	
	}
	
}
