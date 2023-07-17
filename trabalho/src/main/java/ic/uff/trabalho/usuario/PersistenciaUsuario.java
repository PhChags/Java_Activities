package ic.uff.trabalho.usuario;

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

public class PersistenciaUsuario {
    private static final int TAM_REG_USER = 68;
    private static final int TAM_STRING = 15;
    private static final int POS_NOME_USER = 0;
    private static final int POS_ID_USER = 15;
    private static final int POS_LOGIN_USER = 19;
    private static final int POS_SENHA_USER = 34;
    private static final int POS_TIPO_USER = 49;
    private static final int POS_BYTE_VERIFICADOR = 64;
    
    public PersistenciaUsuario(){};

    public static void salvar_usuarios(Collection<Usuario> usuarios,String nomeArq){
        try {
            FileOutputStream fw = new FileOutputStream(nomeArq);
            DataOutputStream dw = new DataOutputStream(fw);
            
            byte[] b = new byte[TAM_REG_USER];
  
            for (Usuario u:usuarios){    
                Arrays.fill(b, (byte)0);

                ByteBuffer bb = ByteBuffer.wrap(b);

                byte[] bNome = u.getNome().getBytes();
                bb.put(POS_NOME_USER, bNome);

                bb.putInt(POS_ID_USER, u.getId());
                
                byte[] bLogin = u.getLogin().getBytes();
                bb.put(POS_LOGIN_USER, bLogin);

                byte[] bSenha = u.getSenha().getBytes();
                bb.put(POS_SENHA_USER, bSenha);

                byte[] bTipo = u.getTipo().getBytes();
                bb.put(POS_TIPO_USER, bTipo);
                
                bb.putInt(POS_BYTE_VERIFICADOR, 1);

                dw.write( bb.array());       
            }
            
            fw.close();
            dw.close();
           
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public static Collection<Usuario> ler(String nomeArq){
        Collection<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {
            FileInputStream fw = new FileInputStream(nomeArq);
            DataInputStream dw = new DataInputStream(fw);
            byte[] b = new byte[TAM_REG_USER];
            boolean eof = false;
            
            do{    
                try {       
                    if (dw.read(b, 0, TAM_REG_USER)==-1){
                        eof = true;
                    }
                    else{
                        String nome = new String(b,0,TAM_STRING);
                        int id = ByteBuffer.wrap(b).getInt(POS_ID_USER);
                        String login = new String(b, POS_LOGIN_USER, TAM_STRING);
                        String senha = new String(b, POS_SENHA_USER, TAM_STRING);
                        String tipo = new String(b, POS_TIPO_USER, TAM_STRING);
                        int v = ByteBuffer.wrap(b).getInt(POS_BYTE_VERIFICADOR);
                        
                        usuarios.add(new Usuario(nome,id,login,senha,tipo,v));
                    
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
        
        if (usuarios.isEmpty()){
            return null;
        }
        else{
            return usuarios;
        }
    }
    
    public static void removeRegistroPos(String nomeArq, int pos){
        RandomAccessFile ra;
        
        try {
            ra = new RandomAccessFile(nomeArq,"rw");
            
            ra.seek((pos-1)*TAM_REG_USER);
            byte[] b = new byte[TAM_REG_USER];

            Arrays.fill(b, (byte)0);
            
            ByteBuffer bb = ByteBuffer.wrap(b);

            bb.putInt(POS_ID_USER, pos);
            bb.putInt(POS_BYTE_VERIFICADOR, 0);
            ra.write(bb.array());       
            
            ra.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escreveRegistroPos(String nomeArq, int pos, String nome,int id,String login, String senha, String tipo){
        RandomAccessFile ra;
    
        try {
            
            ra = new RandomAccessFile(nomeArq,"rw");
            
            ra.seek((pos-1)*TAM_REG_USER);
            byte[] b = new byte[TAM_REG_USER];

            Arrays.fill(b, (byte)0);
            
            ByteBuffer bb = ByteBuffer.wrap(b);
            
            bb.put(POS_NOME_USER, nome.getBytes());
            bb.putInt(POS_ID_USER, id);
            bb.put(POS_LOGIN_USER, login.getBytes());
            bb.put(POS_SENHA_USER, senha.getBytes());
            bb.put(POS_TIPO_USER, tipo.getBytes());
            bb.putInt(POS_BYTE_VERIFICADOR, 1);
            ra.write(bb.array());       
            
            ra.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}