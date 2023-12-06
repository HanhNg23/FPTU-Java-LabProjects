/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myzoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import utils.Utils;
import java.util.Vector; //list the items

/**
 *
 * @author HOANGANH
 */
public class Animal extends Vector <Animal> { 

    private String name;
    private int inGroup;
    private String color;
    private String weight;
    private String specialFeatures;
    private String actions;
  
    
    public int getinGroup() {
        return inGroup;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public String getActions() {
        return actions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setinGroup(int inGroup) {
        this.inGroup = inGroup;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public void setAnimalList(Animal[] animalList) {
        this.animalList = animalList;
    }

    public void setNumofAnimal(int numofAnimal) {
        this.numofAnimal = numofAnimal;
    }
    
    

    public void inputAnimal() {
        name = Utils.inputString("Anima's name: ").trim().toUpperCase();
        color = Utils.inputString("Color: ").toLowerCase();
        weight = Utils.inputString("Weight: ");
        specialFeatures = Utils.inputString("Special feutures: ").toLowerCase();
        actions = Utils.inputString("Actions " + name + " can do: ").toLowerCase();

    }

    public void updateAnimal() {
        name = Utils.updateString("Anima's name: ", name);
        color = Utils.updateString("Color: ", color);
        weight = Utils.updateString("Weight: ", weight);
        specialFeatures = Utils.updateString("Special feutures: ", specialFeatures);
        actions = Utils.updateString("Actions " + this.getName() + " can do: ", actions);

    }

    public void showAnimal() {
        System.out.print("Color= " + color + ", Weight= " + weight + ", Special Features= " + specialFeatures + ", Actions= " + actions);

    }

    //####################################################################################################################################################//
    /*Create method add, update, display, remove, search*/
    Animal[] animalList;
    int numofAnimal;
    final int MAX = 1000;

    public Animal() {
        animalList = new Animal[1000];
        numofAnimal = 0;
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null || numofAnimal >= MAX) {
            return false;
        } else {
            animalList[numofAnimal] = animal;
            System.out.print("Id " + numofAnimal + ". "); animal.showAnimal();
            numofAnimal++;
            return true;
        }

    }

    public void displayAnimalAll() {
        if(numofAnimal == 0) System.out.println("There are not any animals in the list");
        for (int i = 0; i < numofAnimal; i++) {
            System.out.print("Id " + i + ". ");
            animalList[i].showAnimal(); //when access animal in index i, it will use showAnimal in subclass because 
            //it has been allocated memory which belong to subclass.
        }
    }

    public void displayAnimalByGroup(int chooseGroup) {
        //int chooseGroup = Utils.inputInt("Which group of animals you want to show", 4, 1);
        switch (chooseGroup) {
            case 1:
                System.out.println("|===Information of animal in Group 1===|\n");
                for (int i = 0; i < numofAnimal; i++) {
                    if (animalList[i] instanceof AnimalGroup1) { //instanceof check whether the object is the instance or interface of a specific class 
                        System.out.print("Id " + i + ". ");
                        animalList[i].showAnimal();
                        //System.out.println(animalList[i]); this will print the address -> should not use
                    }
                }
                break;
            case 2:
                System.out.println("|===Information of animal in Group 2===|\n");
                for (int i = 0; i < numofAnimal; i++) {
                    if (animalList[i] instanceof AnimalGroup2) {
                        System.out.print("Id " + i + ". ");
                        animalList[i].showAnimal();                        
                    }
                }
                break;
            case 3:
                System.out.println("|===Information of animal in Group 3===|\n");
                for (int i = 0; i < numofAnimal; i++) {
                    if (animalList[i] instanceof AnimalGroup3) {
                        System.out.print("Id " + i + ". ");
                        animalList[i].showAnimal();
                    }
                }
                break;
            case 4:
                System.out.println("|===Information of animal in Group 4===|\n");
                for (int i = 0; i < numofAnimal; i++) {
                    if (animalList[i] instanceof AnimalGroup4) {
                        System.out.print("Id " + i + ". ");
                        animalList[i].showAnimal();
                    }
                }
                break;
        }
    }

    public Animal searchByName(String nametosearch) {
        //String name = Utils.inputString("Enter the name of animal to search: ");
        for (int i = 0; i < numofAnimal; i++) {
            if (animalList[i].getName().equals(nametosearch)) {
                return animalList[i];
            }
        }
        return null;
    }

    public Animal searchByIndex(int index) {
        //int index = Utils.inputInt("Enter the index's animal: ", MAX, 0);
        for (int i = 0; i < numofAnimal; i++) {
            if (i == index) {
                return animalList[i];
                //or animalList[i].showAnimal();
            }
        }
        return null;
    }

    public boolean deleteAnimalByIndex(int index) {
        if (index >= 0 && index < numofAnimal) {
            for (int i = index; i < numofAnimal; i++) {
                animalList[i] = animalList[i + 1];
            }
            numofAnimal--;
            return true;
        }
        return false;
    }

    public boolean updateByIndex(int index) {
        //remember the index to update in range from 0 to numofAnimal
        if (index >= 0 && index < numofAnimal) {
            animalList[index].updateAnimal();
            System.out.println("After update: ");
            animalList[index].showAnimal();
            return true;            
        }
        return false;
    }
    
    /*####################################################################################*/
    //Create method savet to file, load data from file
    public void saveToFile(String fileName) {
        //because size() method belong to class Vector which is inhereted by class Animal
        //I find 2 ways to access methods of both class parent and class child 
        //Best way: using "this.(method)"  
        //2nd way (slower way): create child class object -> Animal ani = new Animal(); then ani.(method)
        
        if (numofAnimal == 0) { //size() return number of elements in the list type Animal object
            System.out.println("\u001b[35mEmpty list");
        }
        try {//open text file for writing chars
            File f = new File(fileName); // used to perform various operations on files and directories.
            FileWriter fw = new FileWriter(f); //println()
            PrintWriter pw = new PrintWriter(fw);
            //writting products to file
            for (int i = 0; i < numofAnimal; i++) {
                pw.print(animalList[i].name + "-");
                pw.print(Integer.toString(animalList[i].getinGroup()) + "-");
                pw.print(animalList[i].color + "-");
                pw.print(animalList[i].weight + "-");
                pw.print(animalList[i].specialFeatures + "-");
                pw.print(animalList[i].actions);
                pw.println();
                
            }
            //all products are stored in file
            pw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    public void loadDatafromfile(String filename) throws FileNotFoundException, IOException {
//        File f = new File(filename); //checking existence of the file
//        if (!f.exists()) {
//            return;
//        }
//        FileReader fr = new FileReader(f);
//        BufferedReader bf = new BufferedReader(fr);//Rread data (in characters) more efficiently.The BufferedReader maintains an internal buffer of 8192 characters.
//        String line;
//        while ((line = bf.readLine()) != null) {
//            StringTokenizer stk = new StringTokenizer(line, " - ");
//            name = stk.nextToken();
//            inGroup = Integer.parseInt(stk.nextToken());
//            color = stk.nextToken();
//            weight = stk.nextToken();
//            specialFeatures = stk.nextToken();
//            actions = stk.nextToken();
//        }
//    }
}
   

