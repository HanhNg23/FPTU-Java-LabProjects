package sample.view;

import sample.controllers.CandidateList;
import sample.dto.IList;
import sample.dto.IMenu;
import sample.controllers.Menu;
import sample.controllers.CandidateList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class CandidateManagement {

    public static void main(String args[]) {
        IMenu menu = new Menu();
        menu.addItem("1. Add new Candidate ");
        menu.addItem("2. Remove a Candidate ");
        menu.addItem("3. Update a Candidate ");
        menu.addItem("4. Sort Cadidate list ");
        menu.addItem("5. Show the list ");
        menu.addItem("6. Search by index ");
        menu.addItem("7: Quit ");
        int choice;
        boolean cont = false;
        IList list = new CandidateList();
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
                    list.search();
                    break;
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit ? (Y/N)");
                    System.out.println("\u001b[35mGoodbye and have a nice day");
                    break;
                    
            }
        } while (!cont);
    }
}
