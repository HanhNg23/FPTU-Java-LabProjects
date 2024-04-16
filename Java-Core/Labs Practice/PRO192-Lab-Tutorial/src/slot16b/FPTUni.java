/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot16b;

import slot16.*;

/**
 *
 * @author HOANGANH
 */
public class FPTUni implements BoGiaoDuc {
    private String name;

    public FPTUni() {
        this.setName("BKUni");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void teachBasic() {
       System.out.println("teach Basic: C/ Java");
        
    }

    @Override
    public void teachAdvance() {
       System.out.println("teach Advance: CDS/WEB");
       

    }
    

    @Override
    public void teachSpecial() {
        System.out.println("teach Advance: Cloud computing");
    }

    @Override
    public void show() {
        System.out.println("This is FPT Uni");
        this.teachBasic();
        this.teachAdvance();
        this.teachSpecial();
    }
    
}
