package colorchooser;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FrameDemoChangeColorUsing extends JFrame implements ActionListener{
		JFrame frame20;
		JButton button20, button20Background;
		JLabel label20;
		FrameDemoChangeColorUsing(){
			frame20 = new JFrame();
			button20 = new JButton();
			button20Background = new JButton();
			label20 = new JLabel();
			
			frame20.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame20.setLayout(new FlowLayout());
			frame20.getContentPane().setBackground(Color.orange);
	 		 
			
			button20.setText("Change Text Color");
			button20.addActionListener(this);
			button20.setVerticalAlignment(JButton.BOTTOM);
			
			button20Background.setText("Change Background Color");
			button20Background.addActionListener(this);
			
			label20.setText("This is some text ");
			label20.setFont(new Font("MV Boli", Font.PLAIN, 100 ));
			label20.setForeground(Color.white);
			label20.setBackground(Color.BLACK);
			label20.setOpaque(true);
						
			frame20.add(button20Background);
			frame20.add(button20);
			frame20.add(label20);
			frame20.pack();
			frame20.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button20) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Forground", Color.green);
			    label20.setForeground(color);
			}
			if(e.getSource() == button20Background) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Backgroud", Color.BLACK);
				label20.setBackground(color);
			}
			
		}
	}



