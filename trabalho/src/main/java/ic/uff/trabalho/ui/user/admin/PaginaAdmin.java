package ic.uff.trabalho.ui.user.admin;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

import javax.swing.*;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.musica.Musica;
import ic.uff.trabalho.usuario.Usuario;


public class PaginaAdmin extends JDialog{     
    private JTabbedPane abas = new JTabbedPane();
    private JPanel abausers;
    private JPanel abamusicas = new JPanel();
    private Collection<Usuario> usuarios = ArquivoBinario.lerArquivoUsuarios();
    private Collection<Usuario> logins = ArquivoBinario.lerArquivoLogins();
    private Collection<Musica> musicas = ArquivoBinario.lerArquivoMusicas();
    private Usuario usuariologado;
    
    public PaginaAdmin(Usuario usuario_logado) {  
        setUsuarioLogado(usuario_logado);
        setJanela();
        abausers = new AbaUsers(this, this.usuariologado);
        abamusicas = new AbaMusicas(this);
        abas.add("Usuários", abausers);
        abas.add("Coleção Principal", abamusicas);
        add(BorderLayout.CENTER, abas);
    }

    public void setUsuarioLogado(Usuario usuario){
        this.usuariologado = usuario;
    }
    public Collection<Usuario> getUsuarios(){
        return usuarios;
    }
    public Collection<Usuario> getLogins(){
        return logins;
    }
    public Collection<Musica> getMusicas(){
        return musicas;
    }
    public Usuario getUsuarioLogado(){
        return usuariologado;
    }

    public void setJanela(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setTitle("Admin");    
        setModal(true);
        setSize(700, 500);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}