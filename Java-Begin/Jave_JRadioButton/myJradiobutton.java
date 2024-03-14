import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class myJradiobutton extends JFrame implements ActionListener {
	JRadioButton pizzaButton;
	JRadioButton pizzaHutButton ;
	JRadioButton pizzaSaladButton;
	
	
	
	myJradiobutton(){
		
		ImageIcon food1 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\JRadioButton\\icons8-pizza-48.png") ;
		ImageIcon food2 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\JRadioButton\\icons8-flour-48.png");
		ImageIcon food3 = new ImageIcon("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\JRadioButton\\icons8-pizza-48 (1).png");
		
		
		//the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		 pizzaButton = new JRadioButton("pizza Default");
		 pizzaHutButton = new JRadioButton("pizza Hut");
		 pizzaSaladButton = new JRadioButton("pizza Salad");
		 
		 
//		 pizzaButton.setBackground(Color.BLUE);
//		 pizzaHutButton.setBackground(Color.BLUE);
//		 pizzaSaladButton.setBackground(Color.BLUE);
//		 
		 pizzaButton.addActionListener(this);
		 pizzaHutButton.addActionListener(this);
		 pizzaSaladButton.addActionListener(this);
		 
		 pizzaButton.setIcon(food1);
		 pizzaHutButton.setIcon(food2);
		 pizzaSaladButton.setIcon(food3);
		
		 
		 //Create ButtonGroup to choose only one option
		 ButtonGroup group = new ButtonGroup();
		 group.add(pizzaButton);
		 group.add(pizzaHutButton);
		 group.add(pizzaSaladButton);
			
		
		this.add(pizzaButton);
		this.add(pizzaHutButton);
		this.add(pizzaSaladButton);
		this.pack();
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pizzaButton) {
			System.out.println("You order Pizza");			
		}else if(e.getSource() == pizzaHutButton) {
			System.out.println("You order Pizza Hut");
		}else System.out.println("You order Pizza Salad");
		
	}

}
