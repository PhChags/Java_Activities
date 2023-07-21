/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ic.uff.br.iii;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anselmo
 */
public class AtendimentoClientes {

    
    
    public static void main(String[] args) {
        
        ColecaoClientes c = new ColecaoClientes(18);


        c.inserir(new Cliente(21211,"anselmo"));
        c.inserir(new Cliente(93112,"joao"));
        c.inserir(new Cliente(71213,"pedro"));
        c.inserir(new Cliente(24414,"carlos"));
        c.inserir(new Cliente(35615,"jose"));
        c.inserir(new Cliente(67116,"maria"));
        c.inserir(new Cliente(61217,"bianca"));
        c.inserir(new Cliente(78718,"barbara"));
        c.inserir(new Cliente(53919,"alex"));
        c.inserir(new Cliente(22610,"jonatas"));
        c.inserir(new Cliente(48411,"omar"));
        c.inserir(new Cliente(85322,"tania"));
        c.inserir(new Cliente(73233,"paulo"));
        c.inserir(new Cliente(51841,"jonas"));
        c.inserir(new Cliente(31051,"juan"));
        c.inserir(new Cliente(79283,"marcos"));
        c.inserir(new Cliente(51731,"bruno"));
        c.inserir(new Cliente(21651,"rita"));
        
        
        try {
            
            Atendente atendente1 = new Atendente("A",c);
            Atendente atendente2 = new Atendente("B",c);
            Atendente atendente3 = new Atendente("C",c);
            
            atendente1.start();
            atendente2.start();
            atendente3.start();
            atendente1.join();
            atendente2.join();
            atendente3.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AtendimentoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
