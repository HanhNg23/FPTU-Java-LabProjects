package window;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class WindowObject {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	

	
	WindowObject(){
		label.setText("Hello new window !");
		label.setBounds(250,250, 250, 250);
		label.setFont(new Font(null, Font.PLAIN, 30));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.white);
		label.setOpaque(true);

		
		frame.setLayout(new BorderLayout());
		frame.add(label, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}


}
