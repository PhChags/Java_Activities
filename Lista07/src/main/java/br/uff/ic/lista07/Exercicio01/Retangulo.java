/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio01;

/**
 *
 * @author Pedro
 */
public class Retangulo extends FormaGeometrica{
    private double lado1;
    private double lado2;
    
    public Retangulo(double lado1P, double lado2P){
        this.lado1 = lado1P;
        this.lado2 = lado2P;
        calcularArea();
        calcularPerimetro();
    }
    
    @Override
    protected void calcularArea(){
        area = lado1 * lado2;
        System.out.println("Area: " + area);
    }
    
    @Override
    protected void calcularPerimetro(){
        perimetro = (2 * lado1) + (2 * lado2);
        System.out.println("Perimetro: " + perimetro);
    }
}
