/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.aula03.ex01;

/**
 *
 * @author Pehper
 */
public class Main {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        
        aluno.setNome("Jose");
        aluno.setMat(666);
        aluno.setCr(7.5f);
        
        System.out.println("O aluno " + aluno.getNome() + " de matricula " + aluno.getMat() + " possui cr " + aluno.getCr());
    }

}
