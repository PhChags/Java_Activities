/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio02;

import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Main {
    
    public static void main(String[] args) {
        Random random = new Random();
        Porta porta = new Porta();
        String[] cores = {"amarelo", "roxo","azul", "verde", "vermelho", "laranja", "branco", "preto", "marrom", "cinza"};
        
        for (int i = 0; i < 5; i++){
            porta.estado = random.nextInt(2);
            porta.cor = cores[random.nextInt(10)];
            porta.largura = random.nextFloat((float) 0.8, (float) 1.8);
            porta.altura = random.nextFloat(2, 3);
        }
        
        System.out.print("A porta de cor " + porta.cor + " com " + porta.largura + "m de largura e " + porta.altura + "m de altura se encontra ");
        porta.estaAberta(porta.estado);
    }
}
