/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Pagamento {
    private double valorPago;
    private String data;
    private String tipoDePgmt;

    public Pagamento(double valorP, String dataP, String tipoDePagamento) {
        this.valorPago = valorP;
        this.data = dataP;
        this.tipoDePgmt = tipoDePagamento;
    }

    public String getTipoDePagamento() {
        return this.tipoDePgmt;
    }
}
