/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio03;

/**
 *
 * @author Pedro
 */
public class Juridica extends Pessoa{
    private String razaoSocial;
    private String cnpj;
    private double faturamento;
    
    public Juridica(String endereco, String razaoSocial, String cnpj, double faturamento) {
        super(endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.faturamento = faturamento;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public double getFaturamento() {
        return faturamento;
    }
}
