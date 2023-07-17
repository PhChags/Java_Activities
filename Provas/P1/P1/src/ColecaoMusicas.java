package ic.uff.br;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ColecaoMusicas {

    private int numMusicas;
    
    public ColecaoMusicas(){
        numMusicas = 0;
    }

    public int getNumMusicas() {
        return numMusicas;
    }

    public void setNumMusicas(int numMusicas) {
        this.numMusicas = numMusicas;
    }
    
    public abstract void adicionar(Musica musica);
    
    public abstract Musica buscar(String titulo);
    
    public abstract Musica buscar(int id);
    
    public abstract Musica remover(int id);
    
    public abstract void imprimir();
        
}
