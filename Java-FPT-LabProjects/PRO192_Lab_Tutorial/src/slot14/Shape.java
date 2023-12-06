/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot14;

/**
 *
 * @author HOANGANH
 */
public abstract class Shape {
    private String colors = "RED";

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
    public abstract void draw(); //vi khong biet se ve cai gi nen chi tao ham draw ko có thân  
}

class Rectangle extends Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle with red color " +super.getColors());
    }  
}
class Circle extends Shape{

    @Override
    public void draw() {
        System.out.println("Circle with red color " +super.getColors());
    }  
}
class Triangle extends Shape{

    @Override
    public void draw() {
        System.out.println("Triagngle with red color " +super.getColors());
    }  
}

class ShapeUsing{
    public static void main(String[] args){
       Shape obj ;
       obj = new Rectangle();
       obj.draw();
       obj =  new Circle();
       obj.draw();
       obj =  new Triangle();
       obj.draw();
    }
}
