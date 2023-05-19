/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.atividade03;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Pehper
 */
public class Persistencia {
    public static void salvarArquivoTexto(String nomeArq, TurmaArray turmaArray){
        FileWriter fileW;
        PrintWriter printW;
        try {
            fileW = new FileWriter(nomeArq);
            printW = new PrintWriter(fileW);

            TurmaArray.TurmaIterator it = turmaArray.getIterator();
            
            while (it.hasNext()){
                Aluno aluno = it.next();
                printW.println(aluno.getNome()+";"+aluno.getMat()+";"+aluno.getCr());
            }
            
            fileW.close();
            printW.close();
            
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }    
    }
    public static void lerArquivoTexto(String nomeArq, TurmaArray turmaArray){
        FileReader fileR;
        BufferedReader buffR;
        try {
            fileR = new FileReader(nomeArq);
            buffR = new BufferedReader(fileR);
            
            String line;
            while ((line = buffR.readLine())!=null){
                Aluno aluno = new Aluno();
                Scanner scan = new Scanner(line);
                scan.useDelimiter(";");
                String nome = scan.next();
                int mat  = scan.nextInt();
                float cr =  scan.nextFloat();
       
                aluno.setNome(nome);
                aluno.setMat(mat);
                aluno.setCr(cr);
                turmaArray.adicionaAluno(aluno);
                scan.close();
            }
            
            fileR.close();
            buffR.close();
             
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }    
    }
}
