import Service.HighLevelConcurrencyService;

public class HighLevelConcurrency {
	public static void main(String[] args) throws InterruptedException {

		HighLevelConcurrencyService service = new HighLevelConcurrencyService();
		// Demo SafeLock
		//service.demoSafeLock();
		
		// Demo FolkJoin
		service.demoForkJoinWithForkBlur();
	}
}

