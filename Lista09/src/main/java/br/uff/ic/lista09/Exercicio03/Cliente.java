/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista09.Exercicio03;

import br.uff.ic.lista09.Exercicio03.Exceptions.DadoInvalidoException;

/**
 *
 * @author Pedro
 */
public class Cliente {
    private int cpf;
    private String nome;
    private int idade;


    protected void setCpf(int cpf) throws DadoInvalidoException {
        if (cpf <= 0 ) {
            throw new DadoInvalidoException("O VALOR INSERIDO PARA CPF EH INVALIDO");
        } else {
            this.cpf = cpf;
        }
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }
    protected void setIdade(int idade) throws DadoInvalidoException {
        if (idade < 18 || idade > 100 ) {
            throw new DadoInvalidoException("VALOR INVALIDO PARA IDADE");
        } else {
            this.idade = idade;
        }
    }

    protected String getNome() {
        return nome;
    }

    protected int getIdade() {
        return idade;
    }

    protected int getCpf() {
        return cpf;
    }

    protected Cliente(int cpf, String nome, int idade) throws DadoInvalidoException {
        setCpf(cpf);
        this.nome = nome;
        setIdade(idade);
    }
}
