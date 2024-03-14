import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	MyFrame() {
		this.setVisible(true); // make frame visible
		this.setSize(550, 550);// sets the x-width, y - height
		this.setResizable(false);// prevent frame from being resized
		this.setTitle("This is my first creating Frame");// sets title of this.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set icon image
		ImageIcon image = new ImageIcon(
				"C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java_Swing\\convoi.png");// create
																												// an
																												// ImageIcon
		this.setIconImage(image.getImage());// change icon of this.
		this.getContentPane().setBackground(Color.magenta); // change color background
		this.getContentPane().setForeground(Color.YELLOW);
	}

}
