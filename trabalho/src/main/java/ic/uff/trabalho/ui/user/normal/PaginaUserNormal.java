package ic.uff.trabalho.ui.user.normal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.*;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.musica.Musica;
import ic.uff.trabalho.ui.menus.LoginPainel;
import ic.uff.trabalho.usuario.Usuario;

public class PaginaUserNormal extends JFrame{ 
    private Color backgroundcolor = new Color(209, 196, 233);     
    private Color buttonbackgroundcolor = new Color(183, 28, 28);   
    private JButton back = new JButton("RETURN");
    private JButton excluir = new JButton("EXCLUIR PERFIL");
    private JButton remove = new JButton("REMOVER");
    private JButton procura = new JButton("PROCURAR");
    private JButton adiciona = new JButton("ADICIONAR");
    private JLabel label3 = new JLabel("Coleção Principal: ");
    private JLabel label2 = new JLabel("Buscar por Títulos: ");
    private JLabel label1 = new JLabel("Coleção Particular: ");
    private JTextField buscaTitulosField = new JTextField();
    private Vector<String> musicastodropboxcp = new Vector<String>();
    private Vector<String> musicastodropboxlp = new Vector<String>();
    private Collection<Musica> listapessoal = new ArrayList<Musica>();
    private Collection<Musica> musicasLidascp = ArquivoBinario.lerArquivoMusicas();
    private Usuario logado = new Usuario();
    private JComboBox<String> dropBoxcp;
    private JComboBox<String> dropBoxlp;
    private Musica comparativa = new Musica(null, 0, 0);
    private File file;

    public PaginaUserNormal(Usuario usuario_logado) {  
        setUsuarioLogado(usuario_logado);
        setaJanela();
    }

    public void clearDropBox(){
        this.musicasLidascp.clear();
    }
    
    public void setUsuarioLogado(Usuario usuario_logado){
        this.logado = usuario_logado;
    }
    public void setListaPessoal(Collection<Musica> listapessoal){
        this.listapessoal = listapessoal;
    }
    
    public void fillDropBoxcp(){
        musicastodropboxcp.add("...");
        if(this.listapessoal != null){
            if(this.listapessoal.contains(comparativa)){
                for (Musica m: musicasLidascp){
                    if(m.getByteVerificador() == 1) musicastodropboxcp.add(m.getTitulo().toString());
                }
                dropBoxcp = new JComboBox<>(musicastodropboxcp);
            } else{
                for (Musica m : musicasLidascp){
                    //System.out.println(listapessoal.contains(m));
                    if(!musicastodropboxlp.contains(m.getTitulo().toString()) && m.getByteVerificador() == 1) musicastodropboxcp.add(m.getTitulo().toString());
                }
                dropBoxcp = new JComboBox<>(musicastodropboxcp);
            }
        } else{
            for (Musica m: musicasLidascp){
                if(m.getByteVerificador() == 1) musicastodropboxcp.add(m.getTitulo().toString());
            }
            dropBoxcp = new JComboBox<>(musicastodropboxcp);
        }
    }
    public void fillDropBoxlp(){
        musicastodropboxlp.add("...");
        if(this.listapessoal != null){
            if(this.listapessoal.contains(comparativa)) dropBoxlp = new JComboBox<>(musicastodropboxlp);
            else{
                for (Musica n : musicasLidascp) 
                    if(musicastodropboxlp.contains(n.getTitulo().toString()) && n.getByteVerificador() == 1) musicastodropboxlp.add(n.getTitulo().toString());
            }
            dropBoxlp = new JComboBox<>(musicastodropboxlp);        
        } else{
            dropBoxlp = new JComboBox<>(musicastodropboxlp);
        }
    }
    
