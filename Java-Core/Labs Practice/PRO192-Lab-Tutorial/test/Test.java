/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOANGANH
 */
import java.io.*;
import java.util.*;
import utils.Utils;
public class Test {
     String s;
     Test(){
         
     }
      Test (String s){
        this.s = s;
        String alphabet =s.replaceAll("[^A-Za-z]",""); 
              alphabet = alphabet.trim();
        String number =s.replaceAll("[^0-9]","");
              number = number.trim();
              
        
        
//        int lenABC = alphabet.length();
//          System.out.print(alphabet);
//        for(int i = lenABC; i < 16; i++) System.out.print(" ");
//        if(number.length() == 1) System.out.print("00"+number);
//        else if(number.length() == 2) System.out.print("0"+number);  
//        else
//        	System.out.print(number);
        System.out.println(s.replaceAll(" ", "").length());
        //System.out.print(s.length());
        System.out.println();
      } 
    public boolean reverseWord(String word) {
        boolean check = false;
        int lenWord = word.length();
        char ch;
        String nstr = "";
        for (int i = 0; i < lenWord; i++) {
            ch = word.charAt(i);
            nstr = ch + " " + nstr; // khac voi nstr + ch
        }

        if (nstr.equals(word)) {
            check = true;
        }
        System.out.println(nstr);
        return check;
    }

       public static void main(String[] args) {
           
           
           String string = " HELLO                WOE     @@      ";
           string =string.trim().replaceAll("\\s+", " ");
     
           System.out.println(string.split(" ").length);
           
           System.out.println((new Test()).reverseWord("hello"));
           
           String a = Utils.inputString("The string: ");
           String b = Utils.inputString("The word to be replace: ");

           a = a.replaceAll(b, "hehe" );
           
           System.out.println(a);
                      
           new Test("java 65");
           new Test("java 50");
       }         
}
    
    
 