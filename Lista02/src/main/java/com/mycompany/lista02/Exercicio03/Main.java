/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio03;

import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Main {
    
    public static void main(String[] args) {
        Random random = new Random();
        Casa casa = new Casa();
        Porta porta = new Porta();
        String[] cores = {"amarelo", "roxo","azul", "verde", "vermelho", "laranja", "branco", "preto", "marrom", "cinza"};
        
        casa.corCasa = cores[random.nextInt(10)];
        casa.corSala = cores[random.nextInt(10)];
        casa.corCozinha = cores[random.nextInt(10)];
        casa.corBanheiro = cores[random.nextInt(10)];
        casa.corQuarto = cores[random.nextInt(10)];
        for (int i = 0; i < 3; i++){
            Porta p = new Porta();
            p.estado = random.nextInt(2);
            p.cor = cores[random.nextInt(10)];
            casa.portas[i] = p;
        }        
        
        System.out.print("Na casa de cor " + casa.corCasa + ", de quarto " + casa.corQuarto + ", de sala " + casa.corSala + ", de cozinha " + casa.corCozinha + " e de banheiro " + casa.corBanheiro);
        System.out.print(" temos");
        porta.quantasPortasEstaoAbertas(casa.portas);
  
    }
}
