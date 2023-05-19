/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.atividade03;

/**
 *
 * @author Pehper
 */
public class Main {
    public static void main(String[] args) {
        java.util.Locale.setDefault (java.util.Locale.ENGLISH);
        TurmaArray turmaArray = EntradaConsole.leAlunos();
                
        turmaArray.imprime();
        
        Persistencia.salvarArquivoTexto("turma.txt", turmaArray);
        
        TurmaLista turmaLista = new TurmaLista(234);
           
        while (turmaArray.getNumAlunos()>0){
            Aluno a = turmaArray.removePrimeiro();
            System.out.println("Removendo da turma "+turmaArray.getCodigo()+" "+a.toString());
            System.out.println("Adicionado a turma "+turmaLista.getCodigo()+" "+a.toString());
            
            turmaLista.adicionaAluno(a);
        }
        
        turmaArray.imprime();
        turmaLista.imprime();
        
        TurmaArray turmaArrayArq = new TurmaArray(23);
        Persistencia.lerArquivoTexto("turma.txt", turmaArrayArq);
        turmaArrayArq.imprime();
       
    }
}
