import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class flow_layout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame frame6 = new JFrame();
frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame6.setSize(500,500);
//frame6.setLayout(new FlowLayout());
frame6.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

JPanel Panel = new JPanel();
Panel.setPreferredSize(new Dimension(250,250));
Panel.setBackground(Color.green);
Panel.setLayout(new FlowLayout());

//JButton bto1 = new JButton("1"); //method text 1
//bto1.setText("1"); //method text 2
/*frame6.add(new JButton("1")); //method text 3
frame6.add(new JButton("2"));
frame6.add(new JButton("3"));
frame6.add(new JButton("4"));
frame6.add(new JButton("5"));
frame6.add(new JButton("8"));
frame6.add(new JButton("9"));
frame6.add(new JButton("10"));
frame6.setVisible(true); //let this statement stand here so that the button can work */

Panel.add(new JButton("1"));
Panel.add(new JButton("2"));
Panel.add(new JButton("3"));
Panel.add(new JButton("4"));
Panel.add(new JButton("5"));
Panel.add(new JButton("8"));
Panel.add(new JButton("9"));
Panel.add(new JButton("10"));
frame6.add(Panel);
frame6.setVisible(true); 




	}

}
