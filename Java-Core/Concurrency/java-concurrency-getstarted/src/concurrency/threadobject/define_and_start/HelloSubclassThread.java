package concurrency.threadobject.define_and_start;

public class HelloSubclassThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("[" + Thread.currentThread().getName() + "]-------"
				+ "The message from HelloSubclassThread object - instance of Thread");
	}
	
	public static void main(String[] args) {
		//Create the instance of Thread
		Thread helloSubclassThread = new HelloSubclassThread();
		System.out.println("[" + Thread.currentThread().getName() + "]-------"
				+ "Hello, I am from main thread");
		helloSubclassThread.start();
		
	}

}
