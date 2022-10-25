/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista8.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Par<String, Integer> par = new Par <String, Integer>();
        
        par.setPrimeiroElementoPar("Primeiro");
        par.setSegundoElementoPar(73);
        
        System.out.println("1 Elemento: " + par.getPrimeiroElementoPar());
        System.out.println("2 Elemento: " + par.getSegundoElementoPar());
    }
}
