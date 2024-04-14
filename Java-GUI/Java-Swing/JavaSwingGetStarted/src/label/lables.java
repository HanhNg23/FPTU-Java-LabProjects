package label;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;

public class lables {

	public static void main(String[] args) {
		ImageIcon image = new ImageIcon("src/images/convoi.png");
		image.getImage().getScaledInstance(40, 60, 20);
	   
		Border border = BorderFactory.createLineBorder(Color.green, 8, true); //set border within the label
		
	    //Setting for label
	    JLabel label = new JLabel();
		label.setText("Move your mouse around the picture !");
		label.setToolTipText("When you move your mouse to here. It displays \"WELL\"");
		label.setIcon(image);
		
		label.setIconTextGap(-100);//set the gap between the image and the text
		label.setVerticalTextPosition(JLabel.NORTH);//set vertical position for text
		label.setHorizontalTextPosition(JLabel.CENTER);//set horizontal text position
		label.setHorizontalAlignment(JLabel.CENTER);//set horizontal position of icon+text within label
		label.setVerticalAlignment(JLabel.CENTER);//set vertical position of icon+text within label
		label.setForeground(Color.yellow);//set color for text
		label.setFont(new Font("MV Boli", Font.PLAIN,20)); //set font style and size
		label.setBackground(Color.MAGENTA);//set color background
		label.setOpaque(true); //make back ground visible
	    label.setBorder(border); //add border
	//  label.setBounds(100, 100, 450, 650); //youtube research - related to myframe2.set layout(null);				
			    
		//First: create a frame
		JFrame myframe2 = new JFrame();
		myframe2.setSize(800, 900);
		myframe2.setVisible(true);
		myframe2.setIconImage(image.getImage());
		myframe2.setTitle("My first design for Label");
	//	myframe2.setLayout(null);
		myframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe2.add(label);//the label should before the pack
		myframe2.pack();//this function is uses to include setBounds and setLayout

	}

}
