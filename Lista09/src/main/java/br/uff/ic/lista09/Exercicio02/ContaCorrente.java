/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista09.Exercicio02;

/**
 *
 * @author Pedro
 */
public class ContaCorrente {
    private String nome;
    private float limite;
    private float saldo;
    private float valorLimite;

    protected ContaCorrente(String nome, float primeiroDeposito) {
        this.nome = nome;
        this.limite = valorLimite;
        depositar(primeiroDeposito);
    }

    public void sacar(float valor) {
        if (saldo < valor) {
            throw new IllegalArgumentException("Nao hah saldo suficiente para o saque!");
        } else {
            System.out.println("Saque de R$" + valor + "efetuado com sucesso");
        }

    }

    public void depositar(float valor){
        if (valor < 0) {
            throw new IllegalArgumentException("Nao eh possivel depositar um valor negativo. ");
        } else if (valor == 0) {
            throw new IllegalArgumentException("Nao eh possivel depositar 0. Tente novamente");
        } else {
            System.out.println("Depositando R$" + valor);
            this.saldo += valor;
            System.out.println("Deposito Concluido");
        }
    }

    public void setValorLimite(float valor){
        if (valor <= 0) {
            throw new IllegalArgumentException("O limite nao pode ser 0 ou menor que 0");
        } else {
            this.valorLimite = valor;
        }
    }
}
