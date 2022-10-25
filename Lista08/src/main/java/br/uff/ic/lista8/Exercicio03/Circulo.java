/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista8.Exercicio03;

/**
 *
 * @author Pedro
 */
public class Circulo extends FormaGeometrica{
    
    public Circulo(double raio){
        calculaArea(raio);
        calculaPerimetro(raio);
    }
    
    private void calculaArea(double raio) {
        area = Math.PI * (raio*raio);
    }
    
    private void calculaPerimetro(double raio) {
        perimetro = 2 * Math.PI * raio;
    }
}
