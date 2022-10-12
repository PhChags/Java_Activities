/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio04;

/**
 *
 * @author Pedro
 */
public abstract class Funcionario {
    protected double salarioTotal;
    protected double salarioBaseSemanal;

    protected double getSalarioTotal() {
            return this.salarioTotal;
    }

    protected abstract void calculaSalarioTotal();

}
