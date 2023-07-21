/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.i;

/**
 *
 * @author anselmoantunesmontenegro
 */
public class Circle extends Shape {
    private Vector2d<Double> center;
    private double radius;
    
    public Circle(double cx, double cy, double radius){
        super();
        this.center = new Vector2d<>(cx,cy);
        this.radius = radius;
    }

    public Vector2d<Double> getCenter() {
        return center;
    }

    public void setCenter(Vector2d<Double> center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Circle{" + "id=" + id + ", center=" + center + ", radius=" + radius + '}';
    }
   
    
    @Override
    public void draw() {
        System.out.println(this.toString());
    }


    
    
}
