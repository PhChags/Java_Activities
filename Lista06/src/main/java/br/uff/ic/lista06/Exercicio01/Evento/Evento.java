/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Evento;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Pedro
 */
public class Evento {
    private  ArrayList<Palestra> palestras = new ArrayList<>();    
    private final String dataIn;
    private final String dataFim;
    private final String horaIn;
    private final String horaFim;
    private static Evento evento;
    private static final int MAX_PALESTRAS = 20;
    
    private Evento(String dataI, String dataF, String horaI, String horaF){
        this.dataFim = dataF;
        this.dataIn = dataI;
        this.horaFim = horaF;
        this.horaIn = horaI;
    }
    public static Evento getInstancia(String dataI, String dataF, String horaI, String horaF) {
        if (evento == null)
            evento = new Evento(dataI, dataF, horaI, horaF);

        return evento;
    }
    public void addPalestra(Palestra novaPalestra) {
        if (getPalestras().size() < MAX_PALESTRAS) {
            getPalestras().add(novaPalestra);
            System.out.println("Palestra adicionada!");
        } else {
            System.out.println("Nao eh possivel adicionar mais palestras. Total de palestras do evento atingido.");
        }
    }
    public String getDataInicio() {
        return dataIn;
    }
    public String getDataFim() {
        return dataFim;
    }
    public String getHorarioInicio() {
        return horaIn;
    }
    public String getHorarioFim() {
        return horaFim;
    }
    public ArrayList<Palestra> getPalestras() {
        return palestras;
    }
    public  Palestra procuraPalestra(String titulo) {
        for (int i = 0; i < palestras.size(); i++) {
            if (Objects.equals(palestras.get(i).getTitulo(), titulo)) {
                return palestras.get(i);
            }
        }
        return null;
    }
    protected  void disponibilidadeDaPalestra() {
        System.out.println("PALESTRAS: ");
        for (int i = 0; i < palestras.size(); i++) {
            Palestra palestra = palestras.get(i);
            System.out.println();
            System.out.println("TITULO: " + palestra.getTitulo());
            System.out.println("VAGAS: " + palestra.vagasDisponiveisNaPalestra());
        }
    }
}