/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOANGANH
 */
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Test_2 {

    public String randomstr(String s) {
        Scanner sc = new Scanner(System.in);
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        System.out.println("String: ");
        String str = sc.nextLine();
        System.out.println("lensub: ");
        int lensub = sc.nextInt();
        int length = str.length();
        int numsub = 1;
        for (int i = length; i > length - lensub; i--) {
            numsub = numsub * length;
        }
        System.out.println("numsub: " + numsub);
        for (int i = 0; i < lensub; i++) {
            int index = random.nextInt(length);
            char chatStr = str.charAt(index);
            sb.append(chatStr);
        }
        return sb.toString();

    }

    public static HashMap<Character, Integer> countchar(String str) {
        HashMap<Character, Integer> countChar = new HashMap<>();
        char[] chararr = str.toCharArray();
        for (char c : chararr) {
            if (countChar.containsKey(c)) {
                countChar.put(c, countChar.get(c) + 1);
            } else {
                countChar.put(c, 1);
            }
        }
        return countChar;

//        Scanner scan = new Scanner(System.in);
//        String str1 = scan.nextLine().toLowerCase();
//        String str2 = scan.nextLine().toLowerCase();
//
//        HashMap<Character, Integer> countchar1 ;
//        HashMap<Character, Integer> countchar2 ;
//        countchar1 = countchar(str1);
//        countchar2 = countchar(str2);
//        
//        System.out.print("STR1: " + countchar1);
//        System.out.print("\nStr2: " + countchar2);
//        System.out.println(countchar1.equals(countchar2) == true ? "Yes" : "No" );
    }

    public void splitstring() {
        Scanner sc;
        String s = "I love you so much. I want to marry you";
        sc = new Scanner(s);
        while (sc.hasNext()) { //hasNext dùng delimiter default là backspace
            String token = sc.next();
            System.out.println(token);
        } //out put I \n love \n you \n so \n much. \n I \n want \n to \n mary \n you \n

        String s1 = "I love you 4 so much. 34 I 23 want to marry you";
        sc = new Scanner(s1);
        sc.useDelimiter("[^\\d]+"); //change Delimiter is ki tu khong phai chu so
        while (sc.hasNext()) {
            String token = sc.next();
            System.out.println(token);
        }//outout 4 \n 34 \n 23 \n
    }

    public static boolean myRegrex(String string) {
        String zerototofive = "(((0|1)?\\d{1,2})|2[0-4]\\d|25[0-5])";
        String regrex = zerototofive + "." + zerototofive + "." + zerototofive + "." + zerototofive;
        Pattern pattern = Pattern.compile(zerototofive);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }

    }

    public static String removeDupwordcontiguous(String string) { //chi xoa cac ki tu giong nhau va nam ke nha
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matches = pattern.matcher(string);
        while (matches.find()) {
            string = string.replaceAll(matches.group(0), matches.group(1));
        }
        return string;
    }

    public static String removeallplicatetedword(String string) {
        string = string.trim().replaceAll("\\s+", " ");
        System.out.println(string);
        String[] str = string.split(" ");
        List<String> oldstrarr = Arrays.asList(str);
        List<String> strarr = new ArrayList<>(oldstrarr);
        System.out.println(str.length + " " + strarr.size());
        System.out.println();
        for (int i = 0; i < strarr.size(); i++) {
            System.out.println(strarr.get(i));
        }

        for (int i = 0; i < strarr.size(); i++) {
            for (int j = i + 1; j < strarr.size();) {
                if (strarr.get(i).toLowerCase().equals(strarr.get(j).toLowerCase())) {
                    strarr.remove(j);
                } else {
                    j = j + 1;
                }

            }
        }
        String newstr = "";
        for (int j = 0; j < strarr.size(); j++) {
            newstr = strarr.get(j) + " ";
        }

        return newstr;
    }

    public static void username(String string) {
        String regex = "^[a-zA-Z]\\w{7,29}";
        Pattern patern = Pattern.compile(regex);
        Matcher m = patern.matcher(string);
        if (m.matches()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    public static void extractfromtag() {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String regex = "<(?<tag>.+)>(?<midva>[^<>]+)</(?<tage>\\1)>";
        Pattern patern = Pattern.compile(regex);

        while (num > 0) {
            String string = scan.nextLine();
            Matcher m = patern.matcher(string);
            boolean check = false;

            while (m.find()) { //continue to find on the line
                //System.out.println("tag" + m.group("tag"));
                System.out.println(m.group("midva"));
                //System.out.println("tage" + m.group("tage"));
                check = true;
            }

            if (check == false) {
                System.out.println("None");
            }
            num--;
        }

    }

    
     public static int sum(String string) {
        int count = 0;
        int sum = 0;
        string = string.trim().replaceAll("\\s+", " ");
        String[] strarr = string.split(" ");
        Pattern pattern = Pattern.compile("-?\\d+"); //check so thap fan: -?\d+(\.\d+)?
        String number = "";
        for (int i = 0; i < strarr.length; i++) {
            Matcher match = pattern.matcher(strarr[i]);
            if (match.matches()) {
                count++;
                if (count == 1) {
                    number = number + strarr[i];
                    break;
                }
        }
        }
              count = 0;
        for (int i = strarr.length - 1; i >= 0; i--) {
            Matcher match = pattern.matcher(strarr[i]);
            if (match.matches()) {
                count++;
                if (count == 1) {
                    number = number + strarr[i];
                    break;
                }
            }
        }
        System.out.println(number);
        for (int i = 0; i < number.length(); i++) {
            sum = sum + Character.getNumericValue(number.charAt(i));
        }

        return sum;
    }

    

    public static void main(String[] args) {
        //-----Approach 1-----//
        Scanner scan = new Scanner(System.in);
        /*ArrayList<Integer> rowele = new ArrayList<>(); //khuc *new ArrayList<>() khong cap phat cung duoc * at the same time
        ArrayList<ArrayList<Integer>> row = new ArrayList<>();

        int numrow = scan.nextInt();
        for (int j = 0; j < numrow; j++) {
            int numeleRow = scan.nextInt();
            //*rowele = new ArrayList<>(); /=
            for (int i = 0; i < numeleRow; i++) {
                int value = scan.nextInt();
                rowele.add(i, value);
            }
            //row.add(new ArrayList<>());
            //row.get(j).addAll(rowele);
            row.add(j, rowele);
            rowele = new ArrayList<>(); // this line recreate memory for rowele
        }
        System.out.println(row);
        int numofqueries = scan.nextInt();
        while (numofqueries-- > 0) {
            try {
                int roww = scan.nextInt() - 1;
                int coll = scan.nextInt() - 1; //vi de array bat dau bang index 1
                System.out.println(row.get(roww).get(coll));
            } catch (Exception e) {
                System.out.println("ERROR!");
            } */

        String s = scan.nextLine();
        System.out.println(sum(s));
        //f2(s)

    }

}
