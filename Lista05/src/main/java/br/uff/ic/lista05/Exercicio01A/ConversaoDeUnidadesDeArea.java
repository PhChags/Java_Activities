/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista05.Exercicio01A;

/**
 *
 * @author Pedro
 */
public class ConversaoDeUnidadesDeArea {
    
    private static final double UM_METRO_QUADRADO_TO_PE_QUADRADO = 10.76;
    private static final int UM_PE_QUADRADO_TO_CENTIMETROS_QUADRADO = 929;
    private static final int UMA_MILHA_QUADRADA_TO_ACRE = 640;
    private static final double UM_ACRE_TO_PE_QUADRADO = 43.560;

    protected static double metroToPe(double metro) {
        return  metro * UM_METRO_QUADRADO_TO_PE_QUADRADO;
    }

    protected static double peToMetro(double pe) {
        return UM_METRO_QUADRADO_TO_PE_QUADRADO / pe;
    }

    protected static double centimetrosToPe(double centimetros) {
        return  centimetros * UM_PE_QUADRADO_TO_CENTIMETROS_QUADRADO;
    }

    protected static double peToCentimetros(double pe) {
        return UM_PE_QUADRADO_TO_CENTIMETROS_QUADRADO / pe;
    }

    protected static double milhaToAcre(double milha) {
        return  milha * UMA_MILHA_QUADRADA_TO_ACRE;
    }

    protected static double acreToMilha(double acre) {
        return UMA_MILHA_QUADRADA_TO_ACRE / acre;
    }

    protected static double acreToPe(double acre) {
        return  acre * UM_ACRE_TO_PE_QUADRADO;
    }

    protected static double peToAcre(double pe) {
        return UM_ACRE_TO_PE_QUADRADO / pe;
    }
}
