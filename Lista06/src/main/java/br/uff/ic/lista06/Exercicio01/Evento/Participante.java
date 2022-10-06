/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Evento;

import br.uff.ic.lista06.Exercicio01.Participante.Aluno;
import br.uff.ic.lista06.Exercicio01.Participante.Funcionario;
import br.uff.ic.lista06.Exercicio01.Participante.Professor;

/**
 *
 * @author Pedro
 */
public class Participante {
    String matricula;
    String nome;
    String email;
    
    public Participante(Aluno aluno){
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }
    public Participante(Professor professor){
        this.matricula = professor.getMatricula();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
    }
    public Participante(Funcionario funcionario){
        this.matricula = funcionario.getMatricula();
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
    }
    public String getMatricula(){
        return this.matricula;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
}
