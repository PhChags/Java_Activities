/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio01;

/**
 *
 * @author Pedro
 */
public class Circulo extends FormaGeometrica{
    private double raio;
    
    public Circulo(double raioP){
        this.raio = raioP;
        calcularArea();
        calcularPerimetro();
    }
    
    @Override
    protected void calcularArea() {
        area = Math.PI * (raio * raio);
        System.out.println("Area: " + area);
    }

    @Override
    protected void calcularPerimetro() {
        perimetro = 2 * Math.PI * raio;
        System.out.println("Perimetro: " + perimetro);
    }
    
}
