/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exerecicio03;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Menu menu = new Menu();
        Agenda agenda = new Agenda();
        int op;
        do {
            menu.mostrarOpcoes();
            op = Integer.parseInt(teclado.next());
            menu.escolher(op, agenda);
        } while (op > 0);
    }
}
