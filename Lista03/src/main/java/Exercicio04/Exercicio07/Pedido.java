/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio07;

/**
 *
 * @author Pedro
 */
public final class Pedido {
    String cliente;
    String endereco;
    String formaDPgmt;
    Item itens[] = new Item[99];
    int qntTotal;
    int qntItens = 0;
    String data;
    String hora;
    float total = 0;

    public Pedido(String nomePar, String endPar, String formPagtPar){ 
        this.cliente = nomePar;
        this.endereco = endPar;
        this.formaDPgmt = formPagtPar;
    }
    public Pedido(String dataPar, String horaPar){
        this.data = dataPar;
        this.hora = horaPar;
    } 
    public void setItem(Item item) {
        //if (item.prod.atualizaEstoque(item.qntdPedida)){
            this.itens[this.qntItens] = item;
            this.total += this.itens[this.qntItens].valor;
            this.qntItens++;
            
        /*} else
            System.out.println("produto fora de estoque");*/
    }
    public float getTotalAPagar(){
        return this.total;
    }
}
