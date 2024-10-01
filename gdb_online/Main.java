import java.util.*;

public class Main{
    public static void main(String []args){  
        ResizableCircle c = new ResizableCircle(10);
        System.out.println(
            String.format(
                "%s, perimeter = %.03f, area = %.03f", 
                c.toString(), c.getPerimeter(), c.getArea()
            )
        );
        
        System.out.println("After resize 50%");
        c.resize(50);
        System.out.println(
            String.format(
                "%s, perimeter = %.03f, area = %.03f", 
                c.toString(), c.getPerimeter(), c.getArea()
            )
        );
    }
    
}

interface GeometricObject{
    public double getPerimeter();
    public double getArea();
}

interface Resizable{
    public void resize(int percent);
}

class Circle implements GeometricObject{
    protected double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public String toString(){
        return String.format(
            "Circle[radius = %.03f]", radius);
    }

    public double getPerimeter(){
        return 2*(3.14)*radius;
    }
    public double getArea(){
        return (3.14)*radius*radius;
    }
}

class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius){
        super(radius);
    }

    public String toString(){
        return String.format(
            "ResizableCircle[%s]", super.toString());
    }

    public void resize(int percent){
        radius *= (percent/100.0);  
    }
}
