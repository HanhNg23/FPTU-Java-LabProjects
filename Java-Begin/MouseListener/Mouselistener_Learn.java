import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Frame_Mouselistener extends JFrame implements MouseListener{
	JFrame frame;
	JLabel label;
	ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;
	
	
	//the main constructor
	public Frame_Mouselistener() {
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		label =  new JLabel();
		
		//set Image
		icon1 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\child-with-pacifier-100.png");
		icon2 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-babys-room-100.png");
		icon3 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-crib-64.png");
		icon4 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-flying-stork-with-bundle-100.png");
		icon5 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\icons8-pacifier-100.png");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(230,230);
		frame.setLayout(null);
		
		label.setBounds(55, 50, 110, 110);
		label.setBackground(Color.pink);
		label.addMouseListener(this);
		label.setOpaque(true);
		
		label.setIcon(icon1);
		
		
		
		frame.add(label);
		frame.setLocationRelativeTo(null); //to help the screen pop up in the center of window
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Invoked when the mouse button has been clicked (pressed and released) on a component
		//System.out.println("you click the red");
		//label.setBackground(Color.blue);
		label.setIcon(icon1);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//Invoked when a mouse button has been pressed on a component
		//System.out.println("you press the mouse on the red area");
		//label.setBackground(Color.pink);
		label.setIcon(icon2);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Invoke when a mouse button has been released on a component
		//System.out.println("you release your mouse in the red area == you stop mousePressed procedure");
		//label.setBackground(Color.GREEN);
		label.setIcon(icon5);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//Invoke when the mouse enters a component
		//System.out.println("you enter the mouse out of red area");
		//label.setBackground(Color.orange);
		label.setIcon(icon4);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exists acomponent
		System.out.println("You existed the mouse");
		//label.setBackground(Color.black);
		label.setIcon(icon3);
	}
}
public class Mouselistener_Learn {

	public static void main(String[] args) {
		new Frame_Mouselistener();

	}

}
