package ic.uff.trabalho;

import java.io.File;

import javax.swing.JOptionPane;

import ic.uff.trabalho.arquivador.ArquivoBinario;
import ic.uff.trabalho.ui.menus.LoginPainel;

/**
 * @author pehper
 *
 */
public class Main 
{
    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }
    public static void main( String[] args )
    {
        File file1 = new File("./login.enc");
        File file2 = new File("./musicas.bin");
        File file3 = new File("./usuarios.bin");
        
        if (isFileExists(file1) && isFileExists(file2) && isFileExists(file3)) {
            System.out.println("File exists!!");
        } else{
            System.out.println("File doesn't exist or program doesn't have access to the file!!");
            System.out.println("Creating the file...");
            ArquivoBinario.criaArquivoBinario();
        }
        
/*         Collection<Usuario> usuariosLidos = ArquivoBinario.lerArquivoUsuarios();
        Collection<Usuario> loginsLidos = ArquivoBinario.lerArquivoLogins();
        Collection<Musica> musicasLidas = ArquivoBinario.lerArquivoMusicas();
        for (Usuario u: usuariosLidos) System.out.println(u);
        System.out.println();
        for (Musica m: musicasLidas) System.out.println(m);
        System.out.println();
        for (Usuario l: loginsLidos) System.out.println(l); */

        try  {  
            LoginPainel lPainel = new LoginPainel();    
            lPainel.setVisible(true);  
        }  
        catch(Exception e)  {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }
}
