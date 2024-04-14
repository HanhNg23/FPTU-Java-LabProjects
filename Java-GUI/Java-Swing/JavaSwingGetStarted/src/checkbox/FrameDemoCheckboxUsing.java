package checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameDemoCheckboxUsing extends JFrame implements ActionListener {
	JButton button13;
	JCheckBox checkbox ;
	ImageIcon congau1 = new ImageIcon("src/images/con gau.jpg");
	JPanel panel;
	
	
	FrameDemoCheckboxUsing(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 250));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		button13 = new JButton();
		button13.setText("Submit");
		button13.addActionListener(e -> this.actionPerformed(e));
		
		checkbox = new JCheckBox();
		checkbox.setText("Want to see the picture of bear ?");
		checkbox.setVerticalAlignment(JCheckBox.BOTTOM);
		checkbox.setHorizontalAlignment(JCheckBox.CENTER);
		checkbox.setFocusable(false);
		checkbox.setFont(new Font("Consolas", Font.ROMAN_BASELINE, 12));
		
		
		panel.add(checkbox);
		panel.add(button13);
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button13) {
			System.out.println(checkbox.isSelected()); 
			if(checkbox.isSelected() == true) {
				button13.setIcon(congau1);
				button13.setEnabled(false);
				button13.setText("");
				panel.remove(checkbox);
				
			}
			
			
			
		}
		
	}

}
