/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Participante;

/**
 *
 * @author Pedro
 */
public class Aluno extends Cargo{
    private String curso;

    public Aluno(String matricula, String nome, String email, String curso) {
        super(matricula, nome, email);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }
}
