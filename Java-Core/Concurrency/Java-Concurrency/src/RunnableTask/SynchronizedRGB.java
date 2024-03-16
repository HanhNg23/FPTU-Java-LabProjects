package RunnableTask;

import java.time.LocalTime;

/*defines objects that represent colors*/
/*Each object represents the color as three
 *integers that stand for primary color values
 *and a string that gives the name of the color*/

/*define an immutable class by declaring all of
its fields as private, as well as disabling all setter methods*/
public class SynchronizedRGB {
	// Values must be between 0 and 255.
	private int red;
	private int green;
	private int blue;
	private String name;


	public SynchronizedRGB(int red, int green, int blue, String name) {
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}

	public SynchronizedRGB() {
		// TODO Auto-generated constructor stub
	}
	private void check(int red, int green, int blue) {
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}

	public void set(int red, int green, int blue, String name) {
		synchronized (this) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + " - Time :" + LocalTime.now() + " - Setting for color name: " + name + " - object color: " + this.hashCode());
			check(red, green, blue);
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;
		}
	}
	
	public synchronized int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }
	public synchronized String getName() {
        return name;
    }

    public synchronized void invert() {
		System.out.println("[" + Thread.currentThread().getName() + "]" + " - Time :" + LocalTime.now() + " - Inverting for color name: " + name + " - object color: " + this.hashCode());
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
        name = "Inverse of " + name;
        
    }
    
    /*If another thread invokes color.set after Statement 1
	 * but before Statement 2, the value of myColorInt won't
	 * match the value of myColorName. To avoid this outcome,
	 * the two statements must be bound together:
	 * */
    public void getColor() {
    	synchronized (this) {
    	    int myColorInt = this.getRGB(); //statement 1
    	    String myColorName = this.getName(); //statement 2
    	    System.out.println("[" + Thread.currentThread().getName() + "]" + " - Time :" + LocalTime.now()
			+ " - Get color name: " + myColorName + " - value: " + myColorInt + " - object color: "
			+ this.hashCode());
    	} 
    }
}
