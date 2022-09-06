/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aula02;

/**
 *
 * @author Pedro
 */
public class Aluno {
        int matricula;
        float CR;
        String nome;
        
       String estudar(){
           return "O aluno estah estudando";
       }
       boolean inscrever(String disciplinas){
           if(disciplinas == "POO")
               return true;
           else
               return false;
       }
       float consultCR(){
           return CR;
       }
}