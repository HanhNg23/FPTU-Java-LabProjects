/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo_mangement;

import utils.Utils;

/**
 *
 * @author HOANGANH
 */
public class Animal_Group1 extends Animal { //group 1 animal no leg
    private boolean isPoisonous = true;

    public boolean isIsPoisonous() {
        return isPoisonous;
    }
    

    public Animal_Group1() {
    }

    public Animal_Group1(String id, int numofLeg, int weight, String color, boolean isPoisonous) {
        super(id, numofLeg, weight, color);
        this.isPoisonous = isPoisonous;  
    }
    
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.print(", Poisonous= " + this.isIsPoisonous() + " }\n");
        
    }

    @Override
    public void update() {
        super.update();
        this.isPoisonous = Utils.inputBoolean("Poisonous (Yes --> 0 / No --> 1): ");
        
    }

    @Override
    public void input() {
        super.input(); 
        this.isPoisonous = Utils.inputBoolean("Poisonous (Yes --> 0 / No --> 1): ");
    }  
}
