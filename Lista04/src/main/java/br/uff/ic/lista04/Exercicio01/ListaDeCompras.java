/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exercicio01;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Pedro
 */
public class ListaDeCompras {
    private String nome;
    private ArrayList<String> listaDeCompras = new ArrayList<>();

    public void add(String nome) {
        if (!listaDeCompras.contains(nome)) {
            listaDeCompras.add(nome);
        }
    }

    public void imprimeLista() {
        Collections.sort(listaDeCompras);
        System.out.println("Lista de Compras: ");
        for (int i = 0; i < listaDeCompras.size(); i++) {
            System.out.println("Item " + i + ": " + listaDeCompras.get(i));
        }
    }
}
