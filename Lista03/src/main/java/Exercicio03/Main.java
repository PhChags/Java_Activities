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
        int dia, mes, ano;
        String meS;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite o dia do mes: ");
        dia = teclado.nextInt();
        System.out.println("Digite o mes (em formato decimal):  ");
        mes = teclado.nextInt();
        System.out.println("Digite o ano: ");
        ano = teclado.nextInt();
        Data dataDDMMAAAA = new Data(dia, mes, ano);
        System.out.println();
        System.out.println(dataDDMMAAAA.data);
        
        System.out.println();
        System.out.println("Digite o dia: ");
        dia = teclado.nextInt();
        System.out.println("Digite o mes (por extenso, exemplo Janeiro): ");
        meS = teclado.next();
        System.out.println("Digite o ano: ");
        ano = teclado.nextInt();
        Data dataEscrito = new Data(dia, meS, ano);
        System.out.println();
        System.out.println(dataEscrito.data);
        
        System.out.println();
        System.out.println("Digite o numero do dia: ");
        dia = teclado.nextInt();
        System.out.println("Digite o ano: ");
        ano = teclado.nextInt();
        Data dataNumeroDias = new Data(dia, ano);
        System.out.println();
        System.out.println(dataNumeroDias.data);
    }
}