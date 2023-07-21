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
public class Producer extends Thread {
    public static final int MAX_PRODUCTS = 10;
    public static final long MAX_SLEEP_TIME = 5000;
    
    private Product p;
    public Producer(Product p){
        this.p = p;
    }
   
    @Override
    public void run() {
        for (int i=1;i<=MAX_PRODUCTS;i++){
            p.setValue(i);
            System.out.println("Produced product " + i);
            try {
                this.sleep((long)Math.random()*MAX_SLEEP_TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Finished producing");
    }
}
