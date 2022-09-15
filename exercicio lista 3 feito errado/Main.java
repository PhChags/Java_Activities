/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio03;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        int dia, mes, ano, resp;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Que dia eh hoje? ");
        dia = teclado.nextInt();
        System.out.println("Em que mes estamos? ");
        mes = teclado.nextInt();
        System.out.println("Em que ano estamos? ");
        ano = teclado.nextInt();
        Data data = new Data(dia, mes, ano);
        
        System.out.println("Quer imprimir a data em qual formato? (1, 2 ou 3)");
        resp = teclado.nextInt();
        if(resp == 1)
            data.imprimeFormato1();
        if(resp == 2)
            data.imprimeFormato2();
        if(resp == 3)
            data.imprimeFormato3();
    }
}