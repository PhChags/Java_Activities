/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio01;

/**
 *
 * @author Pedro
 */
public class Triangulo extends FormaGeometrica{
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    
    public Triangulo(double baseP, double alturaP, double lado1P, double lado2P, double lado3P){
        this.base = baseP;
        this.altura = alturaP;
        calcularArea();
        
        this.lado1 = lado1P;
        this.lado2 = lado2P;
        this.lado3 = lado3P;
        calcularPerimetro();
    }
    
    @Override
    protected void calcularArea(){
        area = (base * altura) / 2;
        System.out.println("Area: " + area);

    }
    
    @Override
    protected void calcularPerimetro(){
        perimetro = lado1 + lado2 + lado3;
        System.out.println("Perimetro: " + perimetro);
    }
}
