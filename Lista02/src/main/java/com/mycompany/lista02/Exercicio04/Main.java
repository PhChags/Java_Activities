/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio04;

import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Televisao televisao = new Televisao();
        Random controle = new Random();
        
        if (televisao.onOff(controle.nextInt(2)))
            televisao.estado = "Ligada";
        else
            televisao.estado = "Desligada";
        if (televisao.silenceMode(controle.nextInt(2)))
            televisao.silencio = "Modo Silencio";
        else
            televisao.silencio = "Modo Padrao";
  
        televisao.volume = televisao.qualVolume(controle.nextInt(2), controle.nextInt(11));
        televisao.canal = televisao.qualCanal(controle.nextInt(-2, 2), controle.nextInt(100));
        
        if ("Ligada".equals(televisao.estado)) {
            System.out.print("A televisao estah " + televisao.estado + " no " + televisao.silencio + " no canal " + televisao.canal);
            if ("Modo Padrao".equals(televisao.silencio))
                System.out.print(" com volume " + televisao.volume);
        } else {
            System.out.println("A Televisao estah " + televisao.estado);
        }
    }
}
