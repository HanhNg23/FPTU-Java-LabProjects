import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class frame16 extends JFrame implements ActionListener{
	JComboBox comboBox;
	
	frame16(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		String[] animalanimals= {"dog", "cat" , "bird"};
		
	    comboBox = new JComboBox(animalanimals);
	    comboBox.addActionListener(this);
	    
	    //comboBox.setEditable(true); //edit option
	   //System.out.println(comboBox.getItemCount()); //output howmany options are given
		//comboBox.addItem("horse");
		//comboBox.insertItemAt("fish", 0);
		//comboBox.setSelectedIndex(2); //choose the item in index2 is pop up first
		//comboBox.setForeground(Color.GREEN);
		//comboBox.removeItem("cat");
		//comboBox.removeItemAt(0);
		comboBox.removeAllItems();
	    this.add(comboBox);
		this.pack();
		this.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox) {
			System.out.println(comboBox.getSelectedItem());
			System.out.println(comboBox.getSelectedIndex());
			if (comboBox.getSelectedItem().equals("cat")) {
				System.out.println("Found the Cat");
			}
		}
		
	}

}
