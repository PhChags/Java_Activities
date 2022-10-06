/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio03;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Agenda {
    private static Agenda instance;
    private ArrayList contatos;

    static Agenda getInstance() {
        if (instance == null) {
            instance = new Agenda();
        }
        return instance;
    }
    
    private Agenda() {
        contatos = new ArrayList();
    }
    
    public void procurarContato(String key, String tipo) {
        boolean encontrou = false;
        if (tipo.equalsIgnoreCase("Pessoa Fisica")) {
            for (int i=0; i<contatos.size() && !encontrou; i++) {
                if (contatos.get(i).getClass().equals(Fisica.class)) {
                    Fisica contato = (Fisica) contatos.get(i);
                    if (contato.getCpf().equalsIgnoreCase(key)) {
                        encontrou = true;
                        Main.mostrarPessoaFisica(contato);
                    }
                }
            }
        } else if (tipo.equalsIgnoreCase("Pessoa Juridica")) {
            for (int i=0; i<contatos.size() && !encontrou; i++) {
                if (contatos.get(i).getClass().equals(Juridica.class)) {
                    Juridica contato = (Juridica) contatos.get(i);
                    if (contato.getCnpj().equalsIgnoreCase(key)) {
                        encontrou = true;
                        Main.mostrarPessoaJuridica(contato);
                    }
                }
            }
        }
        if (!encontrou) {
            System.out.println("Contato nao encontrado");
        }
    }


    public void addContato(Fisica pessoa) {
        contatos.add(pessoa);
    }

    public void addContato(Juridica pessoa) {
        contatos.add(pessoa);
    }

    public ArrayList getContatos() {
        return contatos;
    }
}
