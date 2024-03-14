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
public class Animal_Group4 extends Animal {
     private boolean isDanger = true;

    public boolean isIsDanger() {
        return isDanger;
    }
    

    public Animal_Group4() {
    }

    public Animal_Group4(String id, int numofLeg, int weight, String color, boolean isPoisonous) {
        super(id, numofLeg, weight, color);
        this.isDanger = isPoisonous;  
    }
    
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.print(", Danger= " + this.isIsDanger()+ " }\n");
        
    }

    @Override
    public void update() {
        super.update();
        this.isDanger = Utils.inputBoolean("Danger (Yes --> 0 / No --> 1): ");
        
    }

    @Override
    public void input() {
        super.input(); 
        this.isDanger = Utils.inputBoolean("Danger (Yes --> 0 / No --> 1): ");
    }  
    
}
