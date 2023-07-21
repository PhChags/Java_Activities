/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.uff.ic.poo.producerconsumer;

/**
 *
 * @author anselmo
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        Product p = new Product();
        
        Producer prod = new Producer(p);
        Consumer cons = new Consumer(p);
        
        prod.start();
        cons.start();
        
        
        
    }
}
