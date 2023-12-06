
package slot16;

public class BKUni extends BoGiaoDuc {

    public BKUni() {
        this.setName("BKU Uni");
        
    }

    
    @Override
    public void teachBasic() {
       System.out.println("teach Basic: Prolog");
        
    }

    @Override
    public void teachAdvance() {
       System.out.println("teach Advance: C++");
      
   }
    

    @Override
    public void teachSpecial() {
        System.out.println("teach Advance: AI");
    }
    
   
    
}
