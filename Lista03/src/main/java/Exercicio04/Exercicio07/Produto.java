/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio07;

/**
 *
 * @author Pedro
 */
public class Produto {
    int id;
    String nome;
    float preco;
    int qntEstq = 10000;
    String tipoProd;
    
    public Produto(int idPar, String nomePar, float precoPar, String tipoPar){
        this.id = idPar;
        this.nome = nomePar;
        this.preco = precoPar;
        this.tipoProd = tipoPar;
    }
    /*public boolean atualizaEstoque(int qnt) {
        if (qntEstq >= qnt){
            qntEstq -= qnt;
            return true;
        } else
            return false;
    }*/
}