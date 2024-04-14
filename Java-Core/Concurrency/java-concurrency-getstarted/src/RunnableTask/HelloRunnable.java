package RunnableTask;

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("The message from HelloRunnable");
		System.out.println("Thread: " + Thread.currentThread().getName());
	}

}


