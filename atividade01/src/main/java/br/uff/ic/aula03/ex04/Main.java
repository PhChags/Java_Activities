/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.aula03.ex04;

import java.util.Scanner;

/**
 *
 * @author Pehper
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Aluno aluno = new Aluno();
        Turma turma = new Turma(328);
        turma.setCurso("Programacao Orientada a Objetos");
        int resp;
        
        System.out.println("adicionar aluno           ==> 1");
        System.out.println("remover aluno             ==> 2");
        System.out.println("procurar aluno            ==> 3");
        System.out.println("mostrar alunos inscritos  ==> 4");
        System.out.println("parar programa            ==> 0");
        resp = teclado.nextInt();
        while(resp != 0){
            teclado.nextLine();
            int var;
            Aluno alu;
            switch(resp){
                case 1 -> {
                    System.out.println("Informe o nome do aluno: ");
                    aluno.setNome(teclado.nextLine());
                    
                    System.out.println("Informe a matricula do aluno: ");
                    aluno.setMat(teclado.nextInt());
                   
                    System.out.println("Informe o cr do aluno: ");
                    aluno.setCr(teclado.nextFloat());
                    
                    turma.adicionaAluno(aluno);
                }
                case 2 -> {
                    System.out.println("Informe a matricula do aluno que deseja remover: ");
                    var = teclado.nextInt();
                    alu = turma.removeAluno(var);
                    if (alu == null)
                        System.out.println("Aluno nao encontrado");
                    else
                        System.out.println("Aluno removido com sucesso!");
                }
                case 3 -> {
                    System.out.println("Informe a matricula do aluno que procura: ");
                    var = teclado.nextInt();
                    alu = turma.getAluno(var);
                    if (alu == null)
                        System.out.println("Aluno nao encontrado");
                    else
                        System.out.println("O aluno " + alu.getNome() + " estah inscrito na turma");
                }
                case 4 -> {
                    System.out.println();
                    turma.imprime();
                    System.out.println();
                }
                default -> System.out.println("Opcao invalida!");
            }
            System.out.println();
            System.out.println("adicionar aluno           ==> 1");
            System.out.println("remover aluno             ==> 2");
            System.out.println("procurar aluno            ==> 3");
            System.out.println("mostrar alunos inscritos  ==> 4");
            System.out.println("parar programa            ==> 0");
            resp = teclado.nextInt();
        }
        teclado.close();
    }
}
