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
public class Exercicio02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int R, S, T;
        
        System.out.println("Digite tres numeros: ");
        R = teclado.nextInt();
        S = teclado.nextInt();
        T = teclado.nextInt();
        
        if (R > S && R > T)
            System.out.println("O maior numero digitado foi o " + R);
        else {
            if(S > T)
                System.out.println("O maior numero digitado foi o " + S);
            else
                System.out.println("O maior numero digitado foi o " + T);
        }
    }
}
