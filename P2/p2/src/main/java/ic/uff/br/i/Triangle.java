/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.i;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anselmoantunesmontenegro
 */
public class Triangle extends Shape {
    private Vector2d<Double>[] vertices;
    public Triangle(double x0, double y0, double x1, double y1, double x2, double y2) {
        
        super();
        vertices = (Vector2d<Double>[])Array.newInstance(Vector2d.class, 3);
        vertices[0] = new Vector2d<Double>(x0,y0);
        vertices[1] = new Vector2d<Double>(x1,y1);
        vertices[2] = new Vector2d<Double>(x2,y2);
    }

    public Vector2d<Double>[] getVertices() {
        return vertices;
    }

    public void setVertices(Vector2d<Double>[] vertices) {
        this.vertices = vertices;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String s = "{";
        
        s += vertices[0].toString() + ",";
        s += vertices[1].toString() + ",";
        s += vertices[2].toString() + "}";
        
        return "Triangle{" + "id=" + id +  ", vertices=" + s + '}';
    }

    
    @Override
    public void draw() {
        System.out.println(this.toString());
    }
    
}
