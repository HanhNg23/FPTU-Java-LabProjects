package sample.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sample.dto.I_List;
import sample.dto.Product;
import sample.utils.Utils;

public class ProductList extends ArrayList<Product> implements I_List {

    Scanner sc = new Scanner(System.in);

    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Product(code));
        return index;
    }

    @Override
    public void add() {
        boolean check = true;
        String code = "";
        do {
            code = Utils.getString("Input your code: ");
            int index = this.find(code);
            if (index == -1) {
                check = false;
            }
        } while (check);
        String name = Utils.getString("Input name: ");
        int size = Utils.getInt("Input size: ", Utils.INT_MIN, Utils.INT_MAX);
        int price = Utils.getInt("Input price: ", Utils.INT_MIN, Utils.INT_MAX);
        this.add(new Product(code, name, size, price));
    }

    @Override
    public void remove() {
        String code = Utils.getString("Input code to be removed: ");
        boolean confirmRemove = Utils.confirmYesNo("Do you want to remove(Y/N)?");
        if (confirmRemove) {
            this.remove(this.find(code));
        }
    }

    @Override
    public void update() {
        String code = Utils.getString("Input code to be updated: ");
        int index = this.find(code);
        if (index < 0 || index > this.size()) {
            return;
        }
        String newName = Utils.getString("Input update name: ", this.get(index).getName());
        this.get(index).setName(newName);
        int newPrice = Utils.getInt("Input update price: ", Utils.INT_MIN, Utils.INT_MAX, this.get(index).getPrice());
        this.get(index).setPrice(newPrice);
        int newSize = Utils.getInt("Input update size: ", Utils.INT_MIN, Utils.INT_MAX, this.get(index).getSize());
        this.get(index).setSize(newSize);
    }

    @Override
    public void sort() {
        Collections.sort(this);
    }

    @Override
    public void output() {
        System.out.println(this.toString());
    }

}