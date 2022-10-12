/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio04;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class FuncionarioComissado extends Funcionario implements Comissao{
    private ArrayList<Double> produtosVendidos;

    protected void setProdutosVendidos(ArrayList<Double> produtosVendidos) {
            this.produtosVendidos = produtosVendidos;
    }

    @Override
    protected void calculaSalarioTotal() {
            this.salarioTotal = porcentagemSobreVendas();
    }

    @Override
    public double porcentagemSobreVendas() {
            double sum = somaProdutosVendidos();
            return sum * PORCENTAGEM_COMISSAO ;
    }

    public double somaProdutosVendidos() {
            double sum = 0;
            for (double produtosPreco: produtosVendidos) {
                    sum += produtosPreco;
            }
            return sum;
    }
}
