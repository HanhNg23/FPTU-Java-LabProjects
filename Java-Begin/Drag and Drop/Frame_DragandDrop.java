import javax.swing.*;

public class Frame_DragandDrop extends JFrame {
	JFrame frame;
	DragPanel dragPanel = new DragPanel();
	public Frame_DragandDrop() {
		frame = new JFrame();
		
		frame.add(dragPanel);
		frame.setTitle("Drag and Drop demo");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
