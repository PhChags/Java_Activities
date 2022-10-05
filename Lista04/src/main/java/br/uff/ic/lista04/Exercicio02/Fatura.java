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
public class Fatura {
    private String nomeCliente;
    private String data;
    private double valor;
    private boolean estado;

    public Fatura(String nomeP, String dataP, double valorTotal) {
        this.nomeCliente = nomeP;
        this.data = dataP;
        this.valor = valorTotal;
    }

    public boolean estarPaga(ArrayList<Boleto> boletos, double valorFatura) {
        faturaPaga(boletos, valorFatura);
        return this.estado;
    }

    public void faturaPaga(ArrayList<Boleto> boletos, double valorFatura) {
        double soma = ProcessaodorDeBoletos.somaListaBoletos(boletos);
        if (soma >= valorFatura) {
            this.estado = true;
        } else{
            this.estado = false;
        }
    }

    public double getValor() {
        return this.valor;
    }
}
