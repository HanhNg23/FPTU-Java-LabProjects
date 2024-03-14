/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo_mangement;

import slot10.IntArray;
import utils.Utils;

/**
 *
 * @author HOANGANH
 */
public class ZooManagement {

    public static void main(String[] args) {
        int choose;
        Animal[] animalarray = new Animal[5000]; //mảng kiểu animal mỗi phần tử là object có kiểu dữ liệu Animal
        int realSize = 0;
        boolean flag = true;

        do {
            Utils.chooseZooMenu();
            choose = Utils.inputInt("Which one you choose ", 7, 1);

            switch (choose) {
                case 1: // Input Group 1
                    animalarray[realSize] = new Animal_Group1();
                    animalarray[realSize].input();
                    realSize++;
                    break;
                case 2:
                    animalarray[realSize] = new Animal_Group4();
                    animalarray[realSize].input();
                    realSize++;
                    break;
                case 3:
                    System.out.println("Update Animal Group 1");
                    int idUpdate1 = Utils.inputInt("Id Of Animal To Update", 5000, 0);
                    for (int i = 0; i < realSize; i++) {
                        if (animalarray[i].getId().equals(idUpdate1)) {
                            animalarray[i].update();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Update Animal Group 4");
                    int idUpdate4 = Utils.inputInt("Id Of Animal To Update", 5000, 0);
                    for (int i = 0; i < realSize; i++) { //hoac for(Animal animal : animalarray){ }
                        if (animalarray[i].getId().equals(idUpdate4)) {
                            animalarray[i].update();
                        }
                    }
                    break;
                case 5: // delete
                    System.out.println("Delete An Animal");
                    int idDelete = Utils.inputInt("Id Of Animal To Delete", 5000, 0);
                    for (int i = 0; i < realSize; i++) {
                        if (animalarray[i].getId().equals(Integer.toString(idDelete))) {
                            animalarray[idDelete] = animalarray[realSize-1];
                            realSize--;
                        }
                    }
                    break;

                case 6: //Show
                    System.out.println("Show List Of Animal Information");
                    for (int i = 0; i < realSize; i++) {
                        animalarray[i].showInfor();
                    }
                    break;
                case 7:
                    flag = false;
                    break;
//                default:
//                    System.out.println("Choose from 1 to 5");
            }
        } while (flag);
    }
    

}
