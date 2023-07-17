package ic.uff.trabalho.musica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Letra {
    private String nomeArqLetra;
    private String texto;
    
    public Letra(String nomeArqLetra) {
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            this.nomeArqLetra = nomeArqLetra;
            fr = new FileReader(nomeArqLetra);
            br = new BufferedReader(fr);
            boolean eof = false;
            
            do{
                String s = br.readLine();
                if (s==null){
                    eof = true;
                }
                else{
                    texto = texto + s + "\n";
                }     
            }while (!eof);
            
        } catch (IOException ex) {
            Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getNomeArqLetra() {
        return nomeArqLetra;
    }

    public void setNomeArqLetra(String nomeArqLetra) {
        this.nomeArqLetra = nomeArqLetra;
    }

    @Override
    public String toString() {
        return "Letra{" + "nomeArqLetra=" + nomeArqLetra + ", texto=" + texto + '}';
    }
}
