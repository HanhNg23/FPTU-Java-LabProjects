package RunnableTask;

/* the data is a series of text messages,
 *  which are shared through an object of type Drop*/
public class Drop {
	 // Message sent from producer to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized String take() {
    	// empty = false: wait for consumer receive message == producer has sent message
    	// empty = true: wait for producer send new message == consumer has received old message
        
    	// Wait until message is
        // available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;
        // this notify producer that
        // status has changed.
        notifyAll();
        return message;
    }
    
    public synchronized void put(String message) {
        // Wait until message has
        // been retrieved.
    	// empty = false: wait for consumer receive message == producer has sent message
    	// empty = true: wait for producer send new message == consumer has received old message
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }

        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
    
	
}
