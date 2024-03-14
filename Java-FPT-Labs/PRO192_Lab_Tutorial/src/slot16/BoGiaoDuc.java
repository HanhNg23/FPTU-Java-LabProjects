
package slot16;
public abstract class BoGiaoDuc {
    private String name;
    public abstract void teachBasic();
    public abstract void teachAdvance();
    public abstract void teachSpecial();
    public void show(){
        System.out.println("This " + this.getName()); // nó sẽ lấy hàm getName của con
        this.teachBasic();
        this.teachAdvance();
        this.teachSpecial();
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
