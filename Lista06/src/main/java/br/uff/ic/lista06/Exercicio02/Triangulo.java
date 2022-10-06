/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        calcularArea();
    }
    
    private void calcularArea() {
        area = (base * altura) / 2;
    }
    
    public double getArea() {
        return area;
    }
}
