/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio05;

/**
 *
 * @author Pedro
 */
public class ItemVenda implements Recebivel{
    private String nome;
    private int quantidade;
    private double preco;


    protected ItemVenda(String nomeP, int quantidadeP, double precoP) {
        this.nome = nomeP;
        this.quantidade = quantidadeP;
        this.preco = precoP;
    }

    @Override
    public double totalizarReceita() {
            return this.preco * this.quantidade;
    }
    
    @Override
    public String toString() {
        return "Produto Vendido { " +
                "nome = '" + nome + '\'' +
                ", quantidade = " + quantidade +
                ", preco = " + preco +
                " }";
    }
}
