package ic.uff.trabalho.musica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import ic.uff.trabalho.arquivador.ArquivoBinario;

public class PersistenciaMusica {
    private static final int TAM_REG_MUS = 110;
    private static final int TAM_STRING = 30;
    private static final int POS_ID_MUS = 0;
    private static final int POS_TITULO_MUS = 4;
    private static final int POS_DURACAO_MUS = 34;
    private static final int POS_AUTOR_MUS = 42;
    private static final int POS_DATE_MUS = 72;
    private static final int POS_GENERO_MUS = 76;
    private static final int POS_BYTE_VERIFICADOR = 106;
    
    public PersistenciaMusica(){};
    
    public static void salvar_musicas(Collection<Musica> musicas,String nomeArq){
        try {
            FileOutputStream fw = new FileOutputStream(nomeArq);
            DataOutputStream dw = new DataOutputStream(fw);
            
            byte[] b = new byte[110];
  
            for (Musica m: musicas){    
                Arrays.fill(b, (byte)0);

                ByteBuffer bb = ByteBuffer.wrap(b);

                bb.putInt(POS_ID_MUS, m.getId());
                
                byte[] bTitulo = m.getTitulo().getBytes();
                bb.put(POS_TITULO_MUS, bTitulo);
                
                int bDuracao = (m.getDuracao().getMin()*60)+m.getDuracao().getSegundos();
                bb.putInt(POS_DURACAO_MUS, bDuracao);

                bb.putInt(POS_DATE_MUS, m.getData());
                
                byte[] bAutor = m.getAutores().getBytes();
                bb.put(POS_AUTOR_MUS, bAutor);
                
                byte[] bGenero = m.getGenero().getBytes();
                bb.put(POS_GENERO_MUS, bGenero);
                
                bb.putInt(POS_BYTE_VERIFICADOR, 1);

                dw.write( bb.array());       
            }
            
            fw.close();
            dw.close();
           
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public static Collection<Musica> ler(String nomeArq){
        Collection<Musica> musicas = new ArrayList<Musica>();
        
        try {
            FileInputStream fw = new FileInputStream(nomeArq);
            DataInputStream dw = new DataInputStream(fw);
            byte[] b = new byte[TAM_REG_MUS];
            boolean eof = false;
            
            do{    
                try {       
                    if (dw.read(b, 0, TAM_REG_MUS)==-1){
                        eof = true;
                    }
                    else{
                        int total, min, seg, id, data, v;

                        v = ByteBuffer.wrap(b).getInt(POS_BYTE_VERIFICADOR);
                        id = ByteBuffer.wrap(b).getInt(POS_ID_MUS);
                        String titulo = new String(b,POS_TITULO_MUS,TAM_STRING);
                        total = ByteBuffer.wrap(b).getInt(POS_DURACAO_MUS);
                        min = (int)total/60;
                        seg = total - (min*60);
                        Duracao duracao = new Duracao(min, seg);
                        String autor = new String(b, POS_AUTOR_MUS, TAM_STRING);
                        data = ByteBuffer.wrap(b).getInt(POS_DATE_MUS);
                        String genero = new String(b, POS_GENERO_MUS, TAM_STRING);
                        
                        musicas.add(new Musica(titulo,id,duracao, autor, data,genero, v));
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
        
        if (musicas.isEmpty()){
            return null;
        }
        else{
            return musicas;
        }
    }
    
    
    public static void removeRegistroPos(String nomeArq, int pos){
        RandomAccessFile ra;
    
        try {
            ra = new RandomAccessFile(nomeArq,"rw");
            
            ra.seek((pos-1)*TAM_REG_MUS);
            byte[] b = new byte[TAM_REG_MUS];

            Arrays.fill(b, (byte)0);
            
            ByteBuffer bb = ByteBuffer.wrap(b);

            bb.putInt(POS_ID_MUS, pos);
            bb.putInt(POS_BYTE_VERIFICADOR, 0);
            ra.write(bb.array());       
            
            ra.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escreveRegistroPos(String nomeArq, int pos, int id, String titulo, Duracao duracao, String autores, int data, String genero){
        RandomAccessFile ra;
    
        try {
            
            ra = new RandomAccessFile(nomeArq,"rw");
            
            ra.seek((pos-1)*TAM_REG_MUS);
            byte[] b = new byte[TAM_REG_MUS];

            Arrays.fill(b, (byte)0);
            
            ByteBuffer bb = ByteBuffer.wrap(b);

            int tempo_em_segundos = duracao.getMin()*60+duracao.getSegundos();
            
            bb.put(POS_TITULO_MUS, titulo.getBytes());
            bb.putInt(POS_ID_MUS, id);
            bb.putInt(POS_DATE_MUS, data);
            bb.putInt(POS_DURACAO_MUS, tempo_em_segundos);
            bb.put(POS_GENERO_MUS, genero.getBytes());
            bb.put(POS_AUTOR_MUS, autores.getBytes());
            bb.putInt(POS_BYTE_VERIFICADOR, 1);
            ra.write(bb.array());       
            
            ra.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}