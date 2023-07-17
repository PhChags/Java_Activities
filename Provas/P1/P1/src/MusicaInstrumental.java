package ic.uff.br;

import java.util.Date;

public class MusicaInstrumental extends Musica {
    public String nomeArqPartitura;
    
    public MusicaInstrumental(String titulo, Duracao duracao, String autores, Date data, String genero, String nomeArqPartitura) {
        super(titulo, duracao, autores, data, genero);
    }

    public String getNomeArqPartitura() {
        return nomeArqPartitura;
    }

    public void setNomeArqPartitura(String nomeArqPartitura) {
        this.nomeArqPartitura = nomeArqPartitura;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "MusicaInstrumental{" + s + "nomeArqPartitura=" + nomeArqPartitura + '}';
    }
    
    
    
    
}