    public void setaJanela(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setTitle("Lista Particular");  
        setSize(700, 500);  
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(backgroundcolor);

        ArrayList<Character> ch = new ArrayList<Character>();
        for (int i = 0; i < logado.getLogin().toString().length(); i++) {
            if (Character.isLetterOrDigit(logado.getLogin().toString().charAt(i))){
                ch.add(i, logado.getLogin().toString().charAt(i));
            }
        }
        StringBuilder filename = new StringBuilder(ch.size());
        for(Character c: ch){
            filename.append(c);
        }

        file = new File("./" + filename.toString() + ".bin");
        //System.out.println(file.getName() + " " +  filename);
        setListaPessoal(ArquivoBinario.lerArquivoListaPessoal(file.getName()));
        //System.out.println(listapessoal);
        fillDropBoxlp();
        fillDropBoxcp();
        if (listapessoal != null) listapessoal.remove(comparativa);
        
        buscaTitulosField.setBounds(15, 95, 450, 25);
        dropBoxlp.setBounds(15, 30, 450, 25);
        dropBoxcp.setBounds(15, 160, 450, 25);
        excluir.setBounds(230, 395, 225, 25);
        back.setBounds(1, 435, 682, 26);
        adiciona.setBounds(500, 160, 125, 25);
        remove.setBounds(500, 30, 125, 25);
        procura.setBounds(500, 95, 125, 25);
        label1.setBounds(15, 5, 150, 20);
        label2.setBounds(15, 70, 150, 20);
        label3.setBounds(15, 135, 150, 20);

        excluir.setForeground(Color.WHITE);
        excluir.setBackground(buttonbackgroundcolor);

        adiciona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selected = dropBoxcp.getItemAt(dropBoxcp.getSelectedIndex());
                //System.out.println("ENTROU");
                if(!logado.comparaString(selected, "...")){
                    int n = JOptionPane.showConfirmDialog(null, 
                    "Tem Certeza que Deseja Adicionar " + selected + " a sua Lista Pessoal?",
                    "Adicionar Música", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                    //System.out.println(n);
                    
                    if(n == 0){
                        //System.out.println(n);
                        Musica adicionada = new Musica();
                        for(Musica m: musicasLidascp){
                            //System.out.println(m);
                            /* System.out.println(mu.getTitulo().toString().length() + " " + selected.length());
                            System.out.println(mu.compara(mu.getTitulo().toString(), selected)); */
                            if(m.comparaArquivado(m.getTitulo().toString(), selected)){
                                adicionada = m;
                                dropBoxlp.addItem(selected);
                                JOptionPane.showMessageDialog(null, "Música Adicionada Com Sucesso",
                                "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                                //System.out.println(m + "Adicionada Com Sucesso");
                                dropBoxcp.removeItem(selected);
                                break;
                            } 
                        }
                        listapessoal.add(adicionada);
                        logado.setListaPessoal(listapessoal);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione uma Música Para Adicionar a sua Lista", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });     
        
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selected = dropBoxlp.getItemAt(dropBoxlp.getSelectedIndex());
                if(!logado.comparaString(selected, "...")){
                    int n = JOptionPane.showConfirmDialog(null, 
                    "Tem Certeza que Deseja Remover " + selected + " da sua Lista Pessoal?",
                    "Remover Música", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
                    if(n == 0){
                        Musica removida = new Musica();
                        for(Musica m: listapessoal){
                            if(m.comparaArquivado(selected, m.getTitulo())){
                                removida = m;
                                dropBoxlp.removeItem(dropBoxlp.getSelectedItem());
                                JOptionPane.showMessageDialog(null, "Música Removida com Sucesso",
                                "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                                //System.out.println(m + "Removida Com Sucesso");
                                dropBoxcp.addItem(selected);
                                break;
                            }
                        }
                        listapessoal.remove(removida);
                        logado.setListaPessoal(listapessoal);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione uma Música Para Remover de sua Lista", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ArquivoBinario.criaNovoArquivoListaPessoal(file.getName(), listapessoal);
                LoginPainel lPainel = new LoginPainel();
                dispose();
                lPainel.setVisible(true);
            }
        });
        
        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ 
                int n = JOptionPane.showConfirmDialog(null, 
                "Após esse procedimento, o usuário e sua lista pessoal de músicas serão removidos do sistema",
                "Excluir Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                
                if(n == 0){
                    //System.out.println(logado + " Excluido com Sucesso");
                    ArquivoBinario.removeUsuario(logado.getId());
                    ArquivoBinario.removeLogin(logado.getId());
                    LoginPainel loginPainel = new LoginPainel();
                    file.delete();
                    dispose();
                    loginPainel.setVisible(true);
                }
                
            }
        });

        procura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String digitado = buscaTitulosField.getText();
                boolean encontrado = false;
                for (Musica m: listapessoal){
                    if (m.comparaArquivado(m.getTitulo().toString().toLowerCase(), digitado.toLowerCase())){
                        JOptionPane.showMessageDialog(null, "A Música " + m.getTitulo() + " Encontra-se em sua Lista",
                        "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        encontrado = true;
                        break;
                    } 
                }
                if(encontrado == false)
                JOptionPane.showMessageDialog(null, "A Música " + digitado + " não se Encontra em sua Lista",
                "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        getContentPane().add(label3);
        getContentPane().add(label2);
        getContentPane().add(label1);
        getContentPane().add(excluir);
        getContentPane().add(remove);
        getContentPane().add(procura);
        getContentPane().add(adiciona);
        getContentPane().add(back);
        getContentPane().add(dropBoxcp);
        getContentPane().add(dropBoxlp);
        getContentPane().add(buscaTitulosField);
        
        addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}