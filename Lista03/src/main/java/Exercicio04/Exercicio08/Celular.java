/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio08;

/**
 *
 * @author Pedro
 */
public class Celular {
    Bateria bateria;
    boolean estado;
    boolean naoPertube;
    int tempoLigacao;
    int qntMsgm;
    int tempoInterfaceLigada;
    
    public Celular(int nivel, int carga){
        this.bateria = new Bateria(nivel, carga);
    }
    public boolean ligado(Celular celul){
        if(celul.bateria.nivelCarga == 0)
            return false;
        return true;
    }
    public boolean mandaMsgm(int y, Celular cel){
        if(ligado(cel)){
            for(int i = 0; i < y; i++){
                cel.bateria.nivelCarga--;
                if(cel.bateria.nivelCarga == 0){
                    System.out.println("A bateria acabou :(");
                    System.out.println("Foi possivel enviar apenas " + (i+1) + " mensagens");
                    return false;
                }
            }
            cel.qntMsgm = y;
            return true;
        } else{
            System.out.println("Ceular descarregado");
            return false;
        }   
    }
    public boolean ligacao(Celular celu, int x){
        if(ligado(celu)){
            x *= 60;
            for(int i = 5; i <= x; i++){
                if(i % 5 == 0)
                    celu.bateria.nivelCarga--;
                if(celu.bateria.nivelCarga == 0){
                    System.out.println("A bateria acabou :(");
                    System.out.println("A ligacao durou " + i + " segundos");
                    return false;
                }
            }
            celu.tempoLigacao = x;
            return true;
        } else{
            System.out.println("Ceular descarregado");
            return false;
        }
    }
}
