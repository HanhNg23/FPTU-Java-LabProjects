package actionandlistener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Game {
	
	JFrame frame;
	JLabel label;
	//create action object;
	Action upAction;
	Action downAction;
	Action leftAction;
	Action rightAction;
	Game(){
		frame = new JFrame("Key Bindings Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new FlowLayout());
		
		label = new JLabel();
		label.setBackground(Color.yellow);
		label.setBounds(0, 0, 50, 50);
		label.setOpaque(true);
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setBackground(Color.green);
		panel.setLayout(null);
		panel.add(label);
		
		JLabel labelInstruction = new JLabel();
		labelInstruction.setText("Press w -> up; s -> down; a -> left; d -> right");
		labelInstruction.setFont(new Font("MV Boli", Font.BOLD, 15));
		labelInstruction.setForeground(Color.black);
		labelInstruction.setVisible(true);
		
		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();
		
		
//		label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UpppAction"); //be careful -> UP must be Uppercased
//		label.getActionMap().put("UpppAction", upAction);
//		label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
//		label.getActionMap().put("downAction", downAction);
//		label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
//		label.getActionMap().put("leftAction", leftAction);
//		label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
//		label.getActionMap().put("rightAction", rightAction);
		
		
		
		label.getInputMap().put(KeyStroke.getKeyStroke('w'), "UpppAction"); //be careful -> UP must be Uppercased
		label.getActionMap().put("UpppAction", upAction);
		label.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
		label.getActionMap().put("downAction", downAction);
		label.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
		label.getActionMap().put("leftAction", leftAction);
		label.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
		label.getActionMap().put("rightAction", rightAction);
		
		frame.add(labelInstruction);
		frame.add(panel);
		frame.setLocationRelativeTo(null); //to help the screen pop up in the center of window
		frame.setVisible(true);
	
	}
	public class UpAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY()-10);
			
		}
	}
	public class DownAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY()+10);
			
		}
		
	}
	public class LeftAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()-10, label.getY());
			
		}
		
	}
	public class RightAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()+10, label.getY());
		}
		
	}
	
	
	

}
