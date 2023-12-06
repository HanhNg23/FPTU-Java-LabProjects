/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot21;

import java.util.List;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author HOANGANH
 */
public class usingStudent {

    public static void main(String[] args) {
        List<Student> sList = new ArrayList<Student>();
        boolean flag = true;
        String id = "";
        int index = 0;
        Student st = new Student();
        boolean check = true;
        do {
            Utils.chooseMenuStudent();
            int choose = Utils.inputInt("Which one you choose ", 6, 1);

            switch (choose) {
                case 1:
                    Student iSt = new Student();
                    check = iSt.create();
                    
                    if (check && !sList.contains(iSt)) {
                        sList.add(iSt);
                    }
                    break;
                case 2:
                    id = Utils.inputString("Id update: ");
                    index = sList.indexOf(new Student(id));
                    if (index > -1) {
                        sList.get(index).update();
                    }
                    break;
                case 3:
                    id = Utils.inputString("Id delete: ");
                    index = sList.indexOf(new Student(id));
                    if (index > -1) {
                        sList.remove(index);
                    }
                    break;
                case 4:
                    id = Utils.inputString("Id search");
                    index = sList.indexOf(new Student(id));
                    if (index > -1) {
                        System.out.println("Found");
                        sList.get(index).showInfor();
                    }
                    break;
                case 5:
                    for (int i = 0; i < sList.size(); i++) {
                        sList.get(i).showInfor();
                    }
                    break;
                case 6:
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
