/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista8.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Par <F, S> {
    private F primeiroPar;
    private S segundoPar;

    public F getPrimeiroElementoPar() {
        return this.primeiroPar;
    }

    public S getSegundoElementoPar() {
        return this.segundoPar;
    }

    public void setPrimeiroElementoPar(F primeiroParP) {
        this.primeiroPar = primeiroParP;
    }

    public void setSegundoElementoPar(S segundoParP) {
        this.segundoPar = segundoParP;
    }
}
