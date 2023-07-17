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

public class PersistenciaLogin {       
    private static final int TAM_REG_LOGIN = 49;
    private static final int TAM_STRING = 15;
    private static final int POS_LOGIN_LOGIN = 0;
    private static final int POS_SENHA_LOGIN = 15;
    private static final int POS_TIPO_LOGIN = 30;
    private static final int POS_BYTE_VERIFICADOR_LOGIN = 45;

    public PersistenciaLogin(){};

    public static void salvar_logins(Collection<Usuario> usuarios,String nomeArq){
        try {
            FileOutputStream fw = new FileOutputStream(nomeArq);
            DataOutputStream dw = new DataOutputStream(fw);
            
            byte[] b = new byte[49];
  
            for (Usuario u:usuarios){    
                Arrays.fill(b, (byte)0);

                ByteBuffer bb = ByteBuffer.wrap(b);
                
                byte[] bLogin = u.getLogin().getBytes();
                bb.put(POS_LOGIN_LOGIN, bLogin);

                byte[] bSenha = u.getSenha().getBytes();
                bb.put(POS_SENHA_LOGIN, bSenha);

                byte[] bTipo = u.getTipo().getBytes();
                bb.put(POS_TIPO_LOGIN, bTipo);
                
                bb.putInt(POS_BYTE_VERIFICADOR_LOGIN, 1);

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
            byte[] b = new byte[TAM_REG_LOGIN];
            boolean eof = false;
            
            do{    
                try {       
                    if (dw.read(b, 0, TAM_REG_LOGIN)==-1){
                        eof = true;
                    }
                    else{
                        String login = new String(b, POS_LOGIN_LOGIN, TAM_STRING);
                        String senha = new String(b, POS_SENHA_LOGIN, TAM_STRING);
                        String tipo = new String(b, POS_TIPO_LOGIN, TAM_STRING);
                        int v = ByteBuffer.wrap(b).getInt(POS_BYTE_VERIFICADOR_LOGIN);
                        
                        usuarios.add(new Usuario(login,senha,tipo,v));
                    
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
            
            ra.seek((pos-1)*TAM_REG_LOGIN);
            byte[] b = new byte[TAM_REG_LOGIN];

            Arrays.fill(b, (byte)0);
            
            ByteBuffer bb = ByteBuffer.wrap(b);

            bb.putInt(POS_BYTE_VERIFICADOR_LOGIN, 0);
            ra.write(bb.array());       
            
            ra.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escreveRegistroPos(String nomeArq, int pos, String login, String senha, String tipo){
        RandomAccessFile ra;
    
        try {
            
            ra = new RandomAccessFile(nomeArq,"rw");
            
            ra.seek((pos-1)*TAM_REG_LOGIN);
            byte[] b = new byte[TAM_REG_LOGIN];

            Arrays.fill(b, (byte)0);
            
            ByteBuffer bb = ByteBuffer.wrap(b);

            bb.put(POS_LOGIN_LOGIN, login.getBytes());
            bb.put(POS_SENHA_LOGIN, senha.getBytes());
            bb.put(POS_TIPO_LOGIN, tipo.getBytes());
            bb.putInt(POS_BYTE_VERIFICADOR_LOGIN, 1);
            ra.write(bb.array());       
            
            ra.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
