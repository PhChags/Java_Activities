package ic.uff.trabalho.ui.menus;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.ui.user.admin.PaginaAdmin;
import ic.uff.trabalho.ui.user.normal.PaginaUserNormal;
import ic.uff.trabalho.usuario.Usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

public class LoginPainel extends JDialog implements ActionListener {
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private JCheckBox adminBox = new JCheckBox("Admin:", false);
    private Color backgroundcolor = new Color(209, 196, 233);
    private JLabel username = new JLabel("Username:");
    private JLabel password = new JLabel("Password:");
    private JButton cadastro = new JButton("CADASTRAR");
    private JButton submit = new JButton("DONE");
    private Collection<Usuario> usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
    
    public LoginPainel() {
        super();
        setJanela();
    }

    public void setJanela(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setTitle("Login");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(backgroundcolor);
        
        
        username.setBounds(250, 125, 70, 20);
        userField.setBounds(250, 150, 193, 28);
        password.setBounds(250, 180, 70, 20);
        passField.setBounds(250, 205, 193, 28);
        submit.setBounds(225, 300, 110, 25);
        cadastro.setBounds(350, 300, 110, 25);
        adminBox.setBounds(250, 250, 70, 25);
        
        adminBox.setBackground(backgroundcolor);
        submit.setForeground(Color.WHITE);
        cadastro.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        cadastro.setBackground(Color.BLACK);
        
        getContentPane().add(username);
        getContentPane().add(userField);
        getContentPane().add(password);
        getContentPane().add(passField);
        getContentPane().add(adminBox);

        getContentPane().add(submit);
        getContentPane().add(cadastro);
        
        submit.addActionListener(this);
        cadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroPainel pagCadastro = new CadastroPainel();
                setVisible(false);
                pagCadastro.setVisible(true);
            }
        });
        //pack();

        addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public Collection<Usuario> getUsuariosLidos() {
        return this.usuariosLidos;
    }
    public Collection<Usuario> getLoginsLidos() {
        return this.usuariosLidos;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String user = userField.getText();
        char[] passwordChars = passField.getPassword();
        String senha = new String(passwordChars);
        boolean estado = false;
        
        if(!user.isEmpty() || !senha.isEmpty()){
            for(Usuario u: usuariosLidos){
                /* System.out.println();*/
                //System.out.println(u);  
                if(u.getByteVerificador() == 1){
                    if(u.comparaArquivado(u.getLogin().toString(), user.toString()) && u.comparaArquivado(u.getSenha().toString(), senha.toString())){    
                        if (adminBox.isSelected() && u.comparaArquivado(u.getTipo().toString(), "admin")){
                            PaginaAdmin pagAdmin = new PaginaAdmin(u);
                            dispose();
                            pagAdmin.setVisible(true);
                            estado = true;
                            break;
                        }
                        else if(adminBox.isSelected()){
                            estado = true;
                            JOptionPane.showMessageDialog(this, "Usuário Não Possui Permissão Admin", "ERROR", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        else{
                            PaginaUserNormal pagNormal = new PaginaUserNormal(u);
                            dispose();
                            pagNormal.setVisible(true);
                            estado = true;
                            break;
                        }
                    }
                }
            }

            if(!estado) JOptionPane.showMessageDialog(this, "Usuário ou Senha Incorretos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else JOptionPane.showMessageDialog(this, "Todos os Campos Devem ser Preenchidos", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}