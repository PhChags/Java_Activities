/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.iii;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anselmo
 */
public class Atendente extends Thread {
    public static int numAtendentes;
    private String nome;
    private int id;
    private int numAtendimentos;
    private ColecaoClientes colClientes;
    private long tempoAtendimento;
    private List<String> atendidos;
    
    public Atendente(String nome, ColecaoClientes c){
        this.id = numAtendentes++;
        this.nome = nome;
        this.colClientes = c;
        this.numAtendimentos = 0;
        this.tempoAtendimento = (long)(Math.random()*10000);
        this.atendidos  = new ArrayList<>();
    }
    
    public void run(){
        Cliente c;
      
        while ((c = colClientes.remover())!=null){
            
            try {
                Thread.sleep(tempoAtendimento);
            } catch (InterruptedException ex) {
                Logger.getLogger(Atendente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            numAtendimentos ++;
            colClientes.incAtendimentos();
            atendidos.add(c.getNome());
            System.out.println(this.nome + ",id = " + id + " antendeu " + c.toString() + " em " + tempoAtendimento + " segundos");
        }
        
        String s = "{ ";
        
        for (String nomeCliente:atendidos){
            s += nomeCliente + " ";
        }
        
        s += "}";
        
        System.out.println(this.nome + ",id = " + id + " atendeu " + numAtendimentos + " clientes" + s);
        
    }
}
