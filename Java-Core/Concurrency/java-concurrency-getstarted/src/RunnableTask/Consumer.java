package RunnableTask;

import java.time.LocalTime;
import java.util.Random;

/*The consumer thread, defined in Consumer, 
 * simply retrieves the messages and prints 
 * them out, until it retrieves the "DONE" string. 
 * This thread also pauses for random intervals*/
public class Consumer implements Runnable {
	private Drop drop;

	public Consumer(Drop drop) {
		this.drop = drop;
	}
	@Override
	public void run() {
		Random random = new Random();
        try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {

            System.out.format("["+ Thread.currentThread().getName() + "]" + " MESSAGE RECEIVED: %s%n", message + " - Time " + LocalTime.now());
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
		
        }
	}

}
