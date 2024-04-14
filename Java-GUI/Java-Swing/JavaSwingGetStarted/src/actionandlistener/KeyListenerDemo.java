package actionandlistener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

class Frame_KeyListener extends JFrame implements KeyListener{
	JFrame frame;
	JLabel label;
	ImageIcon image;
	public Frame_KeyListener() {
		
		frame = new JFrame();
		label = new JLabel();
		image = new ImageIcon("src/images/icons8-flour-48.png");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setBackground(Color.green);
		panel.setLayout(null);
		
		label = new JLabel();
		label.setIcon(image);
		label.setBounds(0, 0, 100, 100);
		label.setBackground(Color.black);
		label.setOpaque(true);
		
		
		JLabel labelInstruction = new JLabel();
		labelInstruction.setText("Press up; dowwn; left; right direction to move the item");
		labelInstruction.setPreferredSize(new Dimension(400,40));
		labelInstruction.setFont(new Font("Consolas", Font.BOLD, 12));
		labelInstruction.setForeground(Color.green);
		labelInstruction.setBackground(Color.black);
		
		panel.add(label);
		frame.add(panel);
		frame.add(labelInstruction);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		//keyTyped = Invoked when a key is typed. Uses KeyChar, char output
		switch(e.getKeyChar()) {
		case 'a': label.setLocation(label.getX()-2, label.getY()); //move to the left with 2 units => the x coordinate - 2
		          break;
		case 'w': label.setLocation(label.getX(), label.getY()-2); // up with 2 units => the y coordinate + 2 //try with 150
		          break;
		case 's': label.setLocation(label.getX(), label.getY()+2);//down with 2 units => the y coordinate - 2 //try with 150
			      break;
		case 'd': label.setLocation(label.getX()+2, label.getY());//move to the right with 2 units => the x coordinate + 2
			      break;	
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//  = Invoked when a physical key is pressed down. Uses keyCode, int output
		switch(e.getKeyCode()) {
		case 37: label.setLocation(label.getX()-2, label.getY()); //move to the left with 2 units => the x coordinate - 2 // 37 -> left
		          break;
		case 38: label.setLocation(label.getX(), label.getY()-2); // up with 2 units => the y coordinate + 2 //try with 150 //38 -> up
		          break;
		case 40: label.setLocation(label.getX(), label.getY()+2);//down with 2 units => the y coordinate - 2 //try with 150 //40 -> down
			      break;
		case 39: label.setLocation(label.getX()+2, label.getY());//move to the right with 2 units => the x coordinate + 2 //39 -> right
			      break;	
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// keyReleased = called whenever a button is released
	/*example---------------------------------------------------*/
		System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("this character's Code is: " + e.getKeyCode());
		
		
	}
	
}


public class KeyListenerDemo {

	public static void main(String[] args) {
		new  Frame_KeyListener();

	}

}
