package ic.uff.trabalho.ui.user.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.musica.Musica;
import ic.uff.trabalho.ui.menus.AdicionaMusica;
import ic.uff.trabalho.ui.menus.AtualizaMusica;
import ic.uff.trabalho.ui.menus.LoginPainel;
import ic.uff.trabalho.usuario.Usuario;

public class AbaMusicas extends JPanel{
    private JButton back = new JButton("RETURN");
    private JButton addmusica = new JButton("NOVA MÚSICA");
    private JButton atualiza = new JButton("ATUALIZAR");
    private JButton remove = new JButton("REMOVER");
    private JButton procura = new JButton("PROCURAR");
    private JLabel label1 = new JLabel("Remover Música: ");
    private JLabel label2 = new JLabel("Buscar por Títulos: ");
    private JLabel label3 = new JLabel("Atualizar Música: ");
    private JTextField buscaTitulosField = new JTextField();
    private Color backgroundcolor = new Color(209, 196, 233);  
    private Color buttoncolor = new Color(68, 138, 255);  
    private Vector<String> musicastodropbox = new Vector<String>();
    private Collection<Musica> musicasLidas;
    private JComboBox<String> dropBox1;
    private JComboBox<String> dropBox2;
    private Usuario comparador = new Usuario();
    
    public AbaMusicas(final PaginaAdmin frame_atual){
        setMusicasLidas(frame_atual.getMusicas());
        configuraAbaMusicas(frame_atual);
    }
    
    public void setMusicasLidas(Collection<Musica> musicas){
        this.musicasLidas =  musicas;
    }

    public void configuraAbaMusicas(final PaginaAdmin frame_atual){
        musicastodropbox.add("...");
        for (Musica m : musicasLidas){
            if (m.getByteVerificador() == 1) musicastodropbox.add(m.getTitulo().toString());
        }
        dropBox1 = new JComboBox<>(musicastodropbox);
        dropBox2 = new JComboBox<>(musicastodropbox);
        
        addmusica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                AdicionaMusica pagAdiciona = new AdicionaMusica(frame_atual.getUsuarioLogado());
                frame_atual.dispose();
                pagAdiciona.setVisible(true);
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LoginPainel lPainel = new LoginPainel();
                frame_atual.dispose();
                lPainel.setVisible(true);
            }
        });

        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selected = dropBox1.getItemAt(dropBox1.getSelectedIndex());
                if(!comparador.comparaString(selected, "...")){
                    int n = JOptionPane.showConfirmDialog(null, 
                    "Após esse procedimento, a música será removida da coleção principal",
                    "Excluir Música", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
                    if(n == 0){
                        Musica removida = new Musica();
                        for(Musica m: musicasLidas){
                            if(m.comparaArquivado(selected, m.getTitulo())){
                                ArquivoBinario.removeMusica(m.getId());
                                //System.out.println(m + " Excluida com Sucesso");
                                dropBox1.removeItem(dropBox1.getSelectedItem());
                                removida = m;
                                for(Usuario u: frame_atual.getUsuarios()){if (u.getListapessoal().contains(removida)) u.getListapessoal().remove(removida);}
                                break;
                            }
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame_atual, "Selecione uma Música Para Excluir", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        procura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String digitado = buscaTitulosField.getText();
                boolean encontrado = false;
                for (Musica m: musicasLidas){
                    if (m.comparaArquivado(m.getTitulo().toString().toLowerCase(), digitado.toLowerCase())){
                        JOptionPane.showMessageDialog(frame_atual, "A Música " + m.getTitulo().toString() + " Encontra-se na Coleção Principal",
                        "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        encontrado = true;
                        break;
                    } 
                }
                if(encontrado == false)
                    JOptionPane.showMessageDialog(frame_atual, "A Música " + digitado + " não se Encontra na Coleção Principal",
                    "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        atualiza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selected = dropBox2.getItemAt(dropBox2.getSelectedIndex());
                if(!comparador.comparaString(selected, "...")){
                    for(Musica m: musicasLidas){
                        if(m.comparaArquivado(selected, m.getTitulo())){
                            AtualizaMusica pagAtualizaMusica = new AtualizaMusica(frame_atual.getUsuarioLogado(), m);
                            frame_atual.dispose();
                            pagAtualizaMusica.setVisible(true);
                            break;
                        }
                    }
                }
            }
        });
        
        label1.setBounds(15, 5, 150, 20);
        label2.setBounds(15, 75, 150, 20);
        label3.setBounds(15, 140, 150, 20);
        dropBox1.setBounds(15, 30, 450, 25);
        dropBox2.setBounds(15, 160, 450, 25);
        buscaTitulosField.setBounds(15, 95, 450, 25);
        remove.setBounds(500, 30, 125, 25);
        atualiza.setBounds(500, 160, 125, 25);
        procura.setBounds(500, 95, 125, 25);
        addmusica.setBounds(230, 367, 225, 25);
        back.setBounds(0, 407, 679, 26);
        
        setLayout(null);
        setBackground(backgroundcolor);
        addmusica.setBackground(buttoncolor);
        
        add(back);
        add(addmusica);
        add(remove);
        add(atualiza);
        add(procura);
        add(label1);
        add(label2);
        add(label3);
        add(dropBox1);
        add(dropBox2);
        add(buscaTitulosField);
    }
}