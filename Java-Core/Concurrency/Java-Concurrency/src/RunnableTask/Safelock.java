package RunnableTask;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safelock {
	public static class Friend {
		private final String name;
		/*The biggest advantage of Lock objects over implicit locks
		 * is their ability to back out of an attempt to acquire a lock.
		 * The tryLock method backs out if the lock is not available 
		 * immediately or before a timeout expires (if specified). 
		 * The lockInterruptibly method backs out if another thread 
		 * sends an interrupt before the lock is acquired.*/
		private final Lock lock = new ReentrantLock();

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
		
		 public boolean impendingBow(Friend bower) {
	            Boolean myLock = false;
	            Boolean yourLock = false;
	            try {
	                myLock = lock.tryLock();
	                yourLock = bower.lock.tryLock();
	            	//System.out.println("Waiting for allow to bow " + " myLock: " + myLock + " - yourLock: " + yourLock);
	            } finally {
	                if (! (myLock && yourLock)) {
	                    if (myLock) {
	                        lock.unlock();
	                    }
	                    if (yourLock) {
	                        bower.lock.unlock();
	                    }
	                }
	            }
	            return myLock && yourLock;
	        }
		 
		 public void bow(Friend bower) {
	            if (impendingBow(bower)) {
	                try {
	                    System.out.format("[" + Thread.currentThread().getName() + "] - " + "%s: %s has"
	                        + " bowed to me!%n", 
	                        this.name, bower.getName());
	                    bower.bowBack(this);
	                } finally {
	                    lock.unlock();
	                    bower.lock.unlock();
	                }
	            } else {
	                System.out.format("[" + Thread.currentThread().getName() + "] - " + "%s: %s started"
	                    + " to bow to me, but saw that"
	                    + " I was already bowing to"
	                    + " %s.%n",
	                    this.name, bower.getName(), bower.getName());
	            }
	        }
		 
		 public void bowBack(Friend bower) {
	            System.out.format("[" + Thread.currentThread().getName() + "] - " + "%s: %s has" +
	                " bowed back to me!%n",
	                this.name, bower.getName());
	        }
	    }
	}
	

