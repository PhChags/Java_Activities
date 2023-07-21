/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.poo.producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anselmo
 */
public class Product {
    private int value;
    private boolean writeable = true;
    
    public Product(){value = 0;};

    public synchronized int getValue() {
       while (writeable){
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       System.out.println("Consumed product " + value);
       writeable = true;
       notify();
       return value;
    }

    public synchronized void setValue(int value) {
        while (!writeable){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.value = value;
        System.out.println("Produced product " + value);
        writeable = false;
        notify();
       
    }
}
