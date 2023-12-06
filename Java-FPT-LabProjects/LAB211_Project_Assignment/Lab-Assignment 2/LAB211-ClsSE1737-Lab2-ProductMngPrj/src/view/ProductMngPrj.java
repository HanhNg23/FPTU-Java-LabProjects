/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import data.ProductList;
import java.awt.Menu;
import menudta.MenuList;
import tools.MyTool;

/**
 *
 * @author HOANGANH
 */
public class ProductMngPrj {

    public static void main(String[] args) {
        String[] options = {
            "Print                               |",
            "Create a Product                    |",
            "Check exits Product                 |",
            "Search Product information by Name  |",
            "Update Product                      |\n|      - Update Product                   |\n|      - Remove Product                   |                      ",
            "Save Products to file               |",
            "Print list Products from the file   |",};
        int choice;
        boolean answer;
        ProductList dList = new ProductList();
        MenuList menu = new MenuList(options);
        dList.initFile();
        String Choice;
   
        do {
            boolean flag = true;
            choice = menu.getChoice("|-----------------------------------------|\n" + "|          Product Manangement            |" + "\n|-----------------------------------------|");

            System.out.println();
            switch (choice) {
                case 1:
                    dList.showcurList();
                    break;
                case 2:
                    do {
                        dList.create();
                        answer = MyTool.readBool("Continue ?");
                        System.out.println();
                    } while (answer);
                    System.out.println();
                    break;
                case 3:
                    do {
                        dList.exist();
                        answer = MyTool.readBool("Continue ?");
                        System.out.println();
                    } while (answer);
                    System.out.println();
                    break;
                case 4:
                    do {
                        dList.searchbyNameSubstr();
                        answer = MyTool.readBool("Continue ?");
                        System.out.println();
                    } while (answer);
                    System.out.println();
                    break;
                case 5:
                    do {
                        System.out.println("5.1- Update");
                        System.out.println("5.2- Remove");
                        System.out.println("5.3- Quit Update");
                        System.out.print("Choice: ");
                        Choice = MyTool.SC.nextLine().trim();
                        System.out.println();
                        switch (Choice) {
                            case "5.1":
                                dList.update();                                                              
                                break;
                            case "5.2":
                                do {
                                    dList.remove();
                                    answer = MyTool.readBool("Continue remove ?");
                                    System.out.println();
                                } while (answer);
                                System.out.println();
                                break;
                        }

                    }while(!Choice.equals("5.3"));
                    System.out.println();
                    break;
                case 6:
                    dList.writeProductToFile();
                    dList.initFile();
                    break;
                case 7:
                    dList.showfromFile();
                    break;
                default:
                    if (dList.isChanged()) {
                        boolean response = MyTool.readBool("Data changed. Write to file ? ");
                        if (response == true) {
                            dList.writeProductToFile();
                        }
                    }
                    System.out.println("((See you next time))");
            }
        } while (choice > 0 && choice <= menu.size());
    }

}
