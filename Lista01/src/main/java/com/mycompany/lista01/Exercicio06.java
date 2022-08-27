/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01;

/**
 *
 * @author Pedro
 */
public class Exercicio06 {
    public static void main(String[] args) {
        int var = 0, term = 1, soma;
        
        System.out.print(" " + var + " " + term);
        
        while (term < 100){
            soma = var + term;
            var = term;
            term = soma;
            if (term < 100)
                System.out.print(" " + term);
        }
    }
}
