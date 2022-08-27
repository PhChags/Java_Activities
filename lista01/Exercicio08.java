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
public class Exercicio08 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int n, soma1 = 0, soma2 = 0, soma3 = 0;
        
        System.out.println("Informe a ordem da matriz: ");
        n = teclado.nextInt();
        
        int[][] matriz = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.println("Informe o elemento [" + i + "][" + j + "] da matriz: ");
                matriz[i][j] = teclado.nextInt();
            }
        }
        
        System.out.println();
        System.out.println("A matriz: ");
        for(int i = 0; i < n; i++){
            System.out.print("[");
            for(int j = 0; j < n; j++){
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
        
        for(int i = 0; i < n; i++){
            soma1 += matriz[i][i];
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                soma2 += matriz[i][j];
                if(n - 1 == i + j){
                    soma3 += matriz[i][j];
                }
            }
            if(soma2 != soma1){
                System.out.println();
                System.out.println("Nao eh um quadrado magico");
                break;
            } else {
                soma2 = 0;
            }
        }
        if(soma2 == 0){
            if(soma3 != soma1){
                System.out.println();
                System.out.println("Nao eh um quadrado magico");
            } else {
                System.out.println();
                System.out.println("Eh um quadrado magico");
            }
        }
    }
}