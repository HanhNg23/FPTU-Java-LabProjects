package concurrency.threadobject.sleeptime;

import java.time.LocalTime;
import java.util.Timer;

public class PausingExecWithSleepTime {

	public static void main(String[] args) {
		System.out.println("Start Thread " + Thread.currentThread().getName() + " - Task: "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		StackTraceElement stacktrace[] = Thread.currentThread().getStackTrace();
		for (int x = 0; x < stacktrace.length; x++) {
			System.out.println("Stack frame: " + stacktrace[x].getMethodName());
		}
		
		System.out.println("==========================");
		int i = 0;
		while (i <= 10) {
			System.out.println("[" + Thread.currentThread().getName() + "]-------" + "i: " + i);
			try {
				System.out.println("[" + Thread.currentThread().getName() + "-" + LocalTime.now() + "]-------" + "Start 2 seconds sleeping");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.print("[" + Thread.currentThread().getName() + "]-------" + "Terminated because exceptions occur" );
				e.printStackTrace();
			}
			System.out.println("[" + Thread.currentThread().getName() + "-" + LocalTime.now() + "]-------" + "Execute back after 2 seconds sleep");
			System.out.println("[" + Thread.currentThread().getName() + "]-------" + "Call i at the time i++ directly: " + (i++) + " >><< after i++ the value is == the 2nd call: " + i);
			System.out.println("[" + Thread.currentThread().getName() + "]-------" + "Is Thread Interrupted: " + Thread.interrupted());
			System.out.println("\n");
		}

	}
}
