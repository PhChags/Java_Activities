/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio08;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Celular cel;
        String resp;
        int variavel, nivel, capacidade;
        
        System.out.println("Qual o nivel de carga do celular? ");
        nivel = teclado.nextInt();
        System.out.println("Qual a capacidade da bateria do celular? ");
        capacidade = teclado.nextInt();
        cel = new Celular(nivel, capacidade);
        
        teclado.nextLine();
        System.out.println("Deseja enviar uma mensagem? S/N");
        resp = teclado.nextLine();
        if("S".equals(resp) || "s".equals(resp)){
            System.out.println("Quantas mensagens quer enviar? ");
            variavel = teclado.nextInt();
            cel.estado = cel.mandaMsgm(variavel, cel);
        }
       
        teclado.nextLine();
        System.out.println("Deseja fazer uma ligacao? S/N");
        resp = teclado.nextLine();
        if("S".equals(resp) || "s".equals(resp)){
            System.out.println("Quanto tempo vai durar a ligacao em minutos? ");
            variavel = teclado.nextInt();
            cel.estado = cel.ligacao(cel, variavel);
        }
    }
}