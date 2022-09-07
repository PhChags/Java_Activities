/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio06;

import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Baralho {
    Cartas[] KDnaipe = new Cartas[4];
    
    void mostraCartas(String[] EspecCards, Baralho baralho){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                if (baralho.KDnaipe[i].carta[j] > 1 && baralho.KDnaipe[i].carta[j] < 11)
                    System.out.println(baralho.KDnaipe[i].carta[j] + " de " + baralho.KDnaipe[i].naipe);
                else{
                    if (baralho.KDnaipe[i].carta[j] != 1)
                        System.out.println(EspecCards[baralho.KDnaipe[i].carta[j] - 10] + " de " + baralho.KDnaipe[i].naipe);
                    else
                        System.out.println(EspecCards[0] + " de " + baralho.KDnaipe[i].naipe);
                }
            }
            System.out.println();
        }
    }
    void embaralha(Baralho bah, String[] x){
        Random rand = new Random();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                int randomIndex = rand.nextInt(13);
                int temp = bah.KDnaipe[i].carta[randomIndex];
                bah.KDnaipe[i].carta[randomIndex] = bah.KDnaipe[i].carta[j];
                bah.KDnaipe[i].carta[j] = temp;
            }
            int randomIndex1 = rand.nextInt(4);
            String temp1 = bah.KDnaipe[randomIndex1].naipe;
            bah.KDnaipe[randomIndex1].naipe = bah.KDnaipe[i].naipe;
            bah.KDnaipe[i].naipe = temp1;
        }
        
        System.out.println("Baralho embaralhado: ");
        System.out.println();
        bah.mostraCartas(x, bah);
    }
   void MostrarEBuscarCarta(int x, String y, Baralho b){
       for(int i = 0; i < 4; i++){
           if(y.equals(b.KDnaipe[i].naipe)){
               System.out.println("A carta " + x + " de " + y + " se encontra na posicao " + (i+1) + b.KDnaipe[i].carta[x-1]);
           }
       }
   }
}