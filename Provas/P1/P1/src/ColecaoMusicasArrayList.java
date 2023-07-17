package ic.uff.br;

import java.util.ArrayList;
import java.util.Collection;

public class ColecaoMusicasArrayList extends ColecaoMusicas {
    public Collection<Musica> musicas;
    
    public ColecaoMusicasArrayList(){
        super();
        this.musicas = new ArrayList<Musica>();
        
    }
    @Override
    public void adicionar(Musica musica) {
        musicas.add(musica);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Musica buscar(String titulo) {
        for (Musica m:musicas){
            if (m.getTitulo() == titulo){
                return m;
            }
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Musica buscar(int id) {
        for (Musica m:musicas){
            if (m.getId() == id){
                return m;
            }
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Musica remover(int id) {
        
        for (Musica m:musicas){
            if (m.getId() == id){
                musicas.remove(m);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void imprimir() {
        for (Musica m:musicas){
            System.out.println(m.toString());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
