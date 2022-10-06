/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Evento;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Palestra {
    private String titulo;
    private String palestrante;
    private String local;
    private String data;
    private String hora;
    private int duracao;
    private int maxParticipantes;
    private int numeroParticipantes;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    
    public Palestra(String titulo, String nomePalestrante, String local, String horarioInicio, int duracaoP, int numeroMax, String dataPar) {
        this.titulo = titulo;
        this.palestrante = nomePalestrante;
        this.local = local;
        this.hora = horarioInicio;
        this.duracao = duracaoP;
        this.maxParticipantes = numeroMax;
        this.data = dataPar;

    }
    public void addParticipantes(Participante partipante) {
        participantes.add(partipante);
        this.numeroParticipantes++;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getData(){
        return this.data;
    }
    public String getLocal() {
        return this.local;
    }
    public String getNomePalestrante() {
        return this.palestrante;
    }
    public String getHorario() {
        return this.hora;
    }
    public int getNumeroMaximoPartipantes() {
        return this.maxParticipantes;
    }
    public int getNumeroParticipantes() {
        return this.numeroParticipantes;
    }
    public ArrayList<Participante> getParticipantes() {
        return this.participantes;
    }
    public int vagasDisponiveisNaPalestra() {
        return this.getNumeroMaximoPartipantes() - this.getNumeroParticipantes();
    }
}