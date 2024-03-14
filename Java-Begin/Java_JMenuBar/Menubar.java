import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class menu_bar  extends JFrame implements ActionListener{
	
	JFrame frame;
	JMenuBar menuBar ;
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem saveItem;
	JMenuItem existItem;
	ImageIcon loadI;
	ImageIcon saveI;
	ImageIcon existI;
	
	
	menu_bar(){
		frame = new JFrame();
		menuBar = new JMenuBar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new FlowLayout());
		menuBar.setBackground(Color.black);
		
	
	
		//create Parents MENU
		 fileMenu = new JMenu("File");
		 editMenu = new JMenu("Edit");
		 helpMenu = new JMenu("Help");
	
		//change menu color
		fileMenu.setForeground(Color.green);
		editMenu.setForeground(Color.green);
		helpMenu.setForeground(Color.green);
		
		//Create Children for MENU fileMenu
		 loadItem = new JMenuItem("Load");
		 saveItem = new JMenuItem("Save");
		 existItem = new JMenuItem("Exist");
		
		//add Children for fileMenu
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(existItem);
	
		//Add main menu to menubar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		//short keyEvent
		fileMenu.setMnemonic(KeyEvent.VK_F);//Alt + f for file
		editMenu.setMnemonic(KeyEvent.VK_E);//Alt + e
		helpMenu.setMnemonic(KeyEvent.VK_H);//Alt + h		
		loadItem.setMnemonic(KeyEvent.VK_L);//PRESS l
		saveItem.setMnemonic(KeyEvent.VK_S);
		existItem.setMnemonic(KeyEvent.VK_E);
		
		//add Icon
		//loadI = new ImageIcon("icons8-flour-48.png");
		loadI = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\JRadioButton\\icons8-flour-48.png");
		saveI = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\JRadioButton\\icons8-pizza-48.png");
		existI = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\JRadioButton\\icons8-pizza-48 (1).png");
		
		loadItem.setIcon(loadI);
		saveItem.setIcon(saveI);
		existItem.setIcon(existI);
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		existItem.addActionListener(this);
		
		
	
		frame.add(menuBar);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loadItem) {
			System.out.println("**beep boop* you loaded a file");
		}
		if(e.getSource() == saveItem) {
			System.out.println("**beep boop* you saved a file");
		}
		if(e.getSource() == existItem) {
			System.out.println("**beep boop* BYEBYE");
		}
		
	}
}



public class Menubar {

	public static void main(String[] args) {
		new menu_bar();

	}

}
