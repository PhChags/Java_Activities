/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista8.Exercicio03;

/**
 *
 * @author Pedro
 */
public class Retangulo extends FormaGeometrica{
    
    public Retangulo(double b, double h){
        calculaArea(b, h);
        calculaPerimetro(b, h);
    }
    
    private void calculaArea(double b, double h){
        area = (b*h);
    }
    private void calculaPerimetro(double b, double h){
        perimetro = (b*2) + (h*2);
    }
}
