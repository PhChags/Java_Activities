/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio07;

/**
 *
 * @author Pedro
 */
public class Pedido {
    String cliente;
    String endereco;
    String formaDPgmt;
    Item itens[] = new Item[99];
    int qntTotal;
    int qntItens = 0;
    int qntdPedida;
    String data;

    void adicionarItem(Produto prod, int qnt) {
        if (prod.atualizaEstoque(qnt)){
            Item item = new Item();
            item.prod = prod;
            item.qntdPedida = qnt;
            itens[qntItens] = item;
            qntItens++;
        } else
            System.out.println("produto fora de estoque");
    }
}
