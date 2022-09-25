/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista05.Exercicio01B;

/**
 *
 * @author Pedro
 */
public class AreaQueSeraMedida {
    private static final double AREA_CAMPO_EM_METRO_QUADRADO = 8.250;

    public static void mostraArea() {
        double peQ2 = ConversaoDeUnidadesDeArea.metroToPe(AREA_CAMPO_EM_METRO_QUADRADO);
        double acre = ConversaoDeUnidadesDeArea.peToAcre(peQ2);
        double cent = ConversaoDeUnidadesDeArea.peToCentimetros(peQ2);

        System.out.println("EM PES QUADRADOS: " + peQ2);
        System.out.println("EM ACRES: " + acre);
        System.out.println("EM CENTIMETROS QUADRADOS: " + cent);

    }
}