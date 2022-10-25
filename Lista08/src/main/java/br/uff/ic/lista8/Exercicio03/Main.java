/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.lista8.Exercicio03;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<FormaGeometrica> formas = new ArrayList<>();
        
        formas.add(new Circulo(3));
        formas.add(new Triangulo(2, 3, 4, 5, 6));
        formas.add(new Retangulo(7, 3));
        formas.add(new Quadrado(7));
        
        for(FormaGeometrica figuras: formas){
            System.out.println("=====================================");
            System.out.println("area = " + figuras.area);
            System.out.println("perimetro = " + figuras.perimetro);
            System.out.println("=====================================");
        }
    }
}
