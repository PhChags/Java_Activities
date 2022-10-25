/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista8.Exercicio03;

/**
 *
 * @author Pedro
 */
public class Triangulo extends FormaGeometrica{
    
    public Triangulo(double b, double h, double lado1, double lado2, double lado3){
        calculaArea(b, h);
        calculaPerimetro(lado1, lado2, lado3);
    }
    
    private void calculaArea(double b, double h) {
        area = (b*h)/2;
    }
    private void calculaPerimetro(double lado1, double lado2, double lado3) {
        perimetro = lado1 + lado2 + lado3;
    }
}
