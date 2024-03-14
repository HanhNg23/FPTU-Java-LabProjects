package sample.dto;

/* Interface for a group of objects
 */

/**
 *
 * @author Hoa Doan
 */
public interface I_List {
  // Find the position of element which has code equal parameter coe
  int find(String id);
  // add new element( input from scanner) to I_List
  void add(); 
  // Input the code wanna remove
  void remove();
  // input the code want to update, after that update other information--> use set method
  void update();
  // sort list use Collections.sort(this, new Comparator<Clock>()..., sort based price or make
  void sort();
  // Find the elements by index or by name
  void search();
  // show detail of each element of List
  void output();
}
