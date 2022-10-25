/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista8.Exercicio01;

/**
 *
 * @author Pedro
 */
public class DiaDaSemana {
    private enum Dias {
        DOMINGO (1),
        SEGUNDA (2),
        TERCA (3),
        QUARTA (4),
        QUINTA (5),
        SEXTA (6),
        SABADO (7);   
    
        private int valor;
    
        Dias(int valorP){
            this.valor = valorP;
        }
    }
    
    public static boolean ehDiaUtil(DiaDaSemana dia){
        return !(dia == Dias.DOMINGO || dia == Dias.SABADO);
    }

}
