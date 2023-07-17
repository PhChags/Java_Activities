package ic.uff.trabalho.ui.menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.musica.Duracao;
import ic.uff.trabalho.musica.Musica;
import ic.uff.trabalho.ui.user.admin.PaginaAdmin;
import ic.uff.trabalho.usuario.Usuario;

public class AdicionaMusica extends JDialog implements ActionListener{
    private Color backgroundcolor = new Color(209, 196, 233);
    private JTextField titleField = new JTextField(15);
    private JTextField autorField = new JTextField(15);
    private JTextField yearField = new JTextField(15);
    private JTextField duracaoField = new JTextField(15);
    private JTextField typeField = new JTextField(15);
    private JLabel titulo = new JLabel("Título:");
    private JLabel autor = new JLabel("Autores:");
    private JLabel ano = new JLabel("Ano de Lançamento:");
    private JLabel duracao = new JLabel("Duracao (min:seg):");
    private JLabel type = new JLabel("Gênero:");
    private JButton submit = new JButton("DONE");
    private JButton back = new JButton("RETURN");
    private Collection<Musica> musicasLidas = ArquivoBinario.lerArquivoMusicas();

    public AdicionaMusica(final Usuario usuariologado){
        super();
        setJanela(usuariologado);
    }

    public void setMusicasLidas(Collection<Musica> musicas){
        this.musicasLidas = musicas;
    }

    public void setJanela(final Usuario usuariologado){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setTitle("Adiciona Música");
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(backgroundcolor);

        getContentPane().add(titulo);
        getContentPane().add(titleField);
        getContentPane().add(autor);
        getContentPane().add(autorField);
        getContentPane().add(ano);
        getContentPane().add(yearField);
        getContentPane().add(submit);
        getContentPane().add(back);
        getContentPane().add(duracao);
        getContentPane().add(duracaoField);
        getContentPane().add(type);
        getContentPane().add(typeField);

        titulo.setBounds(250, 75, 70, 20);
        titleField.setBounds(250, 100, 193, 28);
        autor.setBounds(250, 130, 70, 20);
        autorField.setBounds(250, 155, 193, 28);
        ano.setBounds(250, 185, 193, 20);
        yearField.setBounds(250, 210, 193, 28);
        duracao.setBounds(250, 240, 193, 25);
        duracaoField.setBounds(250, 265, 193, 25);
        type.setBounds(250, 295, 193, 25);
        typeField.setBounds(250, 320, 193, 25);
        submit.setBounds(225, 355, 110, 25);
        back.setBounds(350, 355, 110, 25);

        submit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        back.setBackground(Color.BLACK);
        
        submit.addActionListener(this);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                PaginaAdmin paginaAdmin = new PaginaAdmin(usuariologado);
                dispose();
                paginaAdmin.setVisible(true);
            }
        });

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = titleField.getText();
        String autores = autorField.getText();
        String genero = typeField.getText();
        String anoString = yearField.getText();
        String duracaoString = duracaoField.getText();
        boolean cadastrado = false;

        ArrayList<Character> ch = new ArrayList<Character>();
        for (int i = 0; i < titulo.length(); i++) {
            if (Character.isLetterOrDigit(titulo.charAt(i)) && !Character.isSpaceChar(titulo.charAt(i))){
                ch.add(i, titulo.charAt(i));
            }
        }
        StringBuilder tituloformatado = new StringBuilder(ch.size());
        for(Character c: ch){
            tituloformatado.append(c);
        }
        String titulofinal = new String(tituloformatado);
        
        if(!titulofinal.isEmpty() && !autores.isEmpty() && !anoString.isEmpty() && !duracaoString.isEmpty() && !genero.isEmpty()){
            if(titulofinal.length() < 31 && autores.length() < 31 && genero.length() < 31){
                if(anoString.length() < 5){
                    if(duracaoString.length() < 6){
                        int anoInt = Integer.parseInt(anoString);
    
                        String arraytemp[] = new String[2];
                        arraytemp = duracaoString.split(":");
                        int min, seg;
                        min = Integer.parseInt(arraytemp[0]);
                        seg = Integer.parseInt(arraytemp[1]);
                        Duracao tempo = new Duracao(min, seg);

                        for(Musica m: musicasLidas){
                            if(m.comparaArquivado(m.getTitulo().toString(), titulofinal.toString())){
                                JOptionPane.showMessageDialog(this, "Música já se Encontra na Coleção Principal", "ERROR", JOptionPane.ERROR_MESSAGE);
                                cadastrado = true;
                                break;
                            }
                        }
                        for(Musica m: musicasLidas){
                            if(m.getByteVerificador() == 0){
                                JOptionPane.showMessageDialog(this, "Música Adicionada Com Sucesso", "SUCCESS", JOptionPane.PLAIN_MESSAGE); 
                                ArquivoBinario.criaNovaMusicaPos(titulofinal, tempo, autores, anoInt, genero, m.getId());
                                musicasLidas = ArquivoBinario.lerArquivoMusicas();
                                cadastrado = true;
                                break;
                            }
                        }
                        if(!cadastrado){
                            ArquivoBinario.criaNovaMusica(titulofinal, tempo, autores, anoInt, genero, musicasLidas.size());
                            musicasLidas = ArquivoBinario.lerArquivoMusicas();
                            JOptionPane.showMessageDialog(this, "Música Adicionada Com Sucesso", "SUCCESS", JOptionPane.PLAIN_MESSAGE); 
                        }
                    }
                    else{JOptionPane.showMessageDialog(this, "Duracao Inválida", "ERROR", JOptionPane.ERROR_MESSAGE);}
                }
                else{JOptionPane.showMessageDialog(this, "Ano Inválido", "ERROR", JOptionPane.ERROR_MESSAGE);}
            }
            else{JOptionPane.showMessageDialog(this, "Os Campos Título, Autores e Gênero Devem Possuir no Máximo 30 Caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);}
        }
        else{
            JOptionPane.showMessageDialog(this, "Todos os Campos Devem ser Preenchidos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }   
    }   
}