/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ic.uff.br.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author anselmoantunesmontenegro
 */
public class Drawer {
    
    /*public static void draw(Collection<? extends Shape> sc){
        for (Iterator<? extends Shape> si = sc.iterator();si.hasNext();){
            si.next().draw();
        }
    } */   
        
    public static <T extends Shape> void draw(Collection<T> sc){
        for (Iterator<T> si = sc.iterator();si.hasNext();){
            si.next().draw();
        }
    }    
        
    
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Triangle(0.0,0.0,1.0,0.0,1.0,1.0));
        shapes.add(new Circle(0.0,0.0,3.0));
        shapes.add(new Circle(10.0,10.0,5.0));
        
        List<Circle> circles = new ArrayList<Circle>();
        circles.add(new Circle(5.0,2.0,8.0));
        circles.add(new Circle(10.0,10.0,500.0));
        circles.add(new Circle(10.0,-10.0,50.0));
        
        List<Triangle> triangles = new ArrayList<Triangle>();
        triangles.add(new Triangle(2.0,0.0,1.0,0.0,1.0,1.0));
        triangles.add(new Triangle(0.0,3.0,1.0,2.0,1.0,-1.0));
        triangles.add(new Triangle(3.0,3.0,1.0,0.0,8.0,1.0));
        
        System.out.println("Shapes collection...");
        draw(shapes);
        System.out.println("Circles collection...");
        draw(circles);
        System.out.println("Triangles collection...");
        draw(triangles);
        
        
    }
}
