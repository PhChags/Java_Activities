/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Porta {
    String cor;
    int estado;
    float altura;
    float largura;
    
    void estaAberta(int n){
        if (n != 0)
            System.out.print("aberta");
        else
            System.out.print("fechada");
    }
}
