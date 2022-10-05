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
public class Boleto {
    private String codigo;
    private String data;
    private double valor;
    private ArrayList<Boleto> listaDeBoletos = new ArrayList<>();

    public Boleto(){
    }
    
    public Boleto(String codigoP, String dataP, double valorP) {
        this.codigo = codigoP;
        this.data = dataP;
        this.valor = valorP;

    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public double getValor() {
        return this.valor;
    }
    
    public void addBoletos(Boleto boleto) {
        if (!(listaDeBoletos.contains(boleto.getCodigo()))) {
            listaDeBoletos.add(boleto);
        }
    }
    
    public ArrayList<Boleto> getListaDeBoletos() {
        return this.listaDeBoletos;
    }
}