/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.supermercado.mercado;

/**
 *
 * @author Pedro
 */
public final class Produto {
    int id;
    private String nome;
    float preco;
    int qntEstq;
    String tipoProd;
    
    public Produto(String nomePar){
        this.nome = nomePar;
    }
    public void setNome(String nomePar){
        this.nome = nomePar;
        this.getNome();
    }
    public Produto(String nomePar, float precoPar){
        this.nome = nomePar;
        this.preco = precoPar;
    }
    public Produto(){}
    public Produto(int qntEstqPar){
        this.qntEstq= qntEstqPar;
    }
    public Produto(String nomePar, float precoPar, String tipoProdPar, int qntEstqPar){
        this(nomePar, precoPar);
        this.qntEstq = qntEstqPar;
        this.tipoProd = tipoProdPar;
        this.imprimir();
    }
    public String getNome(){
        return this.nome;
    }
    public void imprimir(){
        System.out.println("Nome: " + this.nome + " Preco: R$" + this.preco + " Tipo: " + this.tipoProd + " Quantidade em estoque: " + this.qntEstq);
    }
    public boolean atualizaEstoque(int qnt) {
        if (qntEstq >= qnt){
            qntEstq -= qnt;
            return true;
        } else
            return false;
    }
}
