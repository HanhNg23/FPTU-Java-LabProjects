import Service.ConcurrencyService;

public class Concurrency {

	public static void main(String[] args) 
			throws InterruptedException {
		
		ConcurrencyService service = new ConcurrencyService();
		
		////Define Thread
		//service.startMySubThreads();
		
		////Demo Pausing Execute Thread with sleep()
		//service.pausingExecWithSleepMessage();
		
		////Demo Using Tread Join
		//service.implementJoin();
		
//		//Demo Thread Interference
//		/*Interference happens when two operations, running 
//		 *in different threads, but acting on the same data, interleave*/
//		service.demoThreadInterence();
//		int c = 5;
//		System.out.println("c: " + c + " c++: " + c++ + " c 2nd: " + c + " c--: " + c-- + " c 2nd: " + c);
//		int e = 5;
//		System.out.println("e: " + e + " ++e: " + ++e + " e 2nd: " + e + " --e: " + --e + " e 2nd: " + e);
		
		
//		//Demo Thread Sync
//		service.demoSynchronizedThread();
		
//		//Demo Thread Sync with Intrinsic Blocks
//		service.demoSynchronizeWithIntrinsicLocks();
		
		//Demo DeadLock 
		//service.demoDeadlock();
		
		////Demo Guarded Blocks With Exchange Message Between Producer and Consumer
		//service.demoGuardedBlocksWithProducerAndConsumerThreads();
		
		//Demo Mutable Object via SynchorizedRGB object
		//service.demoMutableObjectWithSynchronizedRGB();
		
		//Demo Immutable Object via SynchorizedRGB object
		service.demoImmutableObjectWithImmutableRGB();

		
	}

}

