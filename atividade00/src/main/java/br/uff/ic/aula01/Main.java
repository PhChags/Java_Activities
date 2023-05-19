/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.aula01;

/**
 *
 * @author Pehper
 */
public class Main {

    public static void main(String[] args) {
        int a = 10, b = 20, soma = a + b, limite = 50;
        Aluno aluno = new Aluno();
        
        if (ehMaior(soma, limite)){
            System.out.println("A soma eh maior que " + limite);
        } else {
            System.out.println("A soma eh menor ou igual a " + limite);            
        }
        
        aluno.setNome("Jose");
        aluno.setMat(666);
        aluno.setCr(7.5f);
        
        System.out.println("O aluno " + aluno.getNome() + " de matricula " + aluno.getMat() + " possui cr " + aluno.getCr());
    }
    
    public static boolean ehMaior(int soma, int limite){
        return soma > limite;
    }
}
