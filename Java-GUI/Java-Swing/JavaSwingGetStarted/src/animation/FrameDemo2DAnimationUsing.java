package animation;
import java.awt.*;
import javax.swing.*;

public class FrameDemo2DAnimationUsing  extends JFrame{
	 Panel2DAnimation thepanel;
	
	public FrameDemo2DAnimationUsing(){
		thepanel = new Panel2DAnimation();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(thepanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}	
}