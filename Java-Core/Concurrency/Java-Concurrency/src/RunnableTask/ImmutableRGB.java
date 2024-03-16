package RunnableTask;

import java.time.LocalTime;

final public class ImmutableRGB {

	// Values must be between 0 and 255.
	final private int red;
	final private int green;
	final private int blue;
	final private String name;

	private void check(int red, int green, int blue) {
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}

	public ImmutableRGB(int red, int green, int blue, String name) {
		System.out.println("[" + Thread.currentThread().getName() + "]" + " - Time :" + LocalTime.now() + " - new ImmutableRGB for color: " + name + " - object color: " + this.hashCode());
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;

	}

	public int getRGB() {
		return ((red << 16) | (green << 8) | blue);
	}

	public String getName() {
		return name;
	}

	public ImmutableRGB invert() {
		System.out.println("[" + Thread.currentThread().getName() + "]" + " - Time :" + LocalTime.now() + " - Inverting for color name: " + name + " - object color: " + this.hashCode());
		ImmutableRGB immutatbleRGB = new ImmutableRGB(255 - this.red, 255 - this.green, 255 - this.blue, "Inverse of " + this.name);
		return immutatbleRGB;
	}
}
