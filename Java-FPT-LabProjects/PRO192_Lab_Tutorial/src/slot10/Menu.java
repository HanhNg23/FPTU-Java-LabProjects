/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot10;
import utils.Utils;

/**
 *
 * @author HOANGANH
 */
public class Menu {
    public static void main(String[] args){
        int choose;
        IntArray intarray = new IntArray();
        boolean flag = true;
        
      do{
          
        Utils.chooseArrayMenu();
        choose = Utils.inputInt("Which one you choose ", 5, 1);

        switch(choose){
            case 1:
                intarray.inputElement();
                System.out.print("Your array: ");
                intarray.dislayArray();
                System.out.println();
                break;
            case 2:
                System.out.print("Your array: ");
                intarray.dislayArray();
                System.out.println();
                break;
            case 3:
                intarray.sortArray();
                System.out.print("The array after sorting: ");
                intarray.dislayArray();
                System.out.println();
                break;
            case 4:
                intarray.searchArray();
                break;
            case 5:
                flag = false;
                break;
            default:
                System.out.println("Choose from 1 to 5");
           }
        }while(flag);   
    }  
}
