/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.iii;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anselmo
 */
public class ColecaoClientes {
    private Queue<Cliente> clientes;
    private int numClientesAtendidos = 0;
    private int maxAtendimentos;
    public ColecaoClientes(int maxAten){
        clientes = new LinkedList<>();
        maxAtendimentos = maxAten;
    }
    
    public synchronized Cliente remover(){
        while (clientes.isEmpty()&& (numClientesAtendidos < maxAtendimentos)){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ColecaoClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Cliente c = clientes.poll();
        notifyAll();
        return c;
    }
    
    public synchronized void incAtendimentos(){
        numClientesAtendidos++;
    }
    
    public void inserir(Cliente c){
        clientes.add(c);
    }
}
