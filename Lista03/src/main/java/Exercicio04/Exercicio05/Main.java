/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio05;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String resp, nome, numero;
        int qnt;
        
        
        System.out.println("Quer adicionar algum contato S/N: ");
        resp = teclado.next();
        if("S".equals(resp) || "s".equals(resp)){
            System.out.println("Qantos? ");
            qnt = teclado.nextInt();
            for (int i = 0; i < qnt; i++){
                teclado.nextLine();
                
                System.out.println("Digite o nome do contato: ");
                nome = teclado.nextLine();
                
                System.out.println("Digite o numero do contato: ");
                numero = teclado.nextLine();
                
                Contato contat = new Contato(nome, numero);
                agenda.adicionaContatos(contat);
            } 
        }else
            System.out.println("OK");
            
        System.out.println("Quer remover algum contato S/N: ");
        resp = teclado.next();
        if("S".equals(resp) || "s".equals(resp)){
            System.out.println("Qantos? ");
            qnt = teclado.nextInt();
            for (int i = 0; i < qnt; i++){
                agenda.removeUltimo();
            } 
        }else
            System.out.println("OK");
        
        System.out.println("Quer imprimir a agenda S/N: ");
        resp = teclado.next();
        if("S".equals(resp) || "s".equals(resp))
            agenda.listaAgenda(agenda.contatos);
        else
            System.out.println("OK");
    }
}
