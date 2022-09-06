/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ExercicioAula;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        
        pedido.cliente = "Paulo Victor";
        pedido.endereco = "Rua dos bobos, numero 0";
        pedido.data = "07/09/2012";
        pedido.formaDPgmt = "cartao";
        
        Produto prod = new Produto();
        
        prod.id = 1;
        prod.nome = "Leite Condensado";
        prod.preco = 7;
        prod.qntEstq = 73;
        prod.tipoProd = "Piracanjuba";
        pedido.qntdPedida = 2;
        
        pedido.adicionarItem(prod, pedido.qntdPedida);
    }
}
