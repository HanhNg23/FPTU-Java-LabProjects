import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Timer_Demo {

	public static void main(String[] args) {
		/* Timer = A facility for threads to schedule tasks
		 *         for future execution in a background thread*/
		/* TimerTask = A task that can be schedule for one - time 
		 *             or repeated execution by a Timer*/
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() { // links to the timer so when timer ups -> going to execute run()

			int counter = 10;
			@Override
			public void run() {
				System.out.println("Times up");
				if(counter > 0) {
				    System.out.println(counter + " seconds");
			    	counter--;
				}
				else {
					System.out.println("Happy new year!");
					timer.cancel();//to stop count down
				}
			}
			
		}; //be careful with ;
		
		//link the task to the timer
		//timer.schedule(task, 300); // 0 or any number display for delay time
		
//		Calendar date = Calendar.getInstance();
//		date.set(Calendar.YEAR, 2022);
//		date.set(Calendar.MONTH, Calendar.MAY);
//		date.set(Calendar.DAY_OF_MONTH, 4);
//		date.set(Calendar.HOUR_OF_DAY,18);	 // 18 -> 6 pm
//		date.set(Calendar.MINUTE, 48);
//		date.set(Calendar.SECOND, 0);
//		date.set(Calendar.MILLISECOND, 0);
//		timer.schedule(task, date.getTime());
		
	//this statement for counting down
		//timer.scheduleAtFixedRate(task, 0, 1000); //repeat every after 1 second //0 or any number display long delay
	
		
	//another demo
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2022);
		date.set(Calendar.MONTH, Calendar.MAY);
		date.set(Calendar.DAY_OF_MONTH, 4);
		date.set(Calendar.HOUR_OF_DAY,18);	 // 18 -> 6 pm
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		timer.scheduleAtFixedRate(task, date.getTime(), 1000); //start to count down at 18h 59' 0second
		

	}

}
