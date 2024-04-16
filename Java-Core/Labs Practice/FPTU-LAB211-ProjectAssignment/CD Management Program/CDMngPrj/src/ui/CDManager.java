
package ui;

import dao.CDDao;
import dao.CDDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.CDs;
import tool.MyTool;

public class CDManager {

    public static void main(String[] args) {
        String[] options = {"Add new CD to the new catalog",
                            "Search CD by CD title",
                            "Display the new catalog",
                            "Update CD in new catalog",
                            "Save the new catalog to file",
                            "Print list of CDs from file"
        };
        Menu menu = new Menu(options);
        int choice = 0;
        int choice2 = 0;
        String response, inputname;
        int inputID;
        CDs CD;
        boolean changed = false;
        CDDao CDDao = new CDDaoImpl();
        do {

            choice = menu.getChoice("CD MANAGEMENT");
            switch (choice) {
                case 1:
                    System.out.println();
                    CDDao.addCD();
                    changed = true;
                    break;
                case 2:
                    System.out.println();
                    MyTool.sc.nextLine();
                    inputname = MyTool.readNonBlank("Enter CD Title: ");
                    inputname = inputname.toLowerCase();
                    List<CDs> list = new ArrayList<>();
                    list = CDDao.getCDByName(inputname);
                    if (list.isEmpty()) {
                        System.out.println("    No CD Found!");
                    } else {
                        for (CDs CDs : list) {
                        	CDs.print();
                        }
                    }
                    break;
                case 3:
                    System.out.println();
                    CDDao.getNewCDs();
                    break;
                case 4:
                    System.out.println();
                    boolean quit = false;
                    do {
                        menu.list.clear();
                        menu.list.add("Update a CD");
                        menu.list.add("Delete a CD");
                        choice2 = menu.getChoice2("UPDATE CDs");
                        switch (choice2) {
                            case 1:
                                System.out.println();
                                boolean quit2 = false;
                                do {
                                    try {
                                        System.out.print("Enter ID: ");
                                        inputID = Integer.parseInt(MyTool.sc.next());
                                        CD = CDDao.updateID(inputID);
                                        if (CD != null) {
                                            CDDao.updateCD(CD);
                                        }
                                    } catch (Exception e) {
                                        System.out.println("");
                                        System.out.println("    No CD Found!");
                                    }
                                    quit2 = true;
                                } while (!quit2);
                                changed = true;
                                break;
                            case 2:
                                System.out.println();
                                boolean quit3 = false;
                                do {
                                    try {
                                        System.out.print("Enter ID: ");
                                        inputID = Integer.parseInt(MyTool.sc.next());
                                        CD = CDDao.updateID(inputID);
                                        if (CD != null) {
                                            CDDao.deleteCD(CD);
                                        }
                                    } catch (Exception e) {
                                        System.out.println("");
                                        System.out.println("    No CD found in the new catalog!");
                                    }
                                    quit3 = true;
                                } while (!quit3);
                                changed = true;
                                break;
                            default:
                                quit = true;
                        }
                    } while (!quit);
                    break;
                case 5:
                    System.out.println();
                    CDDao.saveFile();
                    changed = false;
                    break;
                case 6:
                    System.out.println();
                    for (CDs items : CDDao.getAllCDs()) {
                        if (items != null) {
                            items.print();
                        }
                    }
                    break;
                default:
                    if (changed) {
                        boolean check = true;
                        do {
                            System.out.print("Save changes to the file Y/N? ");
                            response = MyTool.sc.next().toUpperCase();
                            if (response.startsWith("Y")) {
                                CDDao.saveFile();
                                check = false;
                            } else if (response.startsWith("N")) {
                                check = false;
                            } else {
                                check = true;
                            }
                        } while (check);
                    }
            }
        } while (choice > 0 && choice < 7);
        System.out.println("Goodbye.");
    }
}
