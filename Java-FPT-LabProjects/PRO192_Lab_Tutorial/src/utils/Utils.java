package utils;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class Utils {

    public static int inputIntNumber(String wellcome) {
        int number = 0;
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        do {
            try {
                System.out.print(wellcome);
                number = Integer.parseInt(scan.nextLine().trim());
                cont = false;
            } catch (Exception e) {
                System.out.println("\u001B[31mRequired integer!");
            }
        } while (cont);
        return number;
    }

    public static int inputIntNumber(int top, int bot) {
        int number = 0;
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        do {
            try {
                System.out.print("Input an integer number");
                number = Integer.parseInt(scan.nextLine().trim());
                if(number < bot || number > top){ 
                    throw new ArithmeticException(); //do this to create new exception by own
                } 
                cont = false; // set fasle to break the iterations
            } catch (Exception e) {
                System.out.println("\u001B[31mRequired integer!");
            }
        } while (cont || number > top || number < bot);
        return number;
    }

    public static int inputInt(String wellcome, int top, int bot) {
        int number = 0;
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        do {
            try {
                System.out.print(wellcome + "[" + bot + "," + top + "]: ");
                number = Integer.parseInt(scan.nextLine().trim());
                if(number < bot || number > top){ 
                    throw new ArithmeticException(); //do this to create new exception by own
                } 
                cont = false;
            } catch (Exception e) {
                System.out.println("\u001B[31mNumber in range " + "[" + bot + "," + top + "]. Please input again !!!");
            }
        } while (cont || number > top || number < bot);
        return number;
    }

    public static String inputString(String wellcome) {
        String input = "";
        Scanner scan = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                System.out.print(wellcome);
                input = scan.nextLine();
                if (input.isBlank() == true) {
                    throw new Exception();
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mPlease input again");
            }
        } while (check);
        return input;
    }

    public static String updateString(String wellcome, String oldValue) {
        String newinput = oldValue;
        Scanner scan = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                System.out.print(wellcome);
                newinput = scan.nextLine();
                if (newinput.isBlank()) {
                    newinput = oldValue;
                }
                check = false;
            } catch (Exception e) {
                System.out.println("\u001B[31mError! " + wellcome);
            }
        } while (check);
        return newinput;
    }

    public static int updateInt(String wellcome, int top, int bot, int oldValue) {
        int newnumber = oldValue;
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        do {
            try {
                System.out.print(wellcome + "[" + bot + "," + top + "]: ");
                String temp = scan.nextLine().trim();
                if (temp.equals("")) {
                    newnumber = oldValue;
                    cont = false;
                } else {
                    newnumber = Integer.parseInt(temp);
                    if (newnumber < bot || newnumber > top) {
                        throw new ArithmeticException(); //do this to create new exception by own
                    }
                    cont = false;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mInput number" + "[" + bot + "," + top + "]: ");
            }
        } while (cont);
        return newnumber;
    }

    public static String inputPhone(String wellcome) {
        String phonenumber;
        boolean valid = true;

        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(wellcome);
            phonenumber = scan.nextLine();
            valid = checkPhonenumber(phonenumber);
            if (valid == false) {
                System.out.println("\u001B[31mThe phone number is not valid");
            }
        } while (valid == false);
        System.out.println("The phone number is valid");

        return phonenumber;
    }

    public static String updatePhone(String wellcome, String oldValue) {
        String newphonenumber = oldValue;
        boolean valid = true;

        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(wellcome);
            newphonenumber = scan.nextLine();
            valid = checkPhonenumber(newphonenumber);
            if (newphonenumber.isBlank()) {
                System.out.println("No changes in phonenumber");
                newphonenumber = oldValue;
                valid = true;
            } else if (valid == false) {
                System.out.println("\u001B[31mThe phone number is not valid");
            }
        } while (valid == false);
        System.out.println("The phone number is valid");
        return newphonenumber;
    }

    public static boolean checkPhonenumber(String phonenumber) {
        Pattern pattern = Pattern.compile("[0]?[0-9]{9}");
        Matcher matcher = pattern.matcher(phonenumber);
        return matcher.matches();
    }

    public static void chooseArrayMenu() {
        System.out.println("1. Enter element");
        System.out.println("2. Display array");
        System.out.println("3. Sort array");
        System.out.println("4. Search the index of a number in array");
        System.out.println("5. Exit");
    }

    public static void chooseZooMenu() {
        System.out.println("Animal Management");
        System.out.println("1. Input Animal Group 1");
        System.out.println("2. Input Animal Group 4");
        System.out.println("3. Update Animal Group 1");
        System.out.println("4. Update Animal Group 4");
        System.out.println("5. Delete An Animal In The Zoo");
        System.out.println("6. Display Animal In The Zoo");
        System.out.println("7. Quit");
    }
    
     public static void chooseMenuStudent() {
        System.out.println("Student Management");
        System.out.println("1. Input Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Display Student");
        System.out.println("5. Show Student list");
        System.out.println("6. Quit");

    }

    public static boolean inputBoolean(String welcome) {
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        do {
            try {
                System.out.print(welcome);
                int number = Integer.parseInt(scan.nextLine().trim());
                if (number == 1) {
                    check = true;
                    cont = false;//cont false to break the iterations
                } else if (number == 0) {
                    check = false;
                    cont = false;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mRequired integer!");
            }
        } while (cont);
        return check;
    }

    public static boolean updateBoolean(String welcome, boolean oldvalue) {
        boolean newcheck = oldvalue;
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        do {
            try {
                System.out.print(welcome);
                int number = Integer.parseInt(scan.nextLine().trim());
                if (number == 1) {
                    newcheck = true;
                    cont = false;
                } else if (number == 0) {
                    newcheck = false;
                    cont = false;
                }else throw new Exception();
                
            } catch (Exception e) {
                System.out.println("\u001B[31m1 for True : 0 for False");
            }
        } while (cont);
        return newcheck;
    }
    
    
        
     public static boolean answerYesNo(String welcome) {
        boolean answer = true;
        Scanner scan = new Scanner(System.in); 
        boolean cont = true;
        do {
            try {
                System.out.println(welcome + "[Yes -> press 'Y' : No -> press 'N'");
                String useranswer = scan.nextLine();
                if (useranswer.trim().equalsIgnoreCase("Y")) {
                    answer = true;
                    cont = false;//cont false to break the iterations
                } else if (useranswer.trim().equalsIgnoreCase("N")) {
                    answer = false;
                    cont = false;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("\u001B[31mPlease enter only 'Y' or 'N' !!! \u001B[0m");
            }
        } while (cont);
        return answer;
    }
     

}
