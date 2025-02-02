/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

import tools.MyTool;
import mng.LogIn;

public class DealerList extends ArrayList<Dealer> {

    LogIn loginObj = null;
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile = "";
    boolean changed = false; //whether data in the list changed or not

    public DealerList(LogIn loginObj) {
        this.loginObj = loginObj;
    }

    //*load dealers from file
    private void loadDealerFromFile() {
        List lines = null;
        lines = MyTool.readLinesFromFile(dataFile);
        for (int i = 0; i < lines.size(); ++i) {
            Dealer dealerfromfile = new Dealer(lines.get(i).toString());
            this.add(dealerfromfile);
        }
    }

    public void initWithFile() {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }

    public DealerList getContinuingList() {
        DealerList resultlist = new DealerList(this.loginObj);
        for (int i = 0; i < this.size(); ++i) {
            Dealer d = this.get(i);
            if (d.isContinuing() == true) {
                resultlist.add(d);
            }
        }
        return resultlist;
    }

    public DealerList getUnContinuingList() {
        DealerList resultlist = new DealerList(this.loginObj);
        for (int i = 0; i < this.size(); ++i) {
            Dealer d = this.get(i);
            if (d.isContinuing() == false) {
                resultlist.add(d);
            }
        }
        return resultlist;
    }

    public int searchDealer(String ID) {
        String keyID = ID.toUpperCase().trim();
        for (int i = 0; i < this.size(); ++i) {
            if (keyID.equals(this.get(i).getID())) {
                return i;
            }
        }
        return -1;
    }

    public void searchDealer() {
        System.out.print("ID key: ");
        String keyID = MyTool.SC.nextLine().trim();
        int pos = this.searchDealer(keyID);
        if (pos < 0) {
            System.out.println("NOT FOUND!\n");
        } else {
            System.out.println(this.get(pos));
        }
        System.out.println();
    }

    //Add Deaeler
    public void addDealer() {
        String ID;
        String name;
        String addr;
        String phone;
        boolean continuing;
        int pos;
        do { //first check Does ID input is repeated or invalid
            ID = MyTool.readPattern("ID of new dealer: ", Dealer.ID_FORMAT);
            ID = ID.toUpperCase();
            pos = searchDealer(ID);
            if (pos >= 0) {
                System.out.println("ID is duplicated !");
            }
        } while (pos >= 0);
        name = MyTool.readNonBlank("Name of new dealer: ").toUpperCase();
        addr = MyTool.readNonBlank("Address of new dealer: ");
        phone = MyTool.readPattern("Phone number: ", Dealer.PHONE_FORMAT);
        continuing = true; //default value for new dealer
        Dealer d = new Dealer(ID, name, addr, phone, continuing);
        this.add(d);
        System.out.println("* New dealer has been added.\n");
        changed = true;
    }

    public void removeDealer() {
        System.out.print("ID key: ");
        String keyID = MyTool.SC.nextLine().trim().toUpperCase();
        int pos = this.searchDealer(keyID);
        if (pos < 0) {
            System.out.println("Not found\n");
        } else {
            this.get(pos).setContinuing(!this.get(pos).isContinuing());
            System.out.println("Has Changed Status Continuing\n");
            changed = true; //data changed
        }
        //update a dealer
        //Only name; addr and phone can be changed
    }
    
    public void removeDealerreal() {
        System.out.print("ID key: ");
        String keyID = MyTool.SC.nextLine().trim().toUpperCase();
        int pos = this.searchDealer(keyID);
        if (pos < 0) {
            System.out.println("Not found\n");
        } else {
            this.remove(pos);
            System.out.println("Removed \n");
            changed = true; //data changed
        }
        //update a dealer
        //Only name; addr and phone can be changed
    }

