/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.atividade02;

import java.util.Scanner;

/**
 *
 * @author Pehper
 */
public class Main {
    
    public static void main(String[] args) {
        
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
        
        turmaArray.imprime();
             
        TurmaLista turmaLista = new TurmaLista(234);
           
        while (turmaArray.getNumAlunos() > 0){
            a = turmaArray.removePrimeiro();
            System.out.println("Removendo da turma "+turmaArray.getCodigo()+" "+a.toString());
            System.out.println("Adicionado a turma "+turmaLista.getCodigo()+" "+a.toString());
            
            turmaLista.adicionaAluno(a);
        }
        
        turmaArray.imprime();
        turmaLista.imprime();
        
        teclado.close();
    }
}
