package slot3;

import utils.Utils;
import java.util.Scanner;

public class Array_Processing {
    
    
    private int length;
    private int[] intArray;  
    
//    public static void main(String[] args){
//        
//         Array_Processing array = new Array_Processing();
//        array.inputLen();
//        array.inputElement();
//        array.display();
//        int smallest = array.findSmallest();
//        System.out.println("");
//        System.out.println("The smallest number: "+smallest);
//        float average = array.findAvg();
//        System.out.println("The average: "+average); 
//    }
    
    public int inputLen(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the length of array:  ");
        System.out.println("Input a from [1 10]:  ");
        Utils u = new Utils();
        u.inputIntNumber(1, 10);
        length = Integer.parseInt(scan.nextLine());
        return length;          
    }
    
    public void inputElement(){
        Scanner scan = new Scanner(System.in);
        intArray = new int[length];
        System.out.println("Input array element  ");
      
        for(int i = 0; i < length; i++){
            System.out.print("Index "+i+":  ");
            intArray[i] = Integer.parseInt(scan.nextLine());
            //System.out.println();
        }
    }
    
    public void display(){
        System.out.print("Array information");
        for(int i : intArray){
            System.out.print("  "+i);
        }
    }
    
    public int findSmallest(){
        int smallest = intArray[0];
        for(int i : intArray){
            if(smallest > i) smallest = i;
        }
        return smallest;
    }
         
    public float findAvg(){
        float avg = 0;
        for(int i : intArray){
            avg+=i;
        }
        return avg/length;
    }
}
    
    

