package ic.uff.trabalho.usuario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.musica.Musica;

public class PersistenciaListaPessoal {
    public static final int TAM_REG = 38;
    public static final int TAM_STRING = 30;
    public static final int POS_ID = 0;
    public static final int POS_BYTE_VERIFICADOR = 4;
    public static final int POS_TITULO = 8;

    public PersistenciaListaPessoal(){};

    public static void salvar_lista_pessoal(Collection<Musica> musicas,String nomeArq){
        if (!musicas.isEmpty()){
            try {
                FileOutputStream fw = new FileOutputStream(nomeArq);
                DataOutputStream dw = new DataOutputStream(fw);
                
                byte[] b = new byte[TAM_REG];
    
                for (Musica m: musicas){    

                    if(m.getId() != 0){
                        Arrays.fill(b, (byte)0);

                        ByteBuffer bb = ByteBuffer.wrap(b);

                        bb.putInt(POS_ID, m.getId());
                        
                        byte[] bTitulo = m.getTitulo().getBytes();
                        bb.put(POS_TITULO, bTitulo);
                        
                        bb.putInt(POS_BYTE_VERIFICADOR, 1);

                        dw.write( bb.array());  
                    }     
                }
                
                fw.close();
                dw.close();
            
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else{
            try {
                FileOutputStream fw = new FileOutputStream(nomeArq);
                DataOutputStream dw = new DataOutputStream(fw);
                
                byte[] b = new byte[TAM_REG];
    

                Arrays.fill(b, (byte)0);

                ByteBuffer bb = ByteBuffer.wrap(b);

                bb.putInt(POS_ID, 0);
                
                bb.putInt(POS_BYTE_VERIFICADOR, 0);

                dw.write(bb.array());       
                
                fw.close();
                dw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Collection<Musica> ler(String nomeArq){
        Collection<Musica> musicaslp = new ArrayList<Musica>();
        
        try {
            FileInputStream fw = new FileInputStream(nomeArq);
            DataInputStream dw = new DataInputStream(fw);
            byte[] b = new byte[TAM_REG];
            boolean eof = false;
            
            do{    
                try {       
                    if (dw.read(b, 0, TAM_REG)==-1){
                        eof = true;
                    }
                    else{
                        String titulo = new String(b,POS_TITULO,TAM_STRING);
                        int id = ByteBuffer.wrap(b).getInt(POS_ID);
                        int v = ByteBuffer.wrap(b).getInt(POS_BYTE_VERIFICADOR);
                        
                        musicaslp.add(new Musica(titulo, id, v));
                    
                        //System.out.println(nome + " " + login + " " + senha);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }while (!eof);
            
            try {
                fw.close();
                dw.close();
            } catch (IOException ex) {
                Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (musicaslp.isEmpty()){
            return null;
        }
        else{
            return musicaslp;
        }
    }
}
