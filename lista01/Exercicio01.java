/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lista01;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num, i, var, count = 0;
        
        System.out.println("Digite quantas variaveis irao ser lidas: ");
        num = teclado.nextInt();
        
        for (i = 0; i < num; i++){
            System.out.println("Digite um numero: ");
            var = teclado.nextInt();
            if (var < 0)
                count++;
        }
        
        System.out.println("Dos " + num + " numeros que voce digitou " + count + " eram negativos");
    }
}
