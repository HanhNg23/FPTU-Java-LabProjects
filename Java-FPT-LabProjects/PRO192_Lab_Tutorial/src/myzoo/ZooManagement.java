/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myzoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import utils.Utils;
//import utils.JTextcolor;

/**
 *
 * @author HOANGANH
 */
public class ZooManagement {

    public static void main(String[] args) throws IOException {
        ZooManagement zoo = new ZooManagement();
        boolean flag = true;
        Animal obj = new Animal();
        int choose;

//########################################################################################################################################################################        
        //load data from file
        File f = new File("C:\\Users\\HOANGANH\\Documents\\NetBeansProjects\\PRO192-HoaDNT\\src\\myzoo\\AnimalList.txt"); //checking existence of the file
        if (!f.exists()) {
            return;
        }
        System.out.println(f.length());
        if (f.length() != 0) {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);//Rread data (in characters) more efficiently.The BufferedReader maintains an internal buffer of 8192 characters.
            String line;
            while ((line = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, "-");
                String name = stk.nextToken();
                int inGroup = Integer.parseInt(stk.nextToken());
                String color = stk.nextToken();
                String weight = stk.nextToken();
                String specialFeatures = stk.nextToken();
                String actions = stk.nextToken();

                switch (inGroup) {
                    case 1:
                        Animal animal1 = new AnimalGroup1(name, inGroup, color, weight, specialFeatures, actions);
                        obj.addAnimal(animal1);
                        break;
                    case 2:
                        Animal animal2 = new AnimalGroup2(name, inGroup, color, weight, specialFeatures, actions);
                        obj.addAnimal(animal2);
                        break;
                    case 3:
                        Animal animal3 = new AnimalGroup3(name, inGroup, color, weight, specialFeatures, actions);
                        obj.addAnimal(animal3);
                        break;
                    case 4:
                        Animal animal4 = new AnimalGroup4(name, inGroup, color, weight, specialFeatures, actions);
                        obj.addAnimal(animal4);
                        break;
                }
            }
        }

//########################################################################################################################################################################
        do {
            zoo.ZooMenu();
            choose = Utils.inputInt("\u001B[32mYour choose ", 9, 1);
            System.out.println();
            System.out.println("\u000c");
            switch (choose) {
                case 1: //Add new animal
                    boolean flag1 = true;
                    do {
                        System.out.println("   \033[36mPress 1 => Group 1: no leg");
                        System.out.println("   \u001B[36mPress 2 => Group 2: 2 legs and 2 swings but can not fly");
                        System.out.println("   \u001B[36mPress 3 => Group 3: 2 legs and 2 swings but can fly");
                        System.out.println("   \u001B[36mPress 4 => Group 4: 4 legs");
                        int groupchoice = Utils.inputInt("\u001B[32mWhat is group the new animal belong to ? ", 4, 1);
                        switch (groupchoice) {
                            case 1:
                                Animal animal1 = new AnimalGroup1();
                                animal1.inputAnimal();
                                if (obj.addAnimal(animal1)) {
                                    System.out.println("\u001B[34mThe new animal has added sucessfully :-)");
                                } else {
                                    System.out.println("\u001B[34mThe new animal does not added sucessfully :-(");
                                }
                                break;
                            case 2:
                                Animal animal2 = new AnimalGroup2();
                                animal2.inputAnimal();
                                if (obj.addAnimal(animal2)) {
                                    System.out.println("\u001B[34mThe new animal has added sucessfully :-)");
                                } else {
                                    System.out.println("\u001B[34mThe new animal does not added sucessfully :-(");
                                }
                                break;
                            case 3:
                                Animal animal3 = new AnimalGroup3();
                                animal3.inputAnimal();
                                if (obj.addAnimal(animal3)) {
                                    System.out.println("\u001B[34mThe new animal has added sucessfully :-)");
                                } else {
                                    System.out.println("\u001B[34mThe new animal does not added sucessfully :-(");
                                }
                                break;
                            case 4:
                                Animal animal4 = new AnimalGroup4();
                                animal4.inputAnimal();
                                if (obj.addAnimal(animal4)) {
                                    System.out.println("\u001B[34mThe new animal has added sucessfully :-)");
                                } else {
                                    System.out.println("\u001B[34mThe new animal does not added sucessfully :-(");
                                }
                                break;
                        }

                        boolean answer = Utils.answerYesNo("Continue to add new animal ? ");
                        if (answer == true) {
                            flag1 = true;
                        } else {
                            flag1 = false;
                        }
                    } while (flag1);
                    break;
                case 2: //Update animal
                    int chooseIndextoUp = Utils.inputIntNumber("\u001B[32mChoose an animal's index to update: ");
                    if (obj.updateByIndex(chooseIndextoUp)) {
                        System.out.println("\u001B[34mUpdate sucessfully :-)");
                    } else {
                        System.out.println("\u001B[34mThe animal at index " + chooseIndextoUp + " is not updated sucessfully :-(");
                    }
                    break;
                case 3://Delete animal
                    int chooseIndextoDel = Utils.inputIntNumber("\u001B[32mChoose an animal's index to delete: ");
                    if (obj.deleteAnimalByIndex(chooseIndextoDel)) {
                        System.out.println("\u001B[34mDeleted sucessfully :-)");
                    } else {
                        System.out.println("\u001B[34mThe animal at index " + chooseIndextoDel + " is not deleted sucessfully :-(");
                    }
                    break;
                case 4://Search animal by index
                    int chooseIndextoSer = Utils.inputIntNumber("\u001B[32mEnter an animal's index to search: ");
                    Animal result1 = obj.searchByIndex(chooseIndextoSer);
                    if (result1 == null) {
                        System.out.println("\u001B[34mNot found :-(");
                    } else {
                        System.out.println("\u001B[34mHas found your animal :-) at index " + chooseIndextoSer);
                        result1.showAnimal();
                    }
                    break;
                case 5://Search animal by name
                    String nametoSearch = Utils.inputString("\u001B[32mEnter the name of animal to search: ").trim();
                    Animal result2 = obj.searchByName(nametoSearch);
                    if (result2 == null) {
                        System.out.println("\u001B[34mNot found :-(");
                    } else {
                        System.out.println("\u001B[34mHas found your animal :-) named " + nametoSearch);
                        result2.showAnimal();
                    }
                    break;
                case 6://Show animals' information by group
                    int chooseGrouptoshow = Utils.inputInt("\u001B[32mWhich group of animals you want to show up", 4, 1);
                    obj.displayAnimalByGroup(chooseGrouptoshow);
                    break;
                case 7://Show all animals' information
                    obj.displayAnimalAll();
                    break;
                case 8:
                    obj.saveToFile("C:\\Users\\HOANGANH\\Documents\\NetBeansProjects\\PRO192-HoaDNT\\src\\myzoo\\AnimalList.txt");
                    break;
                case 9:
                    flag = false;
                    System.out.println("*-----^_^ Goodbye and see you soon next time ^_^-----*");
                    break;
            }
        } while (flag);

    }

    public void ZooMenu() {
//        System.out.println("\n\u001B[92m*-----Welcome To Zoo Management-----*\n");
//
//        System.out.println("\u001B[45m1. Add new animal");
//        System.out.println("\u001B[45m2. Update animal");
//        System.out.println("\u001B[45m3. Delete animal");
//        System.out.println("\u001B[45m4. Search animal by index");
//        System.out.println("\u001B[45m5. Search animal by name");
//        System.out.println("\u001B[45m6. Show animals information by group");
//        System.out.println("\u001B[45m7. Show all animals information");
//        System.out.println("\u001B[45m8. Quit");
        System.out.println("\n\n");
        System.out.println(
                "                 \u001B[32m█                                    █              \n"
                + "                   \u001B[32m█                                █                \n"
                + "                     \u001B[32m█                            █                  \n"
                + "                       \u001B[32m█                        █                    \n"
                + "                        \u001B[32m ███████████████                   \n"
                + "                       \u001B[32m██▒▒▒▒▒▒▒▒▒▒▒▒▒██                   \n"
                + "    \u001B[33m████████████████████████████████████████████\n"
                + "    \u001B[36m██▒▒▒▒▒▒▒▒▒▒  \u001B[45m \u001B[4;33mWelcome To Zoo Management\u001B[40m\u001B[36m  ▒▒▒▒▒▒▒▒▒▒██\n"
                + "    \u001B[33m██▒▒▒▒▒▒▒▒▒▒        \u001B[33m^.^^.^^.^^.^^.^\u001B[33m       ▒▒▒▒▒▒▒▒▒▒██\n"
                + "    \u001B[36m██▒▒▒▒████████████████████████████▒▒████████    \n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m1. Add new animal               \u001B[32m        █▒▒██░░\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m2. Update animal                \u001B[32m        █▒▒▓▓██\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m3. Delete animal                \u001B[32m        █▒▒▓▓▒▒\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m4. Search animal by index       \u001B[32m        █▒▒████\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m5. Search animal by name        \u001B[32m        █▒▒██░░\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m6. Show animals list by group   \u001B[32m        █▒▒████\n"
                + "    \u001B[32m██▓▓▒▒█     \u001B[35m7. Show all animals list        \u001B[32m        █▒▒▒▒▒▒\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m8. Save change                  \u001B[32m        █▒▒▓▓▒▒\n"
                + "    \u001B[32m██▒▒▒▒█     \u001B[35m9. Quit                         \u001B[32m        █▒▒▓▓▒▒\n"
                + "    \u001B[33m██▓▓▒▒███████████████████████████████▒▒▒▒▒▒▒    \n"
                + "    \u001B[36m██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒    \n"
                + "    \u001B[33m██▒▒▒▒▒▒▒▒▒                                 ▒▒▒▒▓▓▒▒▒▒▓     \n"
                + "    \u001B[36m██▒▒▒▒▒▒▒▒                                    ▒▒▒▒▒▒▒▒▒▒     \n"
                + "    ");

    }

}
