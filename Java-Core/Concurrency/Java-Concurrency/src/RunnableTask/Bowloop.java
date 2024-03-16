package RunnableTask;
import java.util.Random;

import RunnableTask.Safelock.Friend;

public class Bowloop implements Runnable{
	private Friend bower;
    private Friend bowee;

    public Bowloop(Friend bower, Friend bowee) {
        this.bower = bower;
        this.bowee = bowee;
    }

	@Override
	public void run() {
		Random random = new Random();
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
            bowee.bow(bower);
        }
		
	}
	
}
