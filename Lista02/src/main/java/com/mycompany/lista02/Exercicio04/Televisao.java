/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio04;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Televisao {
    String estado;
    int volume;
    int canal;
    String silencio;
    
    public boolean onOff(int sinal){
        if (sinal != 0)
            return true;
        else
            return false;
    }
    public boolean silenceMode(int sinal){
        if (sinal == 0)
            return false;
        else
            return true;
    }
    public int qualVolume(int sinal, int x){
        if (sinal != 0)
            return ++x;
        else 
            return --x;
    }
    public int qualCanal(int sinal, int x){
        Scanner teclado = new Scanner(System.in);
        if (sinal == 0){
            return teclado.nextInt();
        } else {
            if (sinal == 1)
                return ++x;
            else
                return --x;
        }
    }
}
