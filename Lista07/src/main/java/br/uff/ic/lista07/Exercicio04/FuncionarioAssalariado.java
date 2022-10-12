/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio04;

/**
 *
 * @author Pedro
 */
public class FuncionarioAssalariado extends Funcionario{
    
    @Override
    protected void calculaSalarioTotal() {
        this.salarioTotal = this.salarioBaseSemanal;
    }
}
