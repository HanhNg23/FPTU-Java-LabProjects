
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class newWindow {
	JFrame frame_9 = new JFrame();
	JLabel label_2 = new JLabel("HELLO!");
	

	
	newWindow(){
		label_2.setBounds(100,100, 250, 250);
		label_2.setFont(new Font(null, Font.PLAIN, 30));
		label_2.setBackground(Color.BLACK);
		label_2.setForeground(Color.white);
		label_2.setOpaque(true);
		label_2.setVerticalTextPosition(JLabel.CENTER);
		label_2.setHorizontalTextPosition(JLabel.CENTER);
		
		
		//addlabel to frame
		frame_9.add(label_2);
		
		frame_9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_9.setSize(500,500);
		frame_9.setLayout(null);
		frame_9.setVisible(true);
		
		
		
	}


}
