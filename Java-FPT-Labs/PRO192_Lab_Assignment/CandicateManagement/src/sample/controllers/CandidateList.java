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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import sample.dto.I_List;
import sample.utils.Utils;
import sample.dto.Candidate;
import sample.dto.Experience;
import sample.dto.Fresher;
import sample.dto.Intern;

public class CandidateList extends ArrayList<Candidate> implements I_List {

    Scanner sc = new Scanner(System.in);

    public void writeObjectToFile(String path) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for (int i = 0; i < this.size(); i++) {
                oos.writeObject(this.get(i));
            }
        } catch (Exception e) {
            System.out.println("Co loi roi kia" + e.toString());
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    public void readObjectFromFile(String path) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Candidate> listProduct = new ArrayList<>();
        try {
            Candidate candinate = new Experience();
            while (fis.available() > 0) {
                Object obj = ois.readObject();
                if (obj instanceof Experience) {
                    candinate = (Experience) obj;
                } else if (obj instanceof Fresher) {
                    candinate = (Fresher) obj;
                } else if (obj instanceof Intern) {
                    candinate = (Intern) obj;
                }
            }

            this.add(candinate);
            System.out.println(listProduct.toString());
        } catch (Exception e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }

    @Override
    public int find(String id) {
        int index = -1;
        index = this.indexOf(new Candidate(id));
        return index;
    }

    @Override
    public void add() {
        boolean check = true;
        String id = "";
        System.out.println("1. Add Experience");
        System.out.println("2. Add Fresher");
        System.out.println("3. Add Fresher");
        int typeCandidate = Utils.getInt(id, 1, 3);
        do {
            id = Utils.getString("Input your id: ");
            int index = this.find(id);
            if (index == -1) {
                check = false;
            }
        } while (check);
        Candidate obj = null;
        switch (typeCandidate) {
            case 1:
                obj = new Experience(id);
                obj.createCandidate();
                break;
            case 2:
                obj = new Fresher(id);
                obj.createCandidate();
                break;
            case 3:
                obj = new Intern(id);
                obj.createCandidate();
                break;
        }
        obj.displayCandidate();
        this.add(obj);

    }

    @Override
    public void remove() {
        String id = Utils.getString("Input ID to removed: ");
        boolean confirmRemove = Utils.confirmYesNo("Do you want to remove(Y/N) ?");
        if (confirmRemove) {
            this.remove(this.find(id));
        }
    }

    @Override
    public void update() {
        String id = Utils.getString("Input ID to updated: ");
        int index = this.find(id);
        if (index < 0 || index > this.size()) {
            System.out.println("Object at " + id + " is not created yet");
            return;
        }
        Candidate candi = new Candidate();
        this.get(index).updateCandidate();

    }

    @Override
    public void sort() {
        Collections.sort(this);
    }

    @Override
    public void output() { //show all elements
        for (int i = 0; i < this.size(); i++) {
            this.get(i).displayCandidate();
        }
    }

    @Override
    public void search() {
        boolean check = true;
        do {
            String id = Utils.getString("Input ID to search: ");
            int index = this.find(id);
            if (index == -1) {
                System.out.println("Can't find information at index " + id);
                check = false;
            } else {
                this.get(index).displayCandidate();
                check = false;
            }
        } while (check);

    }

}
