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
public class Consumer extends Thread {
    public static final int MAX_PRODUCTS = 10;
    public static final long MAX_SLEEP_TIME = 5000;
    
    private Product p;
    
    public Consumer(Product p){
        this.p = p;
    }
   
    @Override
    public void run() {
        int i = 0;
        int value;
        int sum = 0;
        do{
            value = p.getValue();
            System.out.println("Consumed product " + value);
            sum += value;
            i++;
            try {
                this.sleep((long)Math.random()*MAX_SLEEP_TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(i<MAX_PRODUCTS);
        
        System.out.println("Consumed a total of " + sum);
        
    }
}
