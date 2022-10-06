/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio04;

/**
 *
 * @author Pedro
 */
public class Ataques {
    private String nome;
    private String tipo;
    private String tipoPower;
    private String efeito;
    private double precisao;
    private int power;
    private int pp;

    public Ataques(String nomeP, String tipoP, String tipopP, String efeitoP, double precisaoP, int forcaP, int ppP) {
        this.nome = nomeP;
        this.tipo = tipoP;
        this.tipoPower = tipopP;
        this.efeito = efeitoP;
        this.precisao = precisaoP;
        this.power = forcaP;
        this.pp = ppP;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public String getTipoPower() {
        return this.tipoPower;
    }
    
    public String getEfeito() {
        return this.efeito;
    }
    
    public double getPrecisao() {
        return this.precisao;
    }

    public int getPower() {
        return this.power;
    }

    public int getPP() {
        return this.pp;
    }

    public void setPP() {
        this.pp -= 1;
    }
}
