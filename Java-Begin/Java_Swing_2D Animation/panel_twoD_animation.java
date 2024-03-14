import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class panel_twoD_animation extends JPanel implements ActionListener{
	final int PANEl_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	Image image;
	Image backgroundImage;
	Image image2;
	Timer time;
	int xVelocity = 5; //try change to 2..
	int yVelocity = 3;
	int x = 0;
	int y = 0;
	
	
	public panel_twoD_animation() {
           this.setBackground(Color.green);
           this.setPreferredSize(new Dimension(PANEl_WIDTH, PANEL_HEIGHT));     
	       backgroundImage = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\insideout.jpeg").getImage();
           image = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-babys-room-100.png").getImage();
           image2 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-flying-stork-with-bundle-100.png").getImage();
           
	       time = new Timer(9, this);//1000miliseconds = 1 seconds
	       time.start();
	       
	}


	public void paint(Graphics g) {
		super.paint(g); //paint the background
		Graphics2D g2D= (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0,0,null);
		g2D.drawImage(image2, x, y, null);
		g2D.drawImage(image, x+50, y+60, null);
	
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(x >= PANEl_WIDTH - image.getWidth(null) || x < 0) {
			xVelocity = xVelocity *-1; //change direction
		}
		x = x + xVelocity;
		repaint(); //to call paint method again - to redraw everything
		
		if(y >= PANEL_HEIGHT - image.getHeight(null) || y < 0) {
			yVelocity = yVelocity *-1; //change direction
		}
		y = y + yVelocity;
		repaint(); //to call paint method again - to redraw everything
	}
}
