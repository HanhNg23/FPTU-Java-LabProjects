package slot3;


//import slot3.Array_Processing;


public class main {
    public static void main(String[] args){
        Array_Processing array = new Array_Processing();
        array.inputLen();
        array.inputElement();
        array.display();
        int smallest = array.findSmallest();
        System.out.println("");
        System.out.println("The smallest number: "+smallest);
        float average = array.findAvg();
        System.out.println("The average: "+average);
        
        
    }
    
}
