package slider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class FrameDemoJSliderUsing extends JFrame implements ChangeListener {

	JFrame frameNEW;
	JPanel panelNEW;
	JLabel labelNEW;
	JSlider slider;

	FrameDemoJSliderUsing() {
		frameNEW = new JFrame("Slider Demo");
		panelNEW = new JPanel();
		labelNEW = new JLabel();
		slider = new JSlider(0, 100, 50); // minimum: 0 --> max:100, 50 is the gap to jump

		slider.setPreferredSize(new Dimension(400, 400)); // set the width and height for the jack
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10); // dividing line : each line is spaced 10 unit

		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(25); // each 25 unitt there are larger jack

		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli", Font.PLAIN, 20));
		// slider.setOrientation(SwingConstants.VERTICAL); //set the track line in
		// vertically
		slider.setOrientation(SwingConstants.HORIZONTAL);

		// labelNEW.setText("The height = " + slider.getValue() + "cm");
		labelNEW.setFont(new Font("MV Boli", Font.PLAIN, 25));

		slider.addChangeListener(this);
		panelNEW.add(slider);
		panelNEW.add(labelNEW);
		frameNEW.add(panelNEW);
		frameNEW.setSize(500, 500);
		frameNEW.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		labelNEW.setText("The height = " + slider.getValue() + "cm");

	}

//		@Override
//		public void stateChange(ChangeEvent e) {
//			labelNEW.setText("The height = " + slider.getValue() + "cm");
//			if(e.getSource() == slider) {
//				System.out.println(slider.getValue());
//			}
//			
//		}

}
