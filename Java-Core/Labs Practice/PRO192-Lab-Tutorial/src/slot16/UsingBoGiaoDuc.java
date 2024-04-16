
package slot16;


public class UsingBoGiaoDuc {
    public static void main(String args[]){
    BoGiaoDuc obj[] = new BoGiaoDuc[3]; // cái này không phải tạo instance mà là tạo mảng
    obj[0] = new FPTUni();
    obj[1] = new BKUni();
    obj[2] = new TDTUni();
    for(BoGiaoDuc boGiaoDuc : obj){ // giống for(int i : tên array)
        boGiaoDuc.show();   
     }
    }
}        
