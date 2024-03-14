import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

//link to learn more https://nguyenvanquan7826.wordpress.com/2014/02/26/javaswing-borderlayout/
//https://www.geeksforgeeks.org/java-awt-borderlayout-class/?ref=gcse
//https://phocode.com/java/javaswing/java-swing-quan-ly-layout/
public class border_layout {

	public static void main(String[] args) {
		//Layout Manager = defines the natural ;ayout for components within a container
		//3 common managers
		//BorderLayout = a borderlayout places components in 5 areas: north, south, west, east, centre
	   //              = all extra space is places in the center area
		JFrame frame5 = new JFrame();
	    frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame5.setTitle("Learning a Border Layout");
	    frame5.setSize(500, 500);
	    frame5.setLayout(new BorderLayout());
	    frame5.setVisible(true);
	    
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    JPanel panel3 = new JPanel();
	    JPanel panel4 = new JPanel();
	    JPanel panel5 = new JPanel();
	    
	    panel1.setBackground(Color.gray);
	    panel2.setBackground(Color.blue);
	    panel3.setBackground(Color.pink);
	    panel4.setBackground(Color.green);
	    panel5.setBackground(Color.red);
	    
	    panel1.setPreferredSize(new Dimension(100,100));
	    panel2.setPreferredSize(new Dimension(100,100));
	    panel3.setPreferredSize(new Dimension(100,100));
	    panel4.setPreferredSize(new Dimension(100,100));
	    panel5.setPreferredSize(new Dimension(100,100));
	    
//	    Button button1 = new Button("1");
//	    Button button2 = new Button("2");
//	    Button button3 = new Button("3");
//	    Button button4 = new Button("4");
//	    Button button5 = new Button("5");
//	    
//	    button1.setPreferredSize(new Dimension(100,100));
//	    button2.setPreferredSize(new Dimension(100,100));
//	    button3.setPreferredSize(new Dimension(100,100));
//	    button4.setPreferredSize(new Dimension(100,100));
//	    button5.setPreferredSize(new Dimension(100,100));
	    
//	    frame5.add(button1, "North");
//	    frame5.add(button2, "South");
//	    frame5.add(button3, "East");
//	    frame5.add(button4, "West");
//	    frame5.add(button5, "Center");
	    
//	    frame5.add(button1, BorderLayout.NORTH);
//	    frame5.add(button2, BorderLayout.SOUTH);
//	    frame5.add(button3, BorderLayout.EAST);
//	    frame5.add(button4, BorderLayout.WEST);
//	    frame5.add(button5, BorderLayout.CENTER);
	    
	    frame5.add(panel1, BorderLayout.NORTH);
	    frame5.add(panel2, BorderLayout.SOUTH);
	    frame5.add(panel3, BorderLayout.EAST);
	    frame5.add(panel4, BorderLayout.WEST);
	    frame5.add(panel5, BorderLayout.CENTER);
	    
	    /*----------------------Set subpanel for pane5---------------------*/
	    
	    JPanel panel6 = new JPanel();
	    JPanel panel7 = new JPanel();
	    JPanel panel8 = new JPanel();
	    JPanel panel9 = new JPanel();
	    JPanel panel10 = new JPanel();
	    
	    panel6.setBackground(Color.orange);
	    panel7.setBackground(Color.black);
	    panel8.setBackground(Color.MAGENTA);
	    panel9.setBackground(Color.yellow);
	    panel10.setBackground(Color.CYAN);
	    
	    panel6.setPreferredSize(new Dimension(10,10));
	    panel7.setPreferredSize(new Dimension(10,10));
	    panel8.setPreferredSize(new Dimension(10,10));
	    panel9.setPreferredSize(new Dimension(10,10));
	    panel10.setPreferredSize(new Dimension(10,10));
	    
	    panel5.setLayout(new BorderLayout());
	    
	    panel5.add(panel6, BorderLayout.NORTH);
	    panel5.add(panel7, BorderLayout.SOUTH);
	    panel5.add(panel8, BorderLayout.EAST);
	    panel5.add(panel9, BorderLayout.WEST);
	    panel5.add(panel10, BorderLayout.CENTER);
	    
	    
	}

}
