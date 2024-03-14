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
public class Animal {
    private String id;
    private int numofLeg;
    private int weight;
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumofLeg() {
        return numofLeg;
    }

    public void setNumofLeg(int numofLeg) {
        this.numofLeg = numofLeg;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    public Animal(){
    
}

    public Animal(String id, int numofLeg, int weight, String color) {
        this.id = id;
        this.numofLeg = numofLeg;
        this.weight = weight;
        this.color = color;
    }
    
    public void input(){
        id = Utils.inputString("Input Id: ");
        numofLeg = Utils.inputInt("Number of animal leg: ",10,0);
        weight = Utils.inputInt("Weight: ",500,0);
        color = Utils.inputString("Color: ");
     }
    
    public void update(){
        id = Utils.updateString("Input Id: ", id);
        numofLeg = Utils.updateInt("Number of animal leg: ",10,0, numofLeg);
        weight = Utils.updateInt("Weight: ",500,0,weight);
        color = Utils.updateString("Color: ", color);
    }
    
    public void showInfor(){
        System.out.print("{ " + "id= " + id + ", numofLeg= " + numofLeg + ", weight= " + weight + ", color= " + color);
    }

    
}
