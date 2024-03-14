import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Jfile_demo extends JFrame implements ActionListener {
    JFrame frame; 
    JButton button;
  
	Jfile_demo(){
		frame = new JFrame();
		button = new JButton("Select File");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		button.addActionListener(this);
		
		
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
    	 
	
   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {

			JFileChooser fileChooser = new JFileChooser();

	//fileChooser.setCurrentDirectory(new File(".")); //it will return the current path
    fileChooser.setCurrentDirectory(new File("C:/Users/HOANGANH/Desktop"));


			  //int response = fileChooser.showOpenDialog(null); //select file to open
			  int response = fileChooser.showSaveDialog(null);// save file 

			  if(response == JFileChooser.APPROVE_OPTION){
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);

			  } 

			
		}
		
	}
	

}
