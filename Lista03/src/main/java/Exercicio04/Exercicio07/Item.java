/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio07;

/**
 *
 * @author Pedro
 */
public final class Item {
    Produto prod;
    int qntdPedida;
    float valor;
    
   public Item(Produto prodPar, int qntdPedidaPar){
       this.prod = prodPar;
       this.qntdPedida = qntdPedidaPar;
       this.valorTotal();
   }
   public void valorTotal(){
       this.valor = this.prod.preco * this.qntdPedida;
   }
}