import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
public class DragPanel extends JPanel{
	ImageIcon image = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-flying-stork-with-bundle-100.png");
	final int WIDTH = image.getIconWidth();
	final int HEIGHT = image.getIconHeight();
	boolean dragValid = false;
	Point imageCorner;
	Point prevPt; //previous point
	
	DragPanel(){
		imageCorner = new Point(0,0); //Initial position ofimage
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);  //"this" here is DragPanel
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		image.paintIcon(this, g, (int)imageCorner.getX(), (int) imageCorner.getY());
		
		
	}
	
	private class ClickListener extends MouseAdapter{ //method for click the mouse
		public void mousePressed(MouseEvent e) {
			prevPt = e.getPoint(); //update the previous point when ever we click
			dragValid = ((e.getPoint().getX() > imageCorner.getX()) &&
					      (e.getPoint().getX() < (imageCorner.getX() + WIDTH))&&
					      (e.getPoint().getY() > imageCorner.getY())&&
					      (e.getPoint().getY() < imageCorner.getY() + HEIGHT));
		}
	}
	private class DragListener extends MouseMotionAdapter{
		//move image or mouse around
		public void mouseDragged(MouseEvent e) {
			if(dragValid) {
	     		Point currentPt = e.getPoint();
		    	imageCorner.translate(
			    		(int)(currentPt.getX() - prevPt.getX()),
				    	(int)(currentPt.getY() - prevPt.getY()));
			
		    	prevPt = currentPt;
			    repaint();
			}
		}
	}
}
