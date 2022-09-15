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
    
    public Data(int diaPar, int mesPar, int anoPar){
        this.dia = diaPar;
        this.mes = mesPar;
        this.ano = anoPar;
    }
    public void imprimeFormato1(){
        if (dia < 10){
            if(mes < 10)
                System.out.println("0" + this.dia + "/" + "0" + this.mes + "/" + this.ano);
            else
                System.out.println("0" + this.dia + "/" + this.mes + "/" + this.ano);
        } else {
            if(mes < 10)
                System.out.println(this.dia + "/" + "0" + this.mes + "/" + this.ano);
            else
                System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
                
        }
    }
    public void imprimeFormato2(){
        String[] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        if(dia < 10)
            System.out.println(meses[mes-1] + " " + "0" + dia + ", " + ano);
        else
            System.out.println(meses[mes-1] + " " + dia + ", " + ano);
    }
    public void imprimeFormato3(){
        float diaTotal;
        if(ano % 4 == 0){
            diaTotal = (float) ((mes - 1)*30.5);
            if (mes > 2 && mes % 2 == 0 || mes == 7 || mes == 5 || mes == 3){
                System.out.printf("%.0f", (dia + diaTotal - 1));
                System.out.println("   " + ano);
            }
            else{
                System.out.printf("%.0f", (dia + diaTotal));
                System.out.println("   " + ano);
            }
        } else{
            diaTotal = (float) ((mes - 1)*30.42);
            if (mes == 2){
                    System.out.printf("%.0f", (dia + diaTotal + 1));
                    System.out.println("   " + ano);
            }else{
                if (mes == 1 || mes > 7 && mes % 2 != 0){
                    System.out.printf("%.0f", (dia + diaTotal));
                    System.out.println("   " + ano);
                }
                else{
                    if (mes < 8){
                        System.out.printf("%.0f", (dia + diaTotal - 1.5));
                        System.out.println("   " + ano);
                    } else {
                        System.out.printf("%.0f", (dia + diaTotal - 0.5));
                        System.out.println("   " + ano);
                    }
                }
            }
        }
    }
}