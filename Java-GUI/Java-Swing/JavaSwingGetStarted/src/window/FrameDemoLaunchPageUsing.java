package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameDemoLaunchPageUsing implements ActionListener {
	// let create 2 object
	JFrame frame = new JFrame();
	JButton theButton = new JButton("New Window");

	// create constructor
	FrameDemoLaunchPageUsing() {

		theButton.setBounds(100, 160, 200, 40);
		theButton.setFocusable(false);
		// add action to theButton
		theButton.addActionListener(this);

		frame.add(theButton);// add theButton to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == theButton) { // if you click you can open new window
			frame.dispose();
			WindowObject myWindow = new WindowObject();
		}

	}

}
