import Service.ConcurrencyService;

public class Concurrency {

	public static void main(String[] args) 
			throws InterruptedException {
		
		ConcurrencyService service = new ConcurrencyService();
		


		
//		//Demo Thread Sync with Intrinsic Blocks
		service.demoSynchronizeWithIntrinsicLocks();
		
		//Demo DeadLock 
		//service.demoDeadlock();
		
		////Demo Guarded Blocks With Exchange Message Between Producer and Consumer
		//service.demoGuardedBlocksWithProducerAndConsumerThreads();
		
		//Demo Mutable Object via SynchorizedRGB object
		//service.demoMutableObjectWithSynchronizedRGB();
		
		//Demo Immutable Object via SynchorizedRGB object
		//service.demoImmutableObjectWithImmutableRGB();

		
	}

}

