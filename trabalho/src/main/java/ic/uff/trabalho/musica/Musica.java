package ic.uff.trabalho.musica;

import java.util.ArrayList;

import ic.uff.trabalho.interfaces.Comparavel;

public class Musica implements Comparavel{
    private static int numMusicas = 0;
    private int id;
    private String titulo;
    private Duracao duracao;
    private String autores;
    private int data;
    private String genero;
    private int byte_verificador;
    
    public Musica(){}

    public Musica(String titulo, Duracao duracao, String autores, int data, String genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.autores = autores;
        this.data = data;
        this.genero = genero;
        numMusicas++;
        this.id = numMusicas;
    }
    
    public Musica(String titulo, int id, Duracao duracao, String autores, int data, String genero, int v) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.autores = autores;
        this.data = data;
        this.genero = genero;
        this.id = id;
        this.byte_verificador = v;
    }
    
    public Musica(String titulo, int id, int v) {
        this.titulo = titulo;
        this.id = id;
        this.byte_verificador = v;
    }

    public static int getNumMusicas() {
        return numMusicas;
    }

    public int getByteVerificador() {
        return byte_verificador;
    }

    public static void setNumMusicas(int numMusicas) {
        Musica.numMusicas = numMusicas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Duracao getDuracao() {
        return duracao;
    }

    public void setDuracao(Duracao duracao) {
        this.duracao = duracao;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Musica{" + "titulo=" + titulo + ", duracao=" + duracao + ", autores=" + autores + ", data=" + data + ", genero=" + genero + '}' + " Byte Verificador: " + byte_verificador + "   " + "ID: " + id;
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
        
        if (digitado.length() != 0 && digitado.length() < 31){
            ArrayList<Character> charq = new ArrayList<Character>();
            
            //System.out.println();
            for (int i = 0; i < digitado.length(); i++) {
                charq.add(i, arquivado.charAt(i));
                //System.out.println(arquivado.charAt(i));
            }
            //System.out.println();
            
            ArrayList<Character> chdig = new ArrayList<Character>();
            
            for (int i = 0; i < digitado.length(); i++) {
                chdig.add(i, digitado.charAt(i));
                //System.out.println(digitado.charAt(i));
            }
            
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
