package layout;
import java.awt.Color;

import javax.swing.*;

public class JLayerPaneDemo {

	public static void main(String[] args) {
		//JLayeredPane = Swing container that provides a
		//               third dimension for positioning components
		//               ex. depth, z-index
		

		//now Let add components by using JLabel
		JLabel labelOne = new JLabel();
		labelOne.setOpaque(true);
		labelOne.setBackground(Color.BLACK);
		labelOne.setBounds(50, 50, 200, 200);

		JLabel labelTwo = new JLabel();
		labelTwo.setOpaque(true);
		labelTwo.setBackground(Color.PINK);
		labelTwo.setBounds(100, 100, 200, 200);
		
		JLabel labelThree = new JLabel();
		labelThree.setOpaque(true);
		labelThree.setBackground(Color.GRAY);
		labelThree.setBounds(150, 150, 200, 200);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,500,500);
		
		//add components to layeredPane
/*		layeredPane.add(labelOne);
		layeredPane.add(labelTwo);
		layeredPane.add(labelThree); */
		
		/*----------------------------------------------------------------------------------------*/
		  /*Question how i can control the accumulation = super position ?
		    There are 2 ways */
		/*----------------------------------------------------------------------------------------*/
		
		//Method 1: 
		//         You should to know the sequence accumulation from the bottom to the top:
		//         Default --> Palette --> Model --> Pop Up --> Drag. See demo Pink - Black - Gray
	/*	layeredPane.add(labelOne, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(labelTwo,JLayeredPane.DRAG_LAYER);
		layeredPane.add(labelThree, JLayeredPane.MODAL_LAYER);  */
		// if set as layeredPane.add(labelThree, JLayeredPane.MODAL_DeFault); ...SO the sequence accumulation depends on the sequence statements --> Black hides Gray
		
		
		//Method 2:
		//         You number to mark the sequence accumulation
		//         See demo Pink - Black - Gray
		layeredPane.add(labelOne, Integer.valueOf(0));
		layeredPane.add(labelTwo, Integer.valueOf(7));
		layeredPane.add(labelThree,Integer.valueOf(5));
		
	
		
		
		
		JFrame frame_8 = new JFrame("JLayeredPane");
		frame_8.add(layeredPane);
		frame_8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_8.setSize(500, 500);
		frame_8.setLayout(null);
		frame_8.setVisible(true);
		
		

	}

}
