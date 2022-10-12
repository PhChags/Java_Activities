/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista07.Exercicio05;

/**
 *
 * @author Pedro
 */
public class Servico implements Recebivel{
    private String descricao;
    private int horas;
    private double precoHora;

    protected Servico(String descricao, int horas, double precoHora) {
        this.descricao = descricao;
        this.horas = horas;
        this.precoHora = precoHora;
    }

    @Override
    public String toString() {
        return "Servico { " +
                "descricao do servico = '" + descricao + '\'' +
                ", horas = " + horas +
                ", precoHora = " + precoHora +
                " }";
    }

    @Override
    public double totalizarReceita() {
        return this.horas * this.precoHora;
    }
}
