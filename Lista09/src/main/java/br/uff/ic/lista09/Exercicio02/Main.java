/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista09.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = TestaContaCorrente.criarContaCorrente("Gabriel Barbosa", 4000);
        if (conta != null) {
            TestaContaCorrente.setLimiteContaCorrente(conta, 3000);
            TestaContaCorrente.depositarContaCorrente(conta, -73);
            TestaContaCorrente.sacarContaCorrente(conta, 7000);
        }
    }
}
