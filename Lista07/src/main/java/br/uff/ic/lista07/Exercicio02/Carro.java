/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Carro implements CarbonFootprint{
    private String combustivel;
    private double cilindrada;
    private double litrosPorKM;
    
    public Carro(String combustivelP, double cilindradaP, double litrosPorKMP){
        this.combustivel = combustivelP;
        this.cilindrada = cilindradaP;
        this.litrosPorKM = litrosPorKMP;
    }
    
    @Override
    public double getCarbonFootprint(){
        if (combustivel.equalsIgnoreCase("alcool")) {
            return cilindrada*5 * litrosPorKM;
        } else if (combustivel.equalsIgnoreCase("gasolina")) {
            return cilindrada*5 * litrosPorKM * 1.5;
        }
        return cilindrada*5 * litrosPorKM * 0.4;
    }
    
    @Override
    public String toString(){
        return "Carro {" + 
                "combustivel = '" + combustivel + '\'' +
                ", cilindrada = " + cilindrada +
                ", KM/L = " + litrosPorKM + 
                "} ";
    }
}
