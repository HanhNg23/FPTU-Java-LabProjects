/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot16b;

import slot16.*;

/**
 *
 * @author HOANGANH
 */
public class UsingBoGiaoDuc {
    public static void main(String args[]){
    BoGiaoDuc obj[] = new BoGiaoDuc[3]; // cái này không phải tạo instance mà là tạo mảng
    obj[0] = new FPTUni();
    obj[1] = new BKUni();
    obj[2] = new TDTUni();
    for(BoGiaoDuc boGiaoDuc : obj){
        boGiaoDuc.show();   
     }
    }
}        
