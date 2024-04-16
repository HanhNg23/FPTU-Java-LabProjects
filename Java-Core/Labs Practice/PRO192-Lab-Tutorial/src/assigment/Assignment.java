/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assigment;

import utils.Utils;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author HOANGANH
 */
public class Assignment {
    
    //1 Write a program to convert decimal integer to base from 2 to 16
    public void chuyendoicoso() {
        char[] array = new char[100];
        int a = Utils.inputIntNumber("Input an integer in decimal ");
        int q = Utils.inputInt("Choose base to convert", 16, 2);
        int r; //a= d.q + r;
        int index = 0;

        while (a != 0) {
            r = a % q;
            a = a / q;
            array[index] = Character.forDigit(r, q);
            //System.out.println("index " + index + ": " + array[index]);
            index++;
        }

        System.out.print("\u001b[36mResult: ");
        for (index = index - 1; index >= 0; index--) {
            System.out.print(array[index]);
            //System.out.println("index " + index + ": " + array[index]);
        }
        System.out.println();
    }
    
   //2 Write a program to count the number of character input ignor space
    public void demkituboquaspace(){
        System.out.print("Enter a string to count the character please ^(^ \n");
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        string = string.replaceAll(" ", "");
        System.out.println(string);
        System.out.println("The number of character input skip space is " + string.length());
    }
    
    public void demtu(){
        int count = 0;
        System.out.print("Enter a string to count the number of words please ^(^ \n");
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        string = string.trim().replaceAll("\\s+", " ");
//        if (string.isEmpty()) {
//            count = 0;
//        } else {
//
//            char[] s = string.toCharArray();
//            for (int i = 0; i < string.length() - 1; i++) {
//                if (s[i] != 32 && s[i + 1] == 32) {
//                    count = count + 1;
//                }
//            }
//        }
//        System.out.println(string);
//        System.out.println(count + 1);


//cach 2
      System.out.println(string.split(" ").length);
    }
    public static void main(String[] args) {
        //new Assignment().chuyendoicoso();
        //new Assignment().demkituboquaspace();
        new Assignment().demtu();
    }
}
