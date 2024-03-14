import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class joption_pane {

	public static void main(String[] args) {
		// JOptionPane = pop up a standard dialog box that prompts users for a value
		//               or inform them of something
//		JOptionPane.showMessageDialog(null, "This is some useless info","Title", JOptionPane.PLAIN_MESSAGE);
//		JOptionPane.showMessageDialog(null, "This is some useless info","Title", JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane.showMessageDialog(null, "This is some useless info","Title", JOptionPane.QUESTION_MESSAGE);
//	while(true) {
//    	JOptionPane.showMessageDialog(null, "That is virus","Title", JOptionPane.WARNING_MESSAGE);
//	}
//		JOptionPane.showMessageDialog(null, "This is some useless info","Title", JOptionPane.ERROR_MESSAGE);
/*-----------------------------------------------------------------------------------------------------------------------*/	
	//	JOptionPane.showConfirmDialog(null, "Bro, do you even code", "this is my title",JOptionPane.YES_NO_CANCEL_OPTION);
	//	System.out.println(JOptionPane.showConfirmDialog(null, "Bro, do you even code", "this is my title",JOptionPane.YES_NO_CANCEL_OPTION)); //0: yes; 1 : no; 2 : cancel
	//	JOptionPane.showConfirmDialog(null, "Bro, do you even code", "this is my title",JOptionPane.OK_OPTION);
	//	JOptionPane.showConfirmDialog(null, "Bro, do you even code", "this is my title",JOptionPane.YES_NO_OPTION);
	
	//	String name = JOptionPane.showInputDialog("What is your name ?: ");
	    String[] responses = {"No, you're awesome", "Thank you", "Oh my God !"};
		ImageIcon image4 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java_JOptionPane\\convoi.png");
	    JOptionPane.showOptionDialog(null, "You are good!", "secret message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, image4, responses, null);
		
	    
	
	}

}
