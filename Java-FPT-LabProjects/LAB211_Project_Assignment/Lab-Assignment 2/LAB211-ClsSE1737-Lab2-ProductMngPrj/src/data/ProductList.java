/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import menudta.MenuList;
import tools.MyTool;

/**
 *
 * @author HOANGANH
 */
public class ProductList extends ArrayList<Product> {

    public ProductList() {
        super();
    }

    boolean change = false;
    String space = "\\s+";
    String filename = "";
    ArrayList<Product> listfrFile = new ArrayList<Product>();

    public ArrayList<Product> sumlist() {
        ArrayList<Product> sumList = new ArrayList<>();
        sumList.addAll(listfrFile);
        sumList.addAll(this);
        return sumList;
    }

    public void initFile() {
        this.filename = "DataProduct\\products list.txt";
        loadDealerFromFile();
    }

    //*load dealers from file
    private void loadDealerFromFile() {
        List lines = null;
        lines = MyTool.readLinesFromFile(filename);
        for (int i = 0; i < lines.size(); ++i) {
            Product productfromfile = new Product(lines.get(i).toString());
            this.listfrFile.add(productfromfile);
        }
    }
    
    

    public int existinFile(String id) {
        id = id.toUpperCase().trim();
        for (int i = 0; i < listfrFile.size(); ++i) {
            if (listfrFile.get(i).getProductID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public int existthisList(String id) {
        id = id.toUpperCase().trim();
        for (int i = 0; i < this.size(); ++i) {
            if (id.equals(this.get(i).getProductID())) {
                return i;
            }
        }
        return -1;
    }

    public int existsumList(String id) {
        id = id.toUpperCase().trim();
        for (int i = 0; i < this.sumlist().size(); ++i) {
            if (this.sumlist().get(i).getProductID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void exist() {
        System.out.print("Enter ProductID to check in file: ");
        String id = MyTool.SC.nextLine();
        int result = existinFile(id);
        System.out.println(result >= 0 ? "\nExist Product\n" : "\n\u001b[33;1mNo Product Found!\n");

    }

    //ask for search by what ???
    public void searchbyNameSubstr() {
        System.out.print("Search product's name: ");
        System.out.println();
        String subname = MyTool.SC.nextLine();
        subname = subname.replaceAll(space, "");
        boolean hasfind = false;
        for (Product i : this.sumlist()) {
            if (i.getProductName().contains(subname)) {
                System.out.println(i);
                hasfind = true;
            }
        }
        if (!hasfind || this.sumlist().size() == 0) {
            System.out.println("\u001b[32;1mHave no any Product\n");
        }
    }

    public void create() {
        String productID;
        String productName;
        float unitprice;
        int quantity;
        String status;
        int checkID;
        do { //first check Does ID input is repeated or invalid
            productID = MyTool.readPattern("ID of new Product: ", Product.ID_FORMAT);
            productID = productID.toUpperCase();
            checkID = existsumList(productID);
            if (checkID >= 0) {
                System.out.println("\u001b[31;1mID is duplicated!\u001b[0m");
            }
        } while (checkID >= 0);
        productName = MyTool.readNonSpace("Product's Name [at least 5 characters]: ", 5);
        unitprice = MyTool.readFloatNum("Unitprice: ");
        quantity = MyTool.readIntNum("Quatity: ");
        if (quantity == 0) {
            status = "Status: Not Availble";
            System.out.println(status);
        } else {
            status = MyTool.readStatus("[press 1-Available / 0-Not Availble] Status:  ");
        }
        Product product = new Product(productID, productName, unitprice, quantity, status);
        this.add(product);
        change = true;
    }

    public void update() {
        String productID;
        String newproductName;
        float newunitprice;
        int newquantity;
        String newstatus;
        int checkID;
        int choice;

        System.out.print("Product's ID needs updating: ");
        String ID = MyTool.SC.nextLine().trim();
        checkID = this.existthisList(ID);
        if (checkID < 0) {
            System.out.println("\u001b[33;1mProduct with " + ID + " not found in this current list!\n");
            return;
        } else {
            Product updpro = this.get(checkID); //this list is the runtime list
//          update newproductName; 
            do {
                String[] options = {
                    "- Product's Name",
                    "- Unitprice",
                    "- Quantity",
                    "- Status",
                    "- Quit"};
                MenuList submenu = new MenuList(options);
                System.out.println("Which field you want to update ?");
                choice = MyTool.getNumChoice("Your choice: ", submenu, 1, 5);
                System.out.println();
                switch (choice) {
                    case 1:
                        newproductName = MyTool.readNonSpace("New Product's name: ", 5);
                        updpro.setProductName(newproductName);
                        change = true;
                        break;
                    case 2:
                        newunitprice = MyTool.readFloatNum("New Unitprice: ");
                        updpro.setUnitprice(newunitprice);
                        change = true;
                        break;
                    case 3:
                        newquantity = MyTool.readIntNum("New Quantity: ");
                        updpro.setQuantity(newquantity);
                        if (updpro.getQuantity() == 0) {
                            updpro.setStatus("Status: Not Available");
                        }
                        change = true;
                        break;
                    case 4:
                        if (updpro.getQuantity() == 0) {
                            System.out.println("The quantity is zero. So the status is Not Available");
                            break;
                        }
                        newstatus = MyTool.readStatus("[press 1-Available / 0-Not Availble] Status:  ");
                        updpro.setStatus(newstatus);
                        change = true;
                        break;
                }
            } while (choice < 5);
            System.out.println("\n\u001b[33;1mAfter update of ProductId "+ID);
            System.out.println(this.get(checkID)+"\n\u001b[0m");
        }
    }

    public void remove() {
        String ID = MyTool.readNonBlank("Enter Product's ID to delete: ");
        int checkID = this.existthisList(ID);
        if (checkID < 0) {
            System.out.println("\u001b[33;1mNot Found ! \n \u001b[33;1mRemove failed");
            return;
        } else {
            this.remove(checkID); 
            System.out.println("Remove success");
            change = true;
        }
    }

    public void showcurList() {
        if (this.size() == 0) {
            System.out.println("\u001b[33mEmpty List !\n");
        } else {
            this.sort(this);
            //System.out.println(this + "\n");
            System.out.println("|----------------------------------------------------------------------------------------|");
            System.out.println("|  ID  |      Product Name         |       UnitPrice      |   Quantity  |     Status     |");
            System.out.println("|------|---------------------------|----------------------|-------------|----------------|");
            for(Product i : this){
                System.out.println("| "
                        +i.getProductID()+" | "
                        +i.getProductName()
                        +space(i.getProductName(), 25)+" | "
                        +i.getUnitprice()+space(String.valueOf(i.getUnitprice()), 20)+" | "
                        +i.getQuantity()+space(String.valueOf(i.getQuantity()),11)+" | "
                        +i.getStatus()+ space(i.getStatus(), 15)+"|");
            }
            System.out.println("|------|---------------------------|----------------------|-------------|----------------|\n");
        }
    }

    public void showfromFile() {
        if (this.listfrFile.isEmpty()) {
            System.out.println("\u001b[33mEmpty List !\n");
        } else {
            this.sort(listfrFile);
            //System.out.println(listfrFile + "\n");
            System.out.println("|----------------------------------------------------------------------------------------|");
            System.out.println("|  ID  |      Product Name         |       UnitPrice      |   Quantity  |     Status     |");
            System.out.println("|------|---------------------------|----------------------|-------------|----------------|");
            for(Product i : listfrFile){
                System.out.println("| "
                        +i.getProductID()+" | "
                        +i.getProductName()
                        +space(i.getProductName(), 25)+" | "
                        +i.getUnitprice()+space(String.valueOf(i.getUnitprice()), 20)+" | "
                        +i.getQuantity()+space(String.valueOf(i.getQuantity()),11)+" | "
                        +i.getStatus()+ space(i.getStatus(), 15)+"|");
                }
            System.out.println("|------|---------------------------|----------------------|-------------|----------------|\n");
        }
    }

    //Write dealer list to file
    public void writeProductToFile() {
        if (change) {
            MyTool.writeFile(filename, sumlist());
            System.out.println("*Writted to file successfully.\n");
            this.removeAll(this);
            listfrFile.removeAll(listfrFile);
            sumlist();
            change = false; //sau khi changed xong return default value of change
        }
    }

    public void sort(ArrayList o) {
        Collections.sort(o, new Product());
    }

    public boolean isChanged() {
        return change;
    }

    public void setChanged(boolean changed) {
        this.change = changed;
    }
    
    public static String space(String str, int maxspace){
        int number = maxspace - str.length();
        String newstr = "";
        for(int i = 0; i < number; ++i){
            newstr += " ";
        }
        return newstr;
    }

}
