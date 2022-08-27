package com.mycompany.lista01;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pedro
 */
public class Exercicio05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int n, fat = 1;
        
        System.out.println("Digite um numero: ");
        n = teclado.nextInt();
        
        if(n < 0)
            System.out.println(-1);
        else {
            if(n == 1|| n == 0)
                System.out.println("n! = " + 1);
            else{
                for(int i = n; i > 0; i--)
                    fat *= i;
                System.out.println("n! = " + fat);
            }                
        }
    }
}
