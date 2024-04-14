package timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeSchedule {

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
				System.out.print("Times count down ");
				if(counter > 0) {
				    System.out.println(counter + " seconds");
			    	counter--;
				}
				else {
					System.out.println("Happy new year!");
					timer.cancel();//to stop count down
				}
			}
			
		}; 
		
		//link the task to the timer
		timer.schedule(task, 0, 1000); // 0 or any number display for delay time
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2022);
		date.set(Calendar.MONTH, Calendar.MAY);
		date.set(Calendar.DAY_OF_MONTH, 4);
		date.set(Calendar.HOUR_OF_DAY,18);	 // 18 -> 6 pm
		date.set(Calendar.MINUTE, 48);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		//timer.schedule(task, date.getTime()); //take time from date and set schedule for doing task in main thread
		//timer.scheduleAtFixedRate(task, 0, 1000); //repeat every after 1 second //0 or any number display long delay
	
		

		

	}

}
