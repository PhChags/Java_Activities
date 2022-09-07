/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio03;


        
/**
 *
 * @author Pedro
 */
public class Porta {
    int estado;
    String cor;
    
    void quantasPortasEstaoAbertas(Porta[] portas){
        int a = 0, f = 0;
        for (int i = 0; i < 3; i++){
            if (portas[i].estado != 0) {
               a++;
            } else {
               f++;
            }
        }
        System.out.print(" " + a + " portas abertas e " + f + " portas fecahadas");
    }
}
