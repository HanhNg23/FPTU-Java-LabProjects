package button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class FrameDemoButtonUsing extends JFrame implements ActionListener {
	JButton button; //button is global variable now
	JLabel label ;
	FrameDemoButtonUsing(){
		Border border = BorderFactory.createLineBorder(Color.green, 3, true);
		button = new JButton();
		label = new JLabel(); //Label - represent for the area contains only the text
		
		ImageIcon icon = new ImageIcon("src/images/playicon.png");
		ImageIcon icon2 = new ImageIcon("src/images/convoi.png");
		
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
		
		//customize button
		button.setBounds(100, 100, 250, 200);
		button.setText("Click");
		button.setForeground(Color.MAGENTA);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setFocusable(false); 
		button.setBackground(Color.CYAN);
		button.setIcon(icon);
		button.setVerticalAlignment(JButton.CENTER);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setFont(new Font("Comic Sans", Font.BOLD, 25));
		button.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		button.setBorder(BorderFactory.createEtchedBorder());
		button.addActionListener(e -> this.actionPerformed(e));
		
		//button.addActionListener(e -> System.out.println("PUM PUM PUM"));
		
		this.setSize(400, 400);
		this.setVisible(true);
		this.setLayout(new CardLayout(20,20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(button);
		this.add(label);
		this.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("PUM PUM PUM");
			button.setEnabled(false);
			button.setVisible(false);
			label.setVisible(true);
		}
	}
}
