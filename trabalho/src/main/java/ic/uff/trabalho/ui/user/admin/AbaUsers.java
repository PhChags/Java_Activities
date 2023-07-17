package ic.uff.trabalho.ui.user.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.ui.menus.CadastroPainel;
import ic.uff.trabalho.ui.menus.LoginPainel;
import ic.uff.trabalho.usuario.Usuario;

public class AbaUsers extends JPanel{
    private Collection<Usuario> usuariosLidos;
    private JComboBox<String> dropBox;
    private Vector<String> usuariostodropbox = new Vector<String>();
    private Color backgroundcolor = new Color(209, 196, 233);  
    private Color buttoncolor = new Color(68, 138, 255);  
    private JTextField buscaNicknamesField = new JTextField();
    private JButton back = new JButton("RETURN");
    private JButton cadastra = new JButton("NOVO USUÁRIO");
    private JButton remove = new JButton("REMOVER");
    private JButton procura = new JButton("PROCURAR");
    private JLabel label1 = new JLabel("Usuários: ");
    private JLabel label2 = new JLabel("Buscar por Nicknames: ");

    
    public AbaUsers(final PaginaAdmin frame_atual, final Usuario logado){
        setUsuariosLidos(frame_atual.getUsuarios());
        fillDropBox();
        configuraAbaUsers(frame_atual, logado);
    }
    
    public void setUsuariosLidos(Collection<Usuario> usuarios){
        this.usuariosLidos = usuarios;
    }

    public void clearDropBox(){
        this.usuariostodropbox.clear();
    }

    public void fillDropBox(){
        this.usuariostodropbox.add("...");
        for (Usuario u : usuariosLidos){
            //System.out.println(logado);
            if (u.getByteVerificador() == 1){
                usuariostodropbox.add(u.getLogin().toString());
            }
        }
    }

    public void configuraAbaUsers(final PaginaAdmin frame_atual, final Usuario logado){
        usuariostodropbox.remove(logado.getLogin().toString());
        dropBox = new JComboBox<>(usuariostodropbox);

        cadastra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroPainel pagCadastro = new CadastroPainel(logado);
                frame_atual.dispose();
                pagCadastro.setVisible(true);
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
                String selected = dropBox.getItemAt(dropBox.getSelectedIndex());
                if(!logado.comparaString(selected, "...")){
                    int n = JOptionPane.showConfirmDialog(null, 
                    "Após esse procedimento, o usuário e sua lista pessoal de músicas serão removidos do sistema",
                    "Excluir Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
                    if(n == 0){
                        for(Usuario u: usuariosLidos){
                            if(u.comparaArquivado(selected, u.getLogin())){
                                ArrayList<Character> ch = new ArrayList<Character>();

                                for (int i = 0; i < u.getLogin().toString().length(); i++) {
                                    if (Character.isLetterOrDigit(u.getLogin().toString().charAt(i))){
                                        ch.add(i, u.getLogin().toString().charAt(i));
                                    }
                                }
                                StringBuilder filename = new StringBuilder(ch.size());
                                for(Character c: ch){
                                    filename.append(c);
                                }

                                ArquivoBinario.removeUsuario(u.getId());
                                ArquivoBinario.removeLogin(u.getId());
                                File file = new File("./" + filename + ".bin");
                                file.delete();
                                JOptionPane.showMessageDialog(frame_atual, "O Usuário " + u.getLogin() + " foi Excluído com Sucesso", "SUCCESS", JOptionPane.ERROR_MESSAGE);
                                dropBox.removeItem(dropBox.getSelectedItem());
                            }
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame_atual, "Selecione um Usuário Para Excluir", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        procura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String digitado = buscaNicknamesField.getText();
                boolean encontrado = false;
                for (Usuario u: usuariosLidos){
                    if (u.comparaArquivado(u.getLogin().toString(), digitado) && u.getByteVerificador() == 1){
                        JOptionPane.showMessageDialog(frame_atual, "O Usuario " + digitado + " Encontra-se Devidamente Registrado no Sistema ",
                        "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        encontrado = true;
                        break;
                    } 
                }
                if(encontrado == false)
                    JOptionPane.showMessageDialog(frame_atual, "Não Existem Registros do Usuário " + digitado + " no Sistema",
                    "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        label2.setBounds(15, 70, 150, 20);
        buscaNicknamesField.setBounds(15, 95, 450, 25);
        dropBox.setBounds(15, 30, 450, 25);
        label1.setBounds(15, 5, 70, 20);
        remove.setBounds(500, 30, 125, 25);
        procura.setBounds(500, 95, 125, 25);
        cadastra.setBounds(230, 367, 225, 25);
        back.setBounds(0, 407, 679, 26);

        setLayout(null);
        cadastra.setBackground(buttoncolor);
        setBackground(backgroundcolor);
        
        add(back);
        add(cadastra);
        add(remove);
        add(procura);
        add(label1);
        add(label2);
        add(dropBox);
        add(buscaNicknamesField);
    }
}