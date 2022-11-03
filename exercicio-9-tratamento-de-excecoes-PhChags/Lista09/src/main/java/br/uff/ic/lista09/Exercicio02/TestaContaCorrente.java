/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista09.Exercicio02;

/**
 *
 * @author Pedro
 */
public class TestaContaCorrente {
    public static ContaCorrente criarContaCorrente(String nome, float valor) {
        try {
            return new ContaCorrente(nome, valor);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void depositarContaCorrente(ContaCorrente a, float valor) {
        try {
            a.depositar(valor);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void sacarContaCorrente(ContaCorrente a, float valor) {
        try {
            a.sacar(valor);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void setLimiteContaCorrente(ContaCorrente a, float valor) {
        try {
            a.setValorLimite(valor);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
