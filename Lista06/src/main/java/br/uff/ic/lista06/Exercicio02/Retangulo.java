/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio02;

/**
 *
 * @author Pedro
 */
public class Retangulo extends FiguraGeometrica {
    private double comprimento;
    private double largura;
    
    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
        calcularArea();
    }
    
    private void calcularArea() {
        area = comprimento * largura;
    }
    
    public double getArea() {
        return area;
    }
}
