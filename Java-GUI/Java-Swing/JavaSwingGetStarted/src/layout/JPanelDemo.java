package layout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class JPanelDemo {

	public static void main(String[] args) {
		//JPanel = a GUI component that functions as a container to hold other components
		
		ImageIcon icon = new ImageIcon("src/images/6686319.png");
		JLabel label = new JLabel();
		label.setIcon(icon);
		label.setVerticalAlignment(JLabel.CENTER); //instruction 1
		label.setHorizontalAlignment(JLabel.CENTER);//instruction 2
		label.setBounds(45, 0, 45, 145);//instruction3
		label.setBackground(Color.yellow);
		label.setOpaque(true);
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		label.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		
		
//CREATE Panels		
		JPanel graypanel = new JPanel();
		graypanel.setBackground(Color.gray);
		graypanel.setBounds(0, 0, 250, 250);
		//graypanel.setLayout(new BorderLayout());
		graypanel.setLayout(null);
		
		
		JPanel bluepanel = new JPanel();
		bluepanel.setBackground(Color.blue);
		bluepanel.setBounds(250, 0, 250, 250);
		bluepanel.setLayout(new BorderLayout()); 
		bluepanel.setLayout(null);
		
		JPanel greenpanel = new JPanel();
		greenpanel.setBackground(Color.green);
		greenpanel.setBounds(0, 250, 500, 250);
		greenpanel.setLayout(new BorderLayout()); // add this statement so that instruction 1 and 2 can work
		//greenpanel.setLayout(null);//use this statement mean you have can add instruction 3
		
		JFrame frame3 = new JFrame();
		frame3.setSize(600, 600);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setVisible(true);
		frame3.setLayout(null);
		frame3.getContentPane().setBackground(Color.BLACK); 
		
		greenpanel.add(label);
		frame3.add(graypanel);
		frame3.add(bluepanel);
		frame3.add(greenpanel);
	

	}

}
