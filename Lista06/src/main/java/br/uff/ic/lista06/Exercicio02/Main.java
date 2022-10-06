/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.lista06.Exercicio02;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        double comprimento, largura;
        System.out.println();
        System.out.println("===================================== RETANGULO =====================================");
        System.out.println("Comprimento: ");
        comprimento = Double.parseDouble(teclado.next());
        System.out.println("Largura: ");
        largura = Double.parseDouble(teclado.next());
        Retangulo retangulo = new Retangulo(comprimento, largura);
        System.out.printf("Area = %.2f m²\n", retangulo.getArea());
        System.out.println("=====================================================================================");
        
        double lado;
        System.out.println();
        System.out.println("===================================== QUADRADO =====================================");
        System.out.println("Lado: ");
        lado = Double.parseDouble(teclado.next());
        Quadrado quadrado = new Quadrado(lado);
        System.out.printf("Area = %.2f m²\n", quadrado.getArea());
        System.out.println("====================================================================================");
        
        double base, altura;
        System.out.println();
        System.out.println("===================================== TRIANGULO =====================================");
        System.out.println("Base:");
        base = Double.parseDouble(teclado.next());
        System.out.println("Altura:");
        altura = Double.parseDouble(teclado.next());
        Triangulo triangulo = new Triangulo(base, altura);
        System.out.printf("Area = %.2f m²\n", triangulo.getArea());
        System.out.println("=====================================================================================");
        
        double raio;
        System.out.println();
        System.out.println("===================================== CIRCULO =====================================");
        System.out.println("Raio: ");
        raio = Double.parseDouble(teclado.next());
        Circulo circulo = new Circulo(raio);
        System.out.printf("Area = %.2f m²\n", circulo.getArea());
        System.out.println("==================================================================================");
    }
}
