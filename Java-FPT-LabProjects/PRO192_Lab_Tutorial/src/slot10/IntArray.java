
package slot10;
import utils.Utils;


public class IntArray {
    private int[] array ;
    private final int len; 
    

    public int[] getArray() {
        return array;
    }
 
    public void setArray(int[] array){
      this.array = array;
    }
     
    
    public IntArray(){
        this.len = Utils.inputIntNumber("Nhap kich thuoc cho mang: ");
        this.array = new int[this.len];
    }
    
    public void inputElement(){
        for(int i = 0; i < this.len ; i++){
            array[i] = Utils.inputIntNumber("Input the value at index "+ i + ": ");
            
        }
    }
    public void dislayArray(){
        for(int i =0; i < this.len; i++){
            System.out.print(array[i] + " ");
        }
    }
    
    public void sortArray(){
        int temp;
      
        for(int i = 0; i < this.len-1 ; i++){
            for(int j = i+1; j < this.len; j++){
                if( array[i] > array[j]){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                }
            }
        }
    }
    
    public void searchArray(){
        int wannanumber;
        int check = 0;
        wannanumber = Utils.inputIntNumber("What number you want to find the position: ");
        for(int i = 0; i < this.len; i++){
            if(wannanumber == array[i]){
                System.out.println("Your number is at index: "+i);
                check = 1;
                break;
            }
        }
        if(check == 0){
                System.out.println("Sorry, your number is not in array !");
            }
    }
    
    
    public static void main(String[] args){
        IntArray myarray = new IntArray();
        myarray.inputElement();
        System.out.println("DISPLAY ARRAY");
        myarray.dislayArray();
        System.out.println("\nSORT ARRAY");
        myarray.sortArray();
        myarray.searchArray();
        
       
    }
            
}

