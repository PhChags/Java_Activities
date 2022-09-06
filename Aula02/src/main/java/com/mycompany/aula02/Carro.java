/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula02;

/**
 *
 * @author Pedro
 */
public class Carro {
    String placa;
    String marca;
    String modelo;
    
    boolean movimento(int mov){
        if (mov == 1)
            return true;
        else
            return false;
    }
    String consultPlaca(){
        return placa;
    }
    String qualCar(){
        return (marca + " " + modelo);
    }
    
}
