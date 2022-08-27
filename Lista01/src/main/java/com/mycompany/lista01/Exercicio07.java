/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Exercicio07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        float nota, pess = 0, ruim = 0, boa = 0, otima = 0; 
        int func = 0;
        
        System.out.println("Digite sua nota: ");
        nota = teclado.nextFloat();
        
        while(nota >= 0 && nota <= 100){
            func++;
            
            if(nota < 25.1)
                pess++;
            if(nota > 25 && nota < 50.1)
                ruim++;
            if(nota > 50 && nota < 75.1)
                boa++;
            if(nota > 75)
                otima++;
            
            System.out.println("Digite sua nota: ");
            nota = teclado.nextFloat();
        }
        
        System.out.println("Dos " + func + " funcionarios " + (pess / func) * 100 + "% acham a comida pessima, " + (ruim / func) * 100 + "% acham a comida ruim, " + (boa / func) * 100 + "% acham a comida boa e " + (otima / func) * 100 + "% acham a comida otima");
    }
}
