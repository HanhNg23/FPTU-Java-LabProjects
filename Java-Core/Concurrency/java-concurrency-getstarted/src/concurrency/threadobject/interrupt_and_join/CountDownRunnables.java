package concurrency.threadobject.interrupt_and_join;


import Service.Util;

public class CountDownRunnables {

	public Runnable countdonwnVer1 = new Runnable() {
		@Override
		public void run() {
			int i = 8;
			Util.threadMessage("Staring count down from number " + i + " to 0");
			while (i >= 0) {
				Util.threadMessage("current number count down : " + i);
				Util.threadMessage("Start 4 seconds sleeping ");
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					Util.threadMessage("Interruped Exception occurs - Oh, I have not finished my count down ! Wait for me !");
				}
				i--;
			}
		}
	};
}
