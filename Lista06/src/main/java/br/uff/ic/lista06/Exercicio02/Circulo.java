/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Circulo extends FiguraGeometrica {
    private static double PI = Math.PI;
    private double raio;
    
    public Circulo(double raio) {
        this.raio = raio;
        calcularArea();
    }
    
    private void calcularArea() {
        area = Circulo.PI * (raio * raio);
    }
    
    public double getArea() {
        return area;
    }
}
