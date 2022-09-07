/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio01;

import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Main {
    
    public static void main(String[] args) {
        Pessoa x = new Pessoa();
        Random numero = new Random();
        
        x.nome = "Paulo";
        x.idade = 20;
        
        x.idade += numero.nextInt(76);
            
        System.out.println(x.nome + " tem " + x.idade + " anos");
    }
}
