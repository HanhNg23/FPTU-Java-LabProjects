/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myzoo;

/**
 *
 * @author HOANGANH
 */
public class AnimalGroup4 extends Animal {
    final private int numofLegs = 4;
    final private int inGroup = 4;

    public AnimalGroup4() {
    }
    
    public AnimalGroup4(String name, int inGroup, String color, String weight, String specialFeatures, String actions){
        super.setName(name);
        super.setinGroup(inGroup);
        super.setColor(color);
        super.setWeight(weight);
        super.setSpecialFeatures(specialFeatures);
        super.setActions(actions);
        
    }

    public int getNumofLegs() {
        return numofLegs;
    }

    @Override
    public int getinGroup() {
        return inGroup; 
    }
    
    @Override
    public void inputAnimal() {
        super.inputAnimal();
    }

    @Override
    public void updateAnimal() {
        super.updateAnimal();
    }

    @Override
    public void showAnimal() {
        System.out.print("Name= " + super.getName() + ", In group= " + inGroup + ", " + numofLegs + " legs, " );
        super.showAnimal();
        System.out.println("");

    }

}
