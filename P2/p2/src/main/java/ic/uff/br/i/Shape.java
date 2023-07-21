/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.i;

/**
 *
 * @author anselmoantunesmontenegro
 */
public abstract class Shape implements Drawable {
    public static int numShapes = 0;
    protected int id;
    
    public Shape(){
        id = numShapes++;
    }
    
}
