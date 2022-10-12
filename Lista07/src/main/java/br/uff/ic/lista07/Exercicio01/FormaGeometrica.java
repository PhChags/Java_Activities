/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio01;

/**
 *
 * @author Pedro
 */
public abstract class FormaGeometrica {
    protected double area;
    protected double perimetro;
    
    public double getArea(){
        return this.area;
    }
    public double getPerimetro(){
        return this.perimetro;
    }
    
    protected abstract void calcularArea();
    protected abstract void calcularPerimetro();
    
}
