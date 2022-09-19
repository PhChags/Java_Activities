/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio05;

/**
 *
 * @author Pedro
 */
public class Agenda {
    Contato contatos[] = new Contato[99];
    private int qntContatos = 0;
    
    public void adicionaContatos(Contato cont){
        if (this.qntContatos < 100){
            this.contatos[qntContatos] =  cont;
            this.qntContatos++;
        } else
            System.out.println("Agenda cheia");
    }
    public void removeUltimo(){
        if (this.qntContatos > 0){
            this.contatos[qntContatos] =  null;
            this.qntContatos--;
        } else
            System.out.println("Agenda vazia, nao hah nada para remover");
    }
    public void listaAgenda(Contato[] contat){
        for (int i = 0; i < this.qntContatos; i++){
            System.out.println(contat[i].nome + " " + contat[i].numero);
        }
    }
}