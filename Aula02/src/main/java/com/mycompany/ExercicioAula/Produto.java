/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ExercicioAula;

/**
 *
 * @author Pedro
 */
public class Produto {
    int id;
    String nome;
    float preco;
    float qntEstq;
    String tipoProd;
    
    public boolean atualizaEstoque(int qnt) {
        if (qntEstq >= qnt){
            qntEstq -= qnt;
            return true;
        } else
            return false;
    }
}