    public void updateDealer() {
        String newName = "";
        String newaddr = "";
        String newphone = "";
        System.out.print("Dealer's ID needs updating: ");
        String ID = MyTool.SC.nextLine().trim();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Dealer " + ID + " not found!\n");
            return ;
        } else {
            Dealer d = this.get(pos);
            //update name            
            System.out.print("new name, ENTER for omitting: ");
            newName = MyTool.SC.nextLine().trim().toUpperCase();
            if (!newName.isEmpty()) {
                d.setName(newName);
                changed = true;
            }
            //update addr            
            System.out.print("new address, ENTER for omitting: ");
            newaddr = MyTool.SC.nextLine().trim();
            if (!newaddr.isEmpty()) {
                d.setAddr(newaddr);
                changed = true;
            }
            //update phone  
            boolean cont = false;
            do {
                System.out.print("new phone, ENTER for omitting: ");

                newphone = MyTool.SC.nextLine().trim();

                if (!newphone.isEmpty()) {
                    if (MyTool.validStr(newphone, PHONEPATTERN)) {
                        d.setPhone(newphone);
                        cont = true;
                        changed = true;
                    } else {
                        System.out.println("Invalid Phone number");
                    }
                }
                if(newphone.isEmpty()) cont = true;
            } while (!cont);
              System.out.println("After updated: " + this.get(pos) + "\n");
        }
    }

    //Print all dealers
    public void printAllDealers(String tableTitleName) {
        if (this.isEmpty()) {
            System.out.println("Empty List !\n");
        } else {
            this.sort();
            this.printTableList(tableTitleName);
            //System.out.println(this + "\n");
        }
    }

    //Print all continuing dealers
    public void printContinuingDealers() {
        this.getContinuingList().printAllDealers("List Of Continuing Dealers");
    }

    //Print all uncontinuing dealers
    public void printUnContinuingDealers() {
        this.getUnContinuingList().printAllDealers("List Of UnContinuing Dealers");
    }

    //Write dealer list to file
    public void writeDealerToFile() {
        if (changed) {
            MyTool.writeFile(dataFile, this);
            System.out.println("*Writted to file successfully.\n");
            changed = false; //sau khi changed xong return default value of changed
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
    
    public void sort(){
    	Collections.sort(this);
    }
    
    public void printTableList(String tableTileName) {
    	String[] header = {"Id", "Name", "Address", "Phone", "Is Continuing"};
    	List<String> idList = this.stream().map(x -> x.getID()).collect(Collectors.toList());;
    	List<String> nameList = this.stream().map(x -> x.getName()).collect(Collectors.toList());
    	List<String> addrList = this.stream().map(x -> x.getAddr()).collect(Collectors.toList());
    	List<String> phoneList = this.stream().map(x -> x.getPhone()).collect(Collectors.toList());
    	List<String> isContinuing = this.stream().map(x -> Boolean.toString(x.isContinuing())).collect(Collectors.toList());
    	
    	idList.addFirst(header[0]);
    	nameList.addFirst(header[1]);
    	addrList.addFirst(header[2]);
    	phoneList.addFirst(header[3]);
    	isContinuing.addFirst(header[4]);
    	
    	String longestID = idList.stream()
                .max((s1, s2) -> s1.length() - s2.length())
                .orElse("");
    	String longestName = nameList.stream().max((s1, s2) -> s1.length() - s2.length())
                .orElse("");
    	String longestAddr = addrList.stream().max((s1, s2) -> s1.length() - s2.length())
                .orElse("");
    	String longestPhone = isContinuing.stream().max((s1, s2) -> s1.length() - s2.length())
                .orElse("");
    	
    	System.out.println("=".repeat(tableTileName.length()+5));
    	System.out.println("    " + tableTileName);
    	System.out.println("=".repeat(tableTileName.length()+5));
    	System.out.println();
    	for(int i = 0; i< this.size(); i++) {
    		System.out.println("| " + idList.get(i) + " ".repeat(longestID.length() - idList.get(i).length() + 3) 
			    			 + "| " + nameList.get(i) + " ".repeat(longestName.length() - nameList.get(i).length() + 3)	
			    			 + "| " + addrList.get(i) + " ".repeat(longestAddr.length() - addrList.get(i).length() + 3)	
			    			 + "| " + phoneList.get(i) + " ".repeat(longestPhone.length() - phoneList.get(i).length() + 3)	
			    			 + "| " + isContinuing.get(i)
    				);
    	}
    	System.out.println();
    }

  
    

}
