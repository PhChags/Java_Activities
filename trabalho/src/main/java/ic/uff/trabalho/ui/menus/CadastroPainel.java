package ic.uff.trabalho.ui.menus;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.musica.Musica;
import ic.uff.trabalho.ui.user.admin.PaginaAdmin;
import ic.uff.trabalho.usuario.Usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;

public class CadastroPainel extends JDialog implements ActionListener{
    private JTextField nameField = new JTextField(15);
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private Color backgroundcolor = new Color(209, 196, 233);
    private JLabel nome = new JLabel("Nome:");
    private JLabel user = new JLabel("User:");
    private JLabel password = new JLabel("Senha:");
    private JButton submit = new JButton("DONE");
    private JButton back = new JButton("RETURN");
    private JCheckBox adminBox = new JCheckBox("Admin:", false);
    private Collection<Usuario> loginsLidos = ArquivoBinario.lerArquivoLogins();
    private Collection<Usuario> usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
    
    public CadastroPainel() {
        super();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setTitle("Cadastro");
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(backgroundcolor);

        getContentPane().add(nome);
        getContentPane().add(nameField);
        getContentPane().add(user);
        getContentPane().add(userField);
        getContentPane().add(password);
        getContentPane().add(passField);
        getContentPane().add(submit);
        getContentPane().add(back);

        nome.setBounds(250, 125, 70, 20);
        nameField.setBounds(250, 150, 193, 28);
        user.setBounds(250, 180, 70, 20);
        userField.setBounds(250, 205, 193, 28);
        password.setBounds(250, 235, 193, 20);
        passField.setBounds(250, 260, 193, 28);
        submit.setBounds(225, 325, 110, 25);
        back.setBounds(350, 325, 110, 25);

        submit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        back.setBackground(Color.BLACK);

        submit.addActionListener(this);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LoginPainel lPainel = new LoginPainel();
                dispose();
                lPainel.setVisible(true);
            }
        });

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public CadastroPainel(final Usuario usuariologado){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setTitle("Cadastro");
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(backgroundcolor);

        getContentPane().add(nome);
        getContentPane().add(nameField);
        getContentPane().add(user);
        getContentPane().add(userField);
        getContentPane().add(password);
        getContentPane().add(passField);
        getContentPane().add(submit);
        getContentPane().add(back);
        getContentPane().add(adminBox);

        nome.setBounds(250, 125, 70, 20);
        nameField.setBounds(250, 150, 193, 28);
        user.setBounds(250, 180, 70, 20);
        userField.setBounds(250, 205, 193, 28);
        password.setBounds(250, 235, 193, 20);
        passField.setBounds(250, 260, 193, 28);
        submit.setBounds(225, 355, 110, 25);
        back.setBounds(350, 355, 110, 25);
        adminBox.setBounds(250, 305, 110, 25);

        adminBox.setBackground(backgroundcolor);
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
        String nome = nameField.getText();
        String user = userField.getText();
        char[] passwordChars = passField.getPassword();
        String senha = new String(passwordChars);
        boolean cadastrado = false;

        ArrayList<Character> ch = new ArrayList<Character>();
        for (int i = 0; i < user.length(); i++) {
            if (Character.isLetterOrDigit(user.charAt(i)) && !Character.isSpaceChar(user.charAt(i))){
                ch.add(i, user.charAt(i));
            }
        }
        StringBuilder userformatado = new StringBuilder(ch.size());
        for(Character c: ch){
            userformatado.append(c);
        }
        String userfinal = new String(userformatado);

        if (!userfinal.isEmpty() && !senha.isEmpty() && !nome.isEmpty()){
            if (userfinal.length() < 16 && nome.length() < 16 && senha.length() < 16){
                for(Usuario u: usuariosLidos){
                    //System.out.println(u);
                    if(u.comparaArquivado(u.getLogin().toString(), userfinal.toString())){
                        JOptionPane.showMessageDialog(this, "Usuário Já Cadastrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                        cadastrado = true;
                        break;
                    }
                }
                for(Usuario u: usuariosLidos){
                    if(u.getByteVerificador() == 0 && !cadastrado){
                        //System.out.println(u);
                        JOptionPane.showMessageDialog(this, "Usuário Cadastrado Com Sucesso", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        if (adminBox.isSelected()){
                            String tipo = "admin";                           
                            ArquivoBinario.criaNovoUsuarioPos(nome, userfinal, senha, tipo, u.getId());
                            ArquivoBinario.criaNovoLoginPos(userfinal, senha, tipo, u.getId());
                            ArquivoBinario.criaNovoArquivoListaPessoal(userfinal + ".bin", u.getListapessoal());
                            usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
                            loginsLidos = ArquivoBinario.lerArquivoLogins();
                            cadastrado = true;
                            break;
                        } else {
                            String tipo = "normal";
                            ArquivoBinario.criaNovoUsuarioPos(nome, userfinal, senha, tipo, u.getId());
                            ArquivoBinario.criaNovoLoginPos(userfinal, senha, tipo, u.getId());
                            ArquivoBinario.criaNovoArquivoListaPessoal(userfinal + ".bin", u.getListapessoal());
                            usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
                            loginsLidos = ArquivoBinario.lerArquivoLogins();
                            cadastrado = true;
                            break;
                        }
                    }
                }
                
                if(!cadastrado){
                    Collection<Musica> m = new ArrayList<Musica>();
                    if (adminBox.isSelected()){
                        String tipo = "admin";
                        ArquivoBinario.criaNovoUsuario(nome, userfinal, senha, tipo, usuariosLidos.size());
                        ArquivoBinario.criaNovoLogin(userfinal, senha, tipo, loginsLidos.size());
                        ArquivoBinario.criaNovoArquivoListaPessoal(userfinal + ".bin", m);
                        usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
                        loginsLidos = ArquivoBinario.lerArquivoLogins();
                        JOptionPane.showMessageDialog(this, "Usuário Cadastrado Com Sucesso", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        String tipo = "normal";
                        ArquivoBinario.criaNovoUsuario(nome, userfinal, senha, tipo, usuariosLidos.size());
                        ArquivoBinario.criaNovoLogin(userfinal, senha, tipo, loginsLidos.size());
                        ArquivoBinario.criaNovoArquivoListaPessoal(userfinal + ".bin", m);
                        usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
                        loginsLidos = ArquivoBinario.lerArquivoLogins();
                        JOptionPane.showMessageDialog(this, "Usuário Cadastrado Com Sucesso", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Os Campos Devem Possuir no Máximo 15 Caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Todos os Campos Devem ser Preenchidos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
