/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula02;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Aluno bomAluno = new Aluno();
        
        bomAluno.nome = "Gabriel";
        bomAluno.matricula = 120;
        bomAluno.CR = 7;
        
        Aluno mauAluno = new Aluno();
        
        mauAluno.nome = "Hugo";
        mauAluno.matricula = 220;
        mauAluno.CR = 3;
        
        System.out.println(bomAluno.nome);
        System.out.println(bomAluno.matricula);
        System.out.println(bomAluno.CR);
        System.out.println(mauAluno.nome);
        System.out.println(mauAluno.matricula);
        System.out.println(mauAluno.CR);
    }
}
