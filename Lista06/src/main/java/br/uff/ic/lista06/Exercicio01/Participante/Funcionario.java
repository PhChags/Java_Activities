/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Participante;

/**
 *
 * @author Pedro
 */
public class Funcionario extends Cargo {
    private String cargo;

    public Funcionario(String matricula, String nome, String email, String cargo) {
        super(matricula, nome, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
