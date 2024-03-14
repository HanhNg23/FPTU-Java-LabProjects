package Java_JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frame_11 extends JFrame implements ActionListener {
	JTextField textField ;
	JButton button_of11 ;
	
		frame_11(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
	//	    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 	//or set like this but without statment pack();
			
			textField = new JTextField();
			textField.setPreferredSize(new Dimension(250,40));
			textField.setFont(new Font("Consolas", Font.BOLD, 20));
			textField.setForeground(Color.green);
			textField.setBackground(Color.black);
			textField.setCaretColor(Color.magenta); //color of pointer
			textField.setText("Your name: ");
			
			
	       //create button to submit
			 button_of11 = new JButton("Submit");
			button_of11.addActionListener(this);
			
			this.add(button_of11);
			this.add(textField);
			this.pack();
			this.setVisible(true);
			
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_of11) {
			String input = textField.getText();
			System.out.println(input);
			textField.setEditable(false);
			button_of11.setEnabled(false);
			
		
			
		}
		
	}

}
