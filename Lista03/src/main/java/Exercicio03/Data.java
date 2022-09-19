/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio03;

/**
 *
 * @author Pedro
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;
    String data;
    
    public Data(int diaPar, int mesPar, int anoPar){
        this.dia = diaPar;
        this.mes = mesPar;
        this.ano = anoPar;
        if (this.dia < 10){
            if(this.mes < 10)
                this.data = ("0" + this.dia + "/" + "0" + this.mes + "/" + this.ano);
            else
                this.data = ("0" + this.dia + "/" + this.mes + "/" + this.ano);
        } else {
            if(this.mes < 10)
                this.data = (this.dia + "/" + "0" + this.mes + "/" + this.ano);
            else
                this.data = (this.dia + "/" + this.mes + "/" + this.ano);
                
        }
    }
    public Data(int diaPar, String mesPar, int anoPar){
        this.dia = diaPar;
        this.ano = anoPar;
        if(this.dia < 10)
            this.data = (mesPar + " " + "0" + this.dia + ", " + this.ano);
        else
            this.data = (mesPar + " " + this.dia + ", " + this.ano);
    }
    public Data(int diaPar, int anoPar){
        this.dia = diaPar;
        this.ano = anoPar;
        this.data = (this.dia + "   " + this.ano);
    }
}