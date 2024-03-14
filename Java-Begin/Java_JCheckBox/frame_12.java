import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class frame_12 extends JFrame implements ActionListener {
	JButton button_13;

	JCheckBox checkbox ;
	
	ImageIcon congau1 ;
	ImageIcon congau2 ;
	
	
	frame_12(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setLayout(new FlowLayout());
		/*Learn how to scale image please*/
		 congau1 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java_JCheckBox\\con gau.jpg");
		 congau2 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java_JCheckBox\\escandalosos-la-pelicula.jpg");
		 
		
		button_13 = new JButton();
		button_13.setText("Submit");
		button_13.addActionListener(this);
		
		checkbox = new JCheckBox();
		checkbox.setText("I'm not a Robot");
		checkbox.setVerticalAlignment(JCheckBox.BOTTOM);
		checkbox.setHorizontalAlignment(JCheckBox.CENTER);
		checkbox.setFocusable(false);
		checkbox.setFont(new Font("Consolas", Font.ROMAN_BASELINE, 35));
		checkbox.setIcon(congau1);
		checkbox.setDisabledSelectedIcon(congau2);
		
		this.add(button_13);
		this.add(checkbox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_13) {
			System.out.println(checkbox.isSelected()); 
			if(checkbox.isSelected() == true) {
				System.out.println("It is a robot");
			}
			
			
			
		}
		
	}

}
