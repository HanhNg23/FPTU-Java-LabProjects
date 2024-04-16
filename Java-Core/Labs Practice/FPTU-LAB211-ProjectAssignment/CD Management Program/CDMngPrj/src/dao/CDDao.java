
package dao;

import model.CDs;
import java.util.List;

public interface CDDao {
    
    void getNewCDs();
    List<CDs> getAllCDs();
    List<CDs> getCDByName(String name);
    CDs updateID(int ID);
    int SearchListID(CDs CD);
    boolean searchFileCDID(int ID);
    boolean searchFileCDName(String CDTitle);
    
    
    void addCD();
    void updateCD(CDs CD);
    void deleteCD(CDs CD);
    void saveFile();
    
}