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
public class BKUni implements BoGiaoDuc {
private String name;

    public BKUni() {
        this.setName("BK Uni");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public void show() {
        System.out.println("This is Bk Uni");
        this.teachBasic();
        this.teachAdvance();
        this.teachSpecial();
    }
    
}
