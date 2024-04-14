package layout;
import java.awt.GridLayout;

import javax.swing.*;

public class Gridlayout {
	public static void main(String[] args) {
		//Layout Manager = defines the natural layout got components within a container
		//GridLayout = places components in a grid of cells
		//           = each component takes all the available space within its cell
		//           = and each cell is the same size
		
		//Create a frame that has a Grid layout
		JFrame frame_7 = new JFrame();
		frame_7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_7.setSize(600, 500);
		frame_7.setLayout(new GridLayout(3,4,10,10)); 
		
		frame_7.add(new JButton("1")); 
		frame_7.add(new JButton("2"));
		frame_7.add(new JButton("3"));
		frame_7.add(new JButton("4"));
		frame_7.add(new JButton("5"));         
		frame_7.add(new JButton("6"));
		frame_7.add(new JButton("7"));
		frame_7.add(new JButton("8"));
		frame_7.add(new JButton("9"));
		frame_7.add(new JButton("10"));
		frame_7.add(new JButton("10"));
		frame_7.add(new JButton("10"));
		frame_7.add(new JButton("10"));
		frame_7.setVisible(true);
		
		
		
		
	}

}
