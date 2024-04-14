package combobox;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FrameDemoComboBoxUsing extends JFrame implements ActionListener{
	JComboBox comboBox;
	JLabel label;
	FrameDemoComboBoxUsing(){
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		String[] animalanimals= {"dog", "cat" , "bird"};
		
		label = new JLabel();
		label.setText("Select from combo box ");
		label.setFont(new Font("MV Boli", Font.PLAIN, 15 ));
		label.setForeground(Color.white);
		label.setBackground(Color.BLACK);
		label.setOpaque(true);
		label.setVisible(true);
		
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
	    this.add(comboBox);
	    this.add(label);
		this.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox) {
			
			System.out.println(comboBox.getSelectedItem());
			System.out.println(comboBox.getSelectedIndex());
			label.setText(comboBox.getSelectedItem() + " is selected !");
			label.setVisible(true);
		}
		
	}

}
