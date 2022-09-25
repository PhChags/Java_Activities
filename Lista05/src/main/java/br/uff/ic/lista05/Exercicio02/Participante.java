/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista05.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Participante {
    int matricula;
    String nome;
    String email;
    String tipo;
    
    public Participante(int matriculaP, String nomeP, String emailP, String tipoP){
        this.matricula = matriculaP;
        this.nome = nomeP;
        this.email = emailP;
        this.tipo = tipoP;
    }
    public int getMatricula(){
        return this.matricula;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public String getTipo(){
        return this.tipo;
    }
}
