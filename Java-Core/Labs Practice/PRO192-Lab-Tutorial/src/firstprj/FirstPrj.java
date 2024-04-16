/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package firstprj;
import java.util.*;
import java.awt.*;
import javax.swing.JTextField;
import utils.Utils;

/**
 *
 * @author HOANGANH
 */
public class FirstPrj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//mssv full name nhap 2 so coong lai hien thi ket qua
        
         Scanner scan = new Scanner(System.in);       
         System.out.print("Student name: ");
         String name = scan.nextLine();
         System.out.print("Student id: ");
         int id = scan.nextInt();
         System.out.print("Input 2 integer number\n");
         System.out.print("number1: "); int num1 = scan.nextInt();
         System.out.print("number2: "); int num2 = scan.nextInt();
         System.out.println("Name " +name+ "- Mssv: " +id+ "\nPlus 2 numbers: " +(num1 + num2));
         
         

//        int length = 10;
//        int[] intArray = new int[length];
//        for (int i = 0; i < length ; i++){
//            System.out.print("value index " +i + "=");
//            intArray[i] = scan.nextInt();   
//        }
        
        
        
        
    }
    
}
