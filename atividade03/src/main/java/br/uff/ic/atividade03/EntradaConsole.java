/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.atividade03;

import java.util.Scanner;

/**
 *
 * @author Pehper
 */
public class EntradaConsole {
    
    public EntradaConsole(){};
    
    public static TurmaArray leAlunos() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Informe o numero de alunos: ");
        int totalAlunos = teclado.nextInt();
        
        TurmaArray turmaArray = new TurmaArray(23);
        Aluno a;  
        for (int i = 0; i < totalAlunos; i++){
            System.out.println("Digite os dados do aluno");
            teclado.nextLine();
            String nome = teclado.nextLine();
            int mat = teclado.nextInt();
            float cr = teclado.nextFloat();
            a = new Aluno();
            a.setNome(nome);
            a.setMat(mat);
            a.setCr(cr);
            turmaArray.adicionaAluno(a);    
        }
        teclado.close();
        return turmaArray;
    }
}