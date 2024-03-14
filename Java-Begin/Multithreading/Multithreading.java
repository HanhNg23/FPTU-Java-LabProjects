
public class Multithreading {

	public static void main(String[] args) throws InterruptedException {
		/**/
		//there are two ways to create thread
		
		//Way 1 : create subclass of the Thread class
		MyThread thread1 = new MyThread();
		//Way 2: create a class that implements Runnable interfaces and pass instance as an argument to Thread()
		MyRunnable runnable1 = new MyRunnable();
		Thread thread2 = new Thread(runnable1);
		
//		thread1.setDaemon(true);  //learn more about Daemon 
//		thread2.setDaemon(true);
		thread1.start();
		//thread1 .join(); //calling thread (ex.main) waits until the specified thread dies or for x milliseconds
		//thread1.join(3000); 
		thread2.start();
		System.out.println("See they finish at the same time");
        
		System.out.println(1/0); //although this statement is error but thread 1 and thread 2 still work
		
	}

}
