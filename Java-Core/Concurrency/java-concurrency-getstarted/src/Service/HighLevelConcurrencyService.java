package Service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ForkJoinPool;

import RunnableTask.Bowloop;
import RunnableTask.ForkBlur;
import RunnableTask.Safelock.Friend;

public class HighLevelConcurrencyService {

	public void demoSafeLock() {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		final Friend anna = new Friend("Anna");
		new Thread(new Bowloop(alphonse, gaston)).start();
		new Thread(new Bowloop(gaston, alphonse)).start();
		//new Thread(new Bowloop(gaston, anna)).start();
	}
	
	public void demoForkJoinWithForkBlur() {
		// source image pixels are in src
		// destination image pixels are in dst
		throw new UnsupportedOperationException("Unimplement ForkBlur Yet !");
	}
}
