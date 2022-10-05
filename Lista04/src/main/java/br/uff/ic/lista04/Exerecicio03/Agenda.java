/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exerecicio03;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Pedro
 */
public class Agenda {
    private ArrayList<Compromisso> compromissos = new ArrayList<>();

    public void addCompromisso(String titulo, String descricao, String local, Calendar data) {
        Compromisso compromisso = new Compromisso(titulo, descricao, local, data);
        compromissos.add(compromisso);
    }

    public ArrayList<Compromisso> verificarDia(int dia, int mes, int ano) {
        ArrayList<Compromisso> horarios = new ArrayList<>();
        for (Compromisso compromisso: compromissos) {
            Calendar data = compromisso.getData();
            if (data.get(Calendar.DAY_OF_MONTH) == dia && data.get(Calendar.MONTH) == mes && data.get(Calendar.YEAR) == ano) {
                horarios.add(compromisso);
            }
        }

        horarios.sort(new Compara(0));
        horarios.sort(new Compara(1));

        return horarios;
    }
}
