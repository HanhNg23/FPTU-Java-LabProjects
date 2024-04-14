package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class Flowlayout {

	public static void main(String[] args) {
		JFrame frame6 = new JFrame();
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setSize(500, 500);
		frame6.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 250));
		panel.setBackground(Color.green);
		panel.setLayout(new FlowLayout());

		JButton btn = new JButton();
		btn.setText("1"); // method text 2
		frame6.add(new JButton("A")); // method text 3 frame6.add(new JButton("2"));
		frame6.add(new JButton("B"));
		frame6.add(new JButton("C"));
		frame6.add(new JButton("D"));
		frame6.add(new JButton("E"));
		frame6.add(new JButton("F"));
		frame6.add(new JButton("G"));
		frame6.setVisible(true);

		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.add(new JButton("10"));
		frame6.add(panel);
		frame6.setVisible(true);

	}

}
