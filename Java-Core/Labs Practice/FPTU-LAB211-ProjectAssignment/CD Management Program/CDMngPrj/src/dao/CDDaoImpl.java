
package dao;

import model.CDs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tool.MyTool;
import static tool.MyTool.sc;

public class CDDaoImpl implements CDDao {

    private List<CDs> CDs;
    private CDs[] list;
    private int numOfCD;
    private final int MAX = 2;//teacher       
    String filename = "CD.dat";

    public CDDaoImpl() {
        CDs = new ArrayList<>();
        list = new CDs[MAX];
        numOfCD = 0;
    }

    public boolean searchFileCDID(int ID) {
        List<CDs> list = new ArrayList<>();
        list = MyTool.loadFromFile(filename, list);
        for (CDs CD : list) {
            if (CD.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public boolean searchFileCDName(String CDTitle) {
        List<CDs> list = new ArrayList<>();
        list = MyTool.loadFromFile(filename, list);
        for (CDs CD : list) {
            if (CD.getTitle().equalsIgnoreCase(CDTitle)) {
                return true;
            }
        }
        return false;
    }

    public void getNewCDs() {
        if (numOfCD == 0) {
            System.out.println("");
            System.out.println("    Empty List.");
        }
        for (int i = 0; i < numOfCD; i++) {
            list[i].print();
        }
    }

    public List<CDs> getAllCDs() {
        CDs = MyTool.loadFromFile(filename, CDs);
        if (CDs.isEmpty()) {
            System.out.println("");
            System.out.println("    Empty File.");
        }
        Collections.sort(CDs);
        return CDs;
    }

    public List<CDs> getCDByName(String name) {
        CDs = MyTool.loadFromFile(filename, CDs);
        if (CDs.isEmpty()) {
            System.out.println("");
            System.out.println("    Empty File.");
        }
        List<CDs> list = new ArrayList<>();
        for (CDs CD : CDs) {
            if (CD != null && CD.getTitle().toLowerCase().contains(name)) {
                list.add(CD);
            }
        }
        return list;
    }

    public CDs updateID(int ID) {
        for (CDs CD : list) {
            if (CD.getID() == ID) {
                return CD;
            }
        }
        return null;
    }

    public int SearchListID(CDs CD) {
        for (int i = 0; i < numOfCD; i++) {
            if (list[i] == CD) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addCD() {
        int ID;
        String name = "";
        String type = "";
        String title = "";
        double price;
        int year;
        boolean check = true;
        if (numOfCD >= MAX) {
            System.out.println();
            System.out.println("    List is Full, Cannot Add More CD.");
        } else {

            System.out.println("    Enter New CD Details");
            do {
                ID = MyTool.getInt("Enter ID(1-1000): ", 1, 1000);
                if (searchFileCDID(ID)) {
                    System.out.println("    ID is Duplicated!");
                } else {
                    check = false;
                }
            } while (check);
            MyTool.sc.nextLine(); //?????
            do {
                check = true;
                System.out.print("Enter CD Title Name: ");
                title = MyTool.sc.nextLine().trim();
                title = title.replaceAll("\\s+", " ");
                if (searchFileCDName(title)) {
                    System.out.println("    CD Title has exited");
                } else if (title.isEmpty()) {
                    check = true;
                } else {
                    check = false;
                }
            } while (check);

            {
                System.out.println("Enter CD Category Name by pressing one choice");
                System.out.println("    Press 1 - Game");
                System.out.println("    Press 2 - Movie");
                System.out.println("    Press 3 - Music");
                int choice = MyTool.getInt("Your choose: ", 1, 3);
                switch (choice) {
                    case 1:
                        name = "Game";
                        break;
                    case 2:
                        name = "Movie";
                        break;
                    case 3:
                        name = "Music";
                        break;
                }
            }
            {
                System.out.println("Enter CD File Type by pressing one choice");
                System.out.println("    Press 1 - Audio");
                System.out.println("    Press 2 - Video");
                int choice = MyTool.getInt("Your choose: ", 1, 2);
                switch (choice) {
                    case 1:
                        type = "Audio";
                        break;
                    case 2:
                        type = "Video";
                        break;
                }
            }
            price = MyTool.getDouble("Enter Price (Unit price VND, value must greate than 0): ");
            year = MyTool.getInt("Enter Year of Released[1900-2022]: ", 1900, 2022);

            list[numOfCD] = new CDs(ID, title, name, type, price, year);
            numOfCD++;
            System.out.println();
            System.out.println("    New CD Has Been Add! ");
        }

    }

    @Override
    public void updateCD(CDs CD) {
        String newTitle = "";
        String newName = "";
        String newType = "";
        String newPrice;
        String newYear;
        MyTool.sc.nextLine();
        System.out.print("New Title Name, ENTER for omitting: ");
        newTitle = MyTool.sc.nextLine().trim();
        if (!newTitle.isEmpty()) {
            CD.setTitle(newTitle);
        }
        {
            System.out.println("Update CD Category Name by pressing one choice");
            System.out.println("    Press 1 - Game");
            System.out.println("    Press 2 - Movie");
            System.out.println("    Press 3 - Music");
            System.out.println("    Press 4 - Do not Change");
            int choice = MyTool.getInt("Your choose: ", 1, 4);
            switch (choice) {
                case 1:
                    newName = "Game";
                    break;
                case 2:
                    newName = "Movie";
                    break;
                case 3:
                    newName = "Music";
                    break;
                case 4:
                    newName = "";
                    break;
            }
            if (!newName.isEmpty()) {
                CD.setName(newName);
            }
        }
        {
            System.out.println("Update CD Type by pressing one choice");
            System.out.println("    Press 1 - Game");
            System.out.println("    Press 2 - Movie");
            System.out.println("    Press 3 - Do not change");
            int choice = MyTool.getInt("Your choose: ", 1, 3);
            switch (choice) {
                case 1:
                    newType = "Audio";
                    break;
                case 2:
                    newType = "Video";
                    break;
                case 3:
                    newType = "";
                    break;
            }

            if (!newType.isEmpty()) {
                CD.setType(newType);
            }
        }

        boolean checkk = true;
        do {
            try {
                checkk = true;
                System.out.print("New Price (Unit price VND, value must be greater than 0): ");
                newPrice = MyTool.sc.nextLine().trim();
                if (newPrice.isEmpty()) {
                    checkk = false;
                } else {
                    double newprice = Double.parseDouble(newPrice);
                    if (newprice >= 0) {
                        CD.setPrice(newprice);
                        checkk = false;  
                    } else {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input !");
            }
        } while (checkk);

        do {
            try {
                checkk = true;
                System.out.print("New Year [1900-2022]: ");
                newYear = MyTool.sc.nextLine().trim();
                if (newYear.isEmpty()) {
                    checkk = false;
                } else if (!newYear.isEmpty()) {
                    int newyear = Integer.parseInt(newYear);
                    if (newyear >= 1900 && newyear <=2022) {
                        CD.setYear(newyear);
                        checkk = false;
                    } else {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
            }
        } while (checkk);
        System.out.println("");
        System.out.println("Update Complete!\n");
        System.out.println("After update ID " + CD.getID());
        System.out.println("     "+ CD.getID() + ", " + CD.getName() + ", " + CD.getTitle() + ", " + CD.getType() + ", " + CD.getPrice() + ", " + CD.getYear());
    }

    @Override
    public void deleteCD(CDs CD) {
        int pos = SearchListID(CD);
        if (pos >= 0 && pos < numOfCD) {
            for (int i = pos; i < (numOfCD - 1); i++) {
                list[i] = list[i + 1];
            }
            numOfCD--;
            System.out.println("");
            System.out.println("    CD is Deleted!");
        }
    }

    @Override
    public void saveFile() {
        MyTool.saveToFile(list, numOfCD);
        deleteAll(this.list);
        System.out.println("");
        System.out.println("New CD(s) has been saved to the file.");
    }
    
    
    public void deleteAll(CDs[] list){
        for(int i = numOfCD-1; i >=0; i--){
            list[i] = list[i+1];
            numOfCD--;
        }
    }

}
