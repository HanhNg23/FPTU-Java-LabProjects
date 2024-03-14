/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HOANGANH
 */
public class MenuList extends ArrayList<String> {

    public MenuList() {
        super();
    }

    public MenuList(String[] items) {
        super();
        for (String item : items) {
            this.add(item);
        }
    }

    //Get user choice
    public int getChoice(String title) { //choice from 1 to 8 . Other character refer to QUIT
        int t = -1;
        System.out.println(title);
        for (int i = 0; i < this.size(); ++i) {
            System.out.println( "|  " + (i + 1) + "  " + this.get(i));
        }
        System.out.print("-------------------------------------------\n");
        System.out.println("      Other for quit \n" + "      Choose from " + 1 + " to " + this.size());

        try {
            System.out.print("   \u001b[35;1mYour choice: ");           
            t = new Scanner(System.in).nextInt();
            return t;//if t is integer then automatic break and return value t;
        } catch (Exception e) {
            return t;
        }
    }

}
