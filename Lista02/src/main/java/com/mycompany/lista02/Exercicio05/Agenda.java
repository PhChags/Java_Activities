/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista02.Exercicio05;

/**
 *
 * @author Pedro
 */
public class Agenda {
    Contato contatos[] = new Contato[99];
    int qntContatos = -1;
    
    void adicionaContatos(Contato cont){
        if (qntContatos < 101){
            contatos[qntContatos + 1] =  cont;
            qntContatos++;
        } else
            System.out.println("Agenda cheia");
    }
    void removeUltimo(){
        if (qntContatos > 0){
            contatos[qntContatos] =  null;
            qntContatos--;
        } else
            System.out.println("Agenda vazia, nao hah nada para remover");
    }
    void listaAgenda(Contato[] contat){
        for (int i = 0; i <= qntContatos; i++){
            System.out.println(contat[i].nome + " " + contat[i].numero);
        }
    }
}
