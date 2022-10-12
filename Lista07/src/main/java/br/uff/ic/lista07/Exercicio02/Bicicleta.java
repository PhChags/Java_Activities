/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Bicicleta implements CarbonFootprint{
    private double aro;
    
    public Bicicleta(double aroP){
        this.aro = aroP;
    }
    
    @Override
    public double getCarbonFootprint(){
        return aro * 2;
    }
    
    @Override
    public String toString(){
        return "Bicicleta {" +
                "aro = " +
                String.format("%.2f", aro) +
                "} ";
    }
}
