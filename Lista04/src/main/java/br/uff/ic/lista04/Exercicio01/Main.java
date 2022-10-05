/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.lista04.Exercicio01;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ListaDeCompras lista = new ListaDeCompras();
        String item;

        do{
            System.out.println("Digite o nome do item que deseja adicionar na lista de compras: \t[DIGITE FIM PARA TERMINAR O PROGRAMA]");
            item = teclado.nextLine();
            lista.add(item);
        } 
        while (!"fim".equals(item.toLowerCase()));
        
        lista.imprimeLista();
    }
}
