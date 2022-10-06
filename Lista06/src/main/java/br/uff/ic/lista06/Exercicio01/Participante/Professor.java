/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Participante;

/**
 *
 * @author Pedro
 */
public class Professor extends Cargo {
    private String departamento;
    
    public Professor(String matricula, String nome, String email, String departamento) {
        super(matricula, nome, email);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}
