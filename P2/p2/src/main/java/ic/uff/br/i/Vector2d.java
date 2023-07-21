/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.i;

/**
 *
 * @author anselmoantunesmontenegro
 */
public class Vector2d<T extends Number> {
    private T x,y;
    
    public Vector2d(T x, T y){
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector2d{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
    
}
