/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio06;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
       Baralho baralho = new Baralho();
       String[] naipes = {"Ouro", "Copa", "Espada", "Paus"};
       String[] EspecCards = {"As", "Valete", "Rainha", "Rei"};
       Scanner teclado = new Scanner(System.in);
       String resp, resp2;
       int resp1;
       for (int i = 0; i < 4; i++){
            Cartas card = new Cartas();
            for(int j = 0; j < 13; j++){
                card.naipe = naipes[i];
                card.carta[j] = j+1;
            }
            baralho.KDnaipe[i] = card;
        }
       
       System.out.println("Deseja mostrar o baralho agora? S/N");
       System.out.println();
       resp = teclado.next();
       if ("S".equals(resp) || "s".equals(resp))
            baralho.mostraCartas(EspecCards, baralho);
       
       System.out.println("Deseja mostrar uma carta especifica? S/N");
       System.out.println();
       resp = teclado.next();
       if ("S".equals(resp) || "s".equals(resp)){
            System.out.println("Qual a carta? ");
            resp1 = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Qual o naipe? ");
            resp2 = teclado.nextLine();
            teclado.nextLine();
            System.out.println();
            baralho.MostrarEBuscarCarta(resp1, resp2, baralho);
        }

       System.out.println("Deseja embaralhar o baralho? S/N");
       System.out.println();
       resp = teclado.next();
       if ("S".equals(resp) || "s".equals(resp))
            baralho.embaralha(baralho, EspecCards);
    }
}