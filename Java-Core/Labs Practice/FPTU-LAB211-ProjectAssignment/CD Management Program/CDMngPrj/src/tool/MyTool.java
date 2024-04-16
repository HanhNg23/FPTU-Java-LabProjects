

package tool;


import model.CDs;
import java.util.Scanner; //for input data
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List; //Interface for a list


public class MyTool {
    
    public static final String filename = "CD.dat";
    public static final Scanner sc = new Scanner(System.in);
    
    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (check || number > max || number < min);
        return number;
    }
     public static int getInt(String welcome) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (check || number < 0);
        return number;
    }
    
    public static double getDouble(String welcome, int min, int max) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
            }
        } while (check || number > max || number < min);
        return number;
    }
        public static double getDouble(String welcome) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
            }
        } while (check || number < 0);
        return number;
    }
    
    
    public static String readNonBlank(String message) {
        String input = "";
        do {            
            System.out.print(message);
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }
    
    public static List<CDs> loadFromFile(String fName, List<CDs> list) {
        if(list.size()>0) list.clear();
        FileInputStream fi = null;
        ObjectInputStream fo = null;
        try {
            fi = new FileInputStream(fName);
            fo = new ObjectInputStream(fi);
            CDs obj;
            while (true) {
                obj = (CDs)(fo.readObject());
                list.add(obj);
            }
        } catch (Exception e) {
//            System.out.println(e);
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    
    //check if the file has the object saved in or not
    public static boolean hasObject(String filePath) {
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(filePath);
            ObjectInputStream fo = new ObjectInputStream(fi);
            if (fo.readObject() == null) {
                    check = false;
            }
            fo.close();
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }
    
    public static void saveToFile(CDs[] list, int numOfItem) {
        FileOutputStream fi = null;
        ObjectOutputStream fo = null;
        try {
            if (!hasObject(filename)) {
                fi = new FileOutputStream(filename);
                fo = new ObjectOutputStream(fi);
            } else {
                fi = new FileOutputStream(filename, true);
                fo = new ObjectOutputStream(fi) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }
            for (int i=0; i<numOfItem; i++) {
                fo.writeObject(list[i]);             
            }
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } 
    
} 