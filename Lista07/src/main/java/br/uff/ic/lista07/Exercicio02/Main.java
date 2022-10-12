/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio02;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> lista = new ArrayList<>();
        lista.add(new Carro("alcool", 340.5, 8));
        lista.add(new Carro("eletrico", 165.4, 12));
        lista.add(new Construcao(3, false, 15, true));
        lista.add(new Construcao(5, true, 23, true));
        lista.add(new Bicicleta(20));
        lista.add(new Bicicleta(24));
        
        for (CarbonFootprint emissores: lista) {
            System.out.print(emissores);
            System.out.printf("Carbon Footprint: %.2f\n\n", emissores.getCarbonFootprint());
        }
    }
}
