/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Quadrado extends FiguraGeometrica{
    private double lado;
    
    public Quadrado(double lado) {
        this.lado = lado;
        calcularArea();
    }
    
    private void calcularArea() {
        area = lado * lado;
    }
    
    public double getArea() {
        return area;
    }
}
