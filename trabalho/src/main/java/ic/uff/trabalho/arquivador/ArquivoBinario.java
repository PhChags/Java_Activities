package ic.uff.trabalho.arquivador;

import java.util.ArrayList;
import java.util.Collection;

import ic.uff.trabalho.musica.Cancao;
import ic.uff.trabalho.musica.Duracao;
import ic.uff.trabalho.musica.Letra;
import ic.uff.trabalho.musica.Musica;
import ic.uff.trabalho.musica.MusicaInstrumental;
import ic.uff.trabalho.musica.PersistenciaMusica;
import ic.uff.trabalho.usuario.PersistenciaListaPessoal;
import ic.uff.trabalho.usuario.PersistenciaLogin;
import ic.uff.trabalho.usuario.PersistenciaUsuario;
import ic.uff.trabalho.usuario.Usuario;

public class ArquivoBinario {
    public static void criaArquivoBinario() {
        Collection<Usuario> usuarios = new ArrayList<Usuario>();
            
        usuarios.add(new Usuario("Pedro",1,"pehper","Ab4841", "admin"));
        usuarios.add(new Usuario("Erick",2,"3rick","nJ489", "normal"));
        usuarios.add(new Usuario("Marina",3,"marinha","m1et54", "admin"));
        usuarios.add(new Usuario("David",4,"dvd","17ed5", "normal"));
        usuarios.add(new Usuario("Alexandre",5,"alxandre","al12Ws", "normal"));
        usuarios.add(new Usuario("Agatha",6,"Htah","287fe", "normal"));
        usuarios.add(new Usuario("Maria",7,"mavi","klc3w", "admin"));
        usuarios.add(new Usuario("Joana",8,"j0Ana","8tJh", "normal"));
        usuarios.add(new Usuario("Elton",9,"Lt0n","12345", "admin"));
        
        Collection<Musica> musicas = new ArrayList<Musica>();
        
        musicas.add(new Cancao("After Like", new Duracao(3, 1), "IVE", 2022, "Kpop", new Letra("afterlike.txt")));
        musicas.add(new Cancao("chamber of reflection", new Duracao(3, 52), "Mac DeMarco", 
        2014, "jizz jazz", new Letra("chamberofreflection.txt")));
        musicas.add(new Cancao("Azul da Cor do Mar", new Duracao(3, 19), "Tim Maia", 
        1970, "MPB", new Letra("azuldacordomar.txt")));
        musicas.add(new MusicaInstrumental("Danse Macabre", new Duracao(7, 10), "Camille Saint-Saëns", 
        1874, "classica", "dansemacabre.jpg"));
        musicas.add(new MusicaInstrumental("The Ecstasy of Gold", new Duracao(3, 24), 
        "Ennio Morricone", 1966, "trilha sonora", "ecstasyofgold.jpg"));

        for(Usuario u: usuarios){
            PersistenciaListaPessoal.salvar_lista_pessoal(u.getListapessoal(), u.getLogin().toString() + ".bin");
        }
        
        PersistenciaUsuario.salvar_usuarios(usuarios, "usuarios.bin");
        
        PersistenciaMusica.salvar_musicas(musicas, "musicas.bin");

        PersistenciaLogin.salvar_logins(usuarios, "login.enc");
    }
    
    public static void criaNovoUsuario(String nome, String login, String senha, String tipo, int ultimo) {
        PersistenciaUsuario.escreveRegistroPos("usuarios.bin", ++ultimo, nome, ultimo, login, senha, tipo);
    }
    
    public static void criaNovoUsuarioPos(String nome, String login, String senha, String tipo, int pos) {
        PersistenciaUsuario.escreveRegistroPos("usuarios.bin", pos, nome, pos, login, senha, tipo);
    }
    
    public static void removeUsuario(int id){
        //System.out.println("ENTROU REMOVE USUARIO");
        PersistenciaUsuario.removeRegistroPos("usuarios.bin", id);
    }
    
    public static Collection<Usuario> lerArquivoUsuarios(){
        return PersistenciaUsuario.ler("usuarios.bin");
    }

    public static void criaNovoArquivoListaPessoal(String nomeArq, Collection<Musica> listaPessoal){
        PersistenciaListaPessoal.salvar_lista_pessoal(listaPessoal, nomeArq);
    }

    public static Collection<Musica> lerArquivoListaPessoal(String nome){
        return PersistenciaListaPessoal.ler(nome);
    }
    
    public static void criaNovoLoginPos(String login, String senha, String tipo, int pos) {
        PersistenciaLogin.escreveRegistroPos("login.enc", pos, login, senha, tipo);
    }
    
    public static void criaNovoLogin(String login, String senha, String tipo, int ultimo) {
        PersistenciaLogin.escreveRegistroPos("login.enc", ++ultimo, login, senha, tipo);
    }
    
    public static void removeLogin(int id){
        //System.out.println("ENTROU REMOVE LOGIN");
        PersistenciaLogin.removeRegistroPos("login.enc", id);
    }
    
    public static Collection<Usuario> lerArquivoLogins(){
        return PersistenciaLogin.ler("login.enc");
    }

    public static void criaNovaMusica(String titulo, Duracao duracao, String autores, int data, String genero, int ultimo) {
        PersistenciaMusica.escreveRegistroPos("musicas.bin", ++ultimo, ultimo, titulo, duracao, autores, data, genero);
    }

    public static void criaNovaMusicaPos(String titulo, Duracao duracao, String autores, int data, String genero, int pos) {
        PersistenciaMusica.escreveRegistroPos("musicas.bin", pos, pos, titulo, duracao, autores, data, genero);
    }
    
    public static void removeMusica(int id){
        //System.out.println("ENTROU REMOVE MUSICA");
        PersistenciaMusica.removeRegistroPos("musicas.bin", id);
    }

    public static Collection<Musica> lerArquivoMusicas(){
        return PersistenciaMusica.ler("musicas.bin");
    }
}