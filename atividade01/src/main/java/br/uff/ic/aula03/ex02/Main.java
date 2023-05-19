/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.aula03.ex02;


/**
 *
 * @author Pehper
 */
public class Main {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Joao", 333, 6.2f);
        
        System.out.println("O aluno " + aluno.getNome() + " de matricula " + aluno.getMat() + " possui cr " + aluno.getCr());
    }

}
