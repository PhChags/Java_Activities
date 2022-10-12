/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.lista07.Exercicio01;

/**
 *
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============= CIRCULO =============");
        Circulo circulo = new Circulo(13);
        System.out.println("============= TRIANGULO =============");
        Triangulo triangulo = new Triangulo(3, 7, 4, 5, 6);
        System.out.println("============= RETANGULO =============");
        Retangulo retangulo = new Retangulo(7, 3);
        System.out.println("============= QUADRADO =============");
        Quadrado quadrado = new Quadrado(5);

    }
}
