import java.awt.*;
import javax.swing.*;

public class frame_twoD_animation  extends JFrame{
	 panel_twoD_animation thepanel;
	
	public frame_twoD_animation(){
		thepanel = new panel_twoD_animation();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(thepanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}	
}