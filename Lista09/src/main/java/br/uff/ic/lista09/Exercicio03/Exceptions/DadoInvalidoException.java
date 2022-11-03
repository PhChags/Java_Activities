/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista09.Exercicio03.Exceptions;

/**
 *
 * @author Pedro
 */
public class DadoInvalidoException extends Exception {
    
    public DadoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public DadoInvalidoException() {
        super("O VALOR INSERIDO EH INVALIDO");
    }
}
