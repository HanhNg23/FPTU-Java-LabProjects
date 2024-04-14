package actionandlistener.dragandrop;

import javax.swing.*;

public class FrameDemoDragAndDropUsing extends JFrame {
	JFrame frame;
	DragPanel dragPanel = new DragPanel();
	public FrameDemoDragAndDropUsing() {
		frame = new JFrame();
		
		frame.add(dragPanel);
		frame.setTitle("Drag and Drop demo");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
