/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exerecicio03;

import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author Pedro
 */
public class Compara  implements Comparator<Compromisso> {
    private int op;

    public Compara(int op) {
        this.op = op;
    }

    @Override
    public int compare(Compromisso c1, Compromisso c2) {
        int constante;
        if (op == 0) {
            constante = Calendar.MINUTE;
        } else {
            constante = Calendar.HOUR;
        }
        return c1.getData().get(constante) - c2.getData().get(constante);
    }
}
