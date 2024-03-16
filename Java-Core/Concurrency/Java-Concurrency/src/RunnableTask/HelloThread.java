package RunnableTask;

public class HelloThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + " Hello");
	}
}
