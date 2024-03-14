import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener {
	//let create 2 object
	JFrame frame_9 = new JFrame();
	JButton theButton = new JButton("New Window");
	
	//create constructor
	LaunchPage(){
		
		theButton.setBounds(100,160,200,40);
		theButton.setFocusable(false);
		//add action to theButton
		theButton.addActionListener(this);
		
		frame_9.add(theButton);//add theButton to the frame 
		frame_9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_9.setSize(500,500);
		frame_9.setLayout(null);
		frame_9.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == theButton) { //if you click you can open new window
			frame_9.dispose();
			newWindow myWindow = new newWindow();
		}
		
		
	}

}
