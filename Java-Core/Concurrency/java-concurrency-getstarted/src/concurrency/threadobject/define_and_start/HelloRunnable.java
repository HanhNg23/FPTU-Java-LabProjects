package concurrency.threadobject.define_and_start;

public class HelloRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("[" + Thread.currentThread().getName() + "]-------"
				+ "The message from HelloRunnable object - instance of Runnable");
	}
	
	public static void main(String[] args) {
		//Create the instance of Runnable object
		Runnable helloRunnable = new HelloRunnable();
		//Create the thread instance that run the Runnable object
		Thread threadHelo = new Thread(helloRunnable);
		
		System.out.println("[" + Thread.currentThread().getName() + "]-------"
				+ "Hello, I am from main thread");
		//Start the thread
		threadHelo.start();
		
	}

}
