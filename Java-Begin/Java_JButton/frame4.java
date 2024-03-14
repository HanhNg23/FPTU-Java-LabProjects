import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class frame4 extends JFrame implements ActionListener {
	JButton button; //button is global variable now
	JLabel label ;
	frame4(){
		//Border border = BorderFactory.createLineBorder(Color.green, 3, true);
		button = new JButton();
		label = new JLabel();
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java_JButton\\playicon.png");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java_JButton\\convoi.png");
		
		//customize label
		label.setBounds(300, 100, 650, 700);
		label.setIcon(icon2);
		label.setText("HELLO HELLO");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("MV Boli", Font.PLAIN,20));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setVisible(false);
		
		// customize button
		button.setBounds(100, 100, 250, 200);
		button.setText("Click");
		button.setForeground(Color.MAGENTA);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setFocusable(false); //delete the borderline cover the text
		button.setBackground(Color.CYAN);
		button.setIcon(icon);
		button.setVerticalAlignment(JButton.CENTER);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setFont(new Font("Comic Sans", Font.BOLD, 25));
		button.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		//button.setBorder(BorderFactory.createEtchedBorder());
//		button.setEnabled(false); //make the button can't work
		button.addActionListener(this); //number 1
//		button.addActionListener(e -> System.out.println("PUM PUM PUM")); // add only statement without number 1 and 2
		
		this.setSize(400, 400);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(button);
		this.add(label);
		//this.pack();//this statement include setBounds and setLayout
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { //number 2
		if(e.getSource() == button) {
//			System.out.println("PUM PUM PUM");
			//button.setEnabled(false);

			label.setVisible(true);
	        		}
	}
}
