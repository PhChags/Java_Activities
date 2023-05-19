/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.atividade03;

/**
 *
 * @author Pehper
 */
public interface Turmas {
    public void adicionaAluno(Aluno a);
    public Aluno removePrimeiro();
    public Aluno removeAluno(String nome);
}
