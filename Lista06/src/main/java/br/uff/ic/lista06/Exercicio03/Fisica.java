/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio03;

/**
 *
 * @author Pedro
 */
public class Fisica extends Pessoa{
    private String nome;
    private String cpf;
    private String aniversario;
    
    public Fisica(String endereco, String nome, String cpf, String aniversario) {
        super(endereco);
        this.nome = nome;
        this.cpf = cpf;
        this.aniversario = aniversario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getAniversario() {
        return aniversario;
    }
}
