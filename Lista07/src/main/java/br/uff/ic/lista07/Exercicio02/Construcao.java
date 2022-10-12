/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Construcao implements CarbonFootprint{
    private int numPessoas;
    private boolean energiaRenovavel;
    private int numLampadas;
    private boolean arCondicionado;
    
    public Construcao(int numPessoasP, boolean energiaRenovavelP, int numLampadasP, boolean arCondicionadoP) {
        this.numPessoas = numPessoasP;
        this.energiaRenovavel = energiaRenovavelP;
        this.numLampadas = numLampadasP;
        this.arCondicionado = arCondicionadoP;
    }
    
    public int getNumPessoas() {
        return this.numPessoas;
    }

    public boolean getEnergiaRenovavel() {
        return this.energiaRenovavel;
    }
    
    public int getNumeroLampadas(){
        return this.numLampadas;
    }
    
    public boolean getArCondicionado(){
        return this.arCondicionado;
    }
    
    @Override
    public double getCarbonFootprint(){
        double energia = 1.8;
        if (energiaRenovavel) {
            energia = 0.5;
        }
        if (arCondicionado) {
            energia *= 2;
        }
        return numPessoas*numLampadas*energia;
    }
    
    @Override
    public String toString(){
        return "Construcao{" +
                "numPessoas =" + numPessoas +
                ", energiaRenovavel =" + energiaRenovavel +
                ", numLampadas =" + numLampadas +
                ", arCondicionado =" + arCondicionado +
                "} ";
    }
}
