package sample.view;

import sample.dto.IList;
import sample.dto.IMenu;
import sample.controllers.Menu;
import sample.controllers.ProductList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class ProductManagement {

    public static void main(String args[]) {
        IMenu menu = new Menu();
        menu.addItem("1. Add new product");
        menu.addItem("2. Remove a product");
        menu.addItem("3. Update a product");
        menu.addItem("4. Sort list");
        menu.addItem("5. Show the list");
        menu.addItem("6: Quit");
        int choice;
        boolean cont = false;
        IList list = new ProductList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.remove();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.sort();
                    list.output();
                    break;
                case 5:
                    list.output();
                    break;
                case 6:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    break;
            }
        } while (!cont);
    }
}
