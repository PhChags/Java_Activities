package ic.uff.trabalho.usuario;

import java.util.ArrayList;
import java.util.Collection;

import ic.uff.trabalho.interfaces.Comparavel;
import ic.uff.trabalho.musica.Musica;

public class Usuario implements Comparavel{
    private String nome;
    private int id;
    private String login;
    private String senha;
    private String tipo;
    private Collection<Musica> listapessoal = new ArrayList<Musica>();
    private int byte_verificador;

    public Usuario(){}
    public Usuario(String nome, int id, String login, String senha, String tipo) {
        this.nome = nome;
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }    
    public Usuario(String login, String senha, String tipo, int bytev) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.byte_verificador = bytev;
    }
    public Usuario(String nome, int id, String login, String senha, String tipo, int bytev) {
        this.nome = nome;
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.byte_verificador = bytev;
    }
    public Usuario(String nome, int id, String login, String senha, String tipo, Collection<Musica> musicas, int bytev) {
        this.nome = nome;
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.listapessoal = musicas;
        this.byte_verificador = bytev;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getByteVerificador() {
        return byte_verificador;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setListaPessoal(Collection<Musica> m){
        this.listapessoal = m;
    }

    public Collection<Musica> getListapessoal() {
        return listapessoal;
    }
    
    public void addMusicaListapessoal(Musica m){

        if (!this.listapessoal.contains(m)) this.listapessoal.add(m);
    } 

    public void removeMusicaListapessoal(Musica m){
        if (!this.listapessoal.contains(m)) this.listapessoal.remove(m);
    } 

    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome + ", Login: " + login + ", Senha: " + senha + ", Tipo: " + tipo + ", Lista Pessoal: " + listapessoal + ", Byte Verificador: " + byte_verificador;
    }

    @Override
    public boolean comparaString(String a, String b) {
        
        if (b.length() != 0 && b.length() < 16){
            ArrayList<Character> charq = new ArrayList<Character>();
            ArrayList<Character> chdig = new ArrayList<Character>();
            
            //System.out.println();
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) != ' '){
                    charq.add(i, a.charAt(i));
                    chdig.add(i, b.charAt(i));
                }
                //System.out.println(arquivado.charAt(i));
                //System.out.println(digitado.charAt(i));
            }
            //System.out.println();
            
            if(charq.equals(chdig)){
                //System.out.println("IGUAIS");
                return true;
            }
            else{
                //System.out.println("DIFERENTES");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean comparaArquivado(String arquivado, String digitado) {
        
        if (digitado.length() != 0 && digitado.length() < 16){
            ArrayList<Character> charq = new ArrayList<Character>();
            ArrayList<Character> chdig = new ArrayList<Character>();
            
            //System.out.println();
            for (int i = 0; i < arquivado.length(); i++) {
                if (Character.isLetterOrDigit(arquivado.charAt(i))){
                    charq.add(i, arquivado.charAt(i));
                }
            }
            for (int i = 0; i < digitado.length(); i++) {
                if (Character.isLetterOrDigit(digitado.charAt(i))){
                    chdig.add(i, digitado.charAt(i));
                }
                //System.out.println(arquivado.charAt(i));
                //System.out.println(digitado.charAt(i));
            }
            //System.out.println();
            
            if(charq.equals(chdig)){
                //System.out.println("IGUAIS");
                return true;
            }
            else{
                //System.out.println("DIFERENTES");
                return false;
            }
        }
        return false;
    }
    
}
