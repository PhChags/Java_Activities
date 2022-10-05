/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exerecicio03;

import java.util.Calendar;

/**
 *
 * @author Pedro
 */
public class Compromisso {
    private String titulo;
    private String descricao;
    private String local;
    private Calendar data;

    Compromisso(String titulo, String descricao, String local, Calendar data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
    }

    String getTitulo() {
        return titulo;
    }

    String getDescricao() {
        return descricao;
    }

    String getLocal() {
        return local;
    }

    Calendar getData() {
        return data;
    }
}
