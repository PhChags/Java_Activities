/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.aula03.ex03;

import java.util.Scanner;

/**
 *
 * @author Pehper
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nome;
        int mat;
        float cr;
        
        
        System.out.println("Informe o nome do aluno: ");
        nome = teclado.nextLine();
        System.out.println("Informe a matricula do aluno: ");
        mat = teclado.nextInt();
        System.out.println("Informe o cr do aluno: ");
        cr = teclado.nextFloat();
        teclado.close();

        Aluno aluno = new Aluno(nome, mat, cr);
        
        System.out.println("O aluno " + aluno.getNome() + " de matricula " + aluno.getMat() + " possui cr " + aluno.getCr());
    }
}
