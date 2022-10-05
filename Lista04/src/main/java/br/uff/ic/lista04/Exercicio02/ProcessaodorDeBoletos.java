/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exercicio02;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class ProcessaodorDeBoletos {
        
    public static double somaListaBoletos(ArrayList<Boleto> boletos) {
        double soma = 0;
        
        for (int i = 0; i < boletos.size(); i++) 
            soma += boletos.get(i).getValor();
        
        return soma;
    }
    
}
