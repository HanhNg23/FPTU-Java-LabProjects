package filechooser;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FrameDemoJFileUsing extends JFrame implements ActionListener {
	JFrame frame;
	JButton button;
	JLabel label;
	FrameDemoJFileUsing() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(300, 300);

		label = new JLabel();
		label.setText("Select file");
		label.setFont(new Font("MV Boli", Font.PLAIN, 15));
		label.setForeground(Color.white);
		label.setBackground(Color.BLACK);
		label.setOpaque(true);
		label.setVisible(true);
		
		button = new JButton("Select File");
		button.addActionListener(this);
		
		frame.add(label);
		frame.add(button);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {

			JFileChooser fileChooser = new JFileChooser();

			
			fileChooser.setCurrentDirectory(new File("C:/Users"));
			int response = fileChooser.showSaveDialog(label);

			if (response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				label.setText("File is choosen: " + file.getName());
				System.out.println(file.getAbsolutePath());

			}
			
			

		}

	}

}
