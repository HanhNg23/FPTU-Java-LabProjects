import java.awt.GridLayout;

import javax.swing.*;

public class Grid_Layout {
	public static void main(String[] args) {
		//Layout Manager = defines the natural layout got components within a container
		//GridLayout = places components in a grid of cells
		//           = each component takes all the available space within its cell
		//           = and each cell is the same size
		
		//Create a frame that has a Grid layout
		JFrame frame_7 = new JFrame();
		frame_7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_7.setSize(500, 500);
		//Add this statement below otherwise the number 10 will take up whole screen and hide the rest of numbers
		frame_7.setLayout(new GridLayout(2,8, 10, 8)); //2 rows and 8 column : 10 is horizontal gaps and 8 is vertical gaps
	//	frame_7.setLayout(new GridLayout(3,4)); //let try this case with 9 buttons and 10 buttons
		
		//JButton button1 = new JButton("1"); method one
		frame_7.add(new JButton("1")); //method 2
		frame_7.add(new JButton("2"));
		frame_7.add(new JButton("3"));
		frame_7.add(new JButton("4"));
		frame_7.add(new JButton("5"));         //With 9 output - 9 button arranges in 9 column but > 9 buttons --> all the buttons are divided into 2 columns as a default
		frame_7.add(new JButton("6"));
		frame_7.add(new JButton("7"));
		frame_7.add(new JButton("8"));
		frame_7.add(new JButton("9"));
		//frame_7.add(new JButton("10"));
		
		
		
		frame_7.setVisible(true);
		
		
		
		
	}

}
