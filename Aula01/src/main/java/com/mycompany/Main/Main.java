/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.Main;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Scanner teclado = new Scanner(System.in);
        
        int idade;
        String nome;
        
        System.out.println("Digite seu nome: ");
        nome = teclado.nextLine();
                
        System.out.println("Digite sua idade: ");
        idade = teclado.nextInt();
        
        System.out.println("Seu nome eh " + nome + " e voce tem " + idade + " anos");
    }
}
