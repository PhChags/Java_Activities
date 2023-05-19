import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenciaBinariaProduto {
    private static final int TAM_REG_PROD = 56;
    private static final int TAM_NOME = 40;
    private static final int POS_NOME_PROD = 0;
    private static final int POS_COD_PROD = 40;
    private static final int POS_PRECO_PROD = 44;
    private static final int POS_QUANT_PROD = 52;
    
    public PersistenciaBinariaProduto(){};
    
    public static void salvar_produtos(Collection<Produto> produtos,String nomeArq){
        try {
            FileOutputStream fw = new FileOutputStream("produtos.bin");
            DataOutputStream dw = new DataOutputStream(fw);
            
            // Para escrever umr registro criamos um array de bytes do com tamanho
            // igual a soma dos bytes dos tipos no registro
            byte[] b = new byte[56];
  
            for (Produto p:produtos){    
                // Inicializamos o array de bytes com 0
                Arrays.fill(b, (byte)0);
                // Criamos um objeto ByteBuffer que permite métodos para
                // converter tipos em bytes

                ByteBuffer bb = ByteBuffer.wrap(b);

                // Convertemos a String em bytes
                byte[] bNome = p.getNome().getBytes();

                // Copiamos os caracteres da string para a posicao 0 do ByteBuffer
                bb.put(POS_NOME_PROD, bNome);
                // Colocamos os bytes do inteiro codigo a partir do byte 40

                bb.putInt(POS_COD_PROD, p.getCod());
                // Colocamos os bytes do float preco a partir do byte 44
                bb.putFloat(POS_PRECO_PROD, p.getPreco());
                // Colocamos os bytes do float preco a partir do byte 52
                bb.putInt(POS_QUANT_PROD, p.getQuantidade());

                dw.write( bb.array());       
            }
            
            fw.close();
            dw.close();
           
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public static Collection<Produto> ler(String nomeArq){
        Collection<Produto> produtos = new ArrayList<Produto>();
        
        try {
            FileInputStream fw = new FileInputStream("produtos.bin");
            DataInputStream dw = new DataInputStream(fw);
            ByteBuffer bb = ByteBuffer.allocate(TAM_REG_PROD);
            byte[] b = new byte[TAM_REG_PROD];
            boolean eof = false;
            
            do{    
                try {       
                    if (dw.read(b, 0, TAM_REG_PROD)==-1){
                        eof = true;
                    }
                    else{
                        String nome = new String(b,0,TAM_NOME);
                        int codigo = ByteBuffer.wrap(b).getInt(POS_COD_PROD);
                        float preco = ByteBuffer.wrap(b).getFloat(POS_PRECO_PROD);
                        int quantidade = ByteBuffer.wrap(b).getInt(POS_QUANT_PROD);
                        
                        produtos.add(new Produto(nome,codigo,preco,quantidade));
                        //System.out.println(nome+" "+codigo+" "+preco+" "+quantidade);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }while (!eof);
            
            try {
                fw.close();
                dw.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (produtos.isEmpty()){
            return null;
        }
        else{
            return produtos;
        }
    }
    
    public static Produto lerRegistroPos(String nomeArq, int pos){
        RandomAccessFile ra;
        
        try {
            //Cria um arquivo de acesso direto
            ra = new RandomAccessFile(nomeArq,"r");
            //Coloca o cursor no terceiro no quarto registro (salta os 3 registros anteriores)
            ra.seek((pos-1)*TAM_REG_PROD);
            byte[] b = new byte[TAM_REG_PROD];
            //Le o registro
            ra.read(b, 0, TAM_REG_PROD);
            //Pega os dados do registro
            String nome = new String(b,0,TAM_NOME);
            int codigo = ByteBuffer.wrap(b).getInt(POS_COD_PROD);
            float preco = ByteBuffer.wrap(b).getFloat(POS_PRECO_PROD);
            int quantidade = ByteBuffer.wrap(b).getInt(POS_QUANT_PROD);
            Produto p = new Produto(nome,codigo,preco,quantidade);
            //System.out.println(nome+" "+codigo+" "+preco+" "+quantidade);
            ra.close();
            return p;
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

        public static void escreveRegistroPos(String nomeArq, int pos, 
                String nome,int codigo,float preco, int quantidade){
        RandomAccessFile ra;
        
        try {
            //Cria um arquivo de acesso direto
            ra = new RandomAccessFile(nomeArq,"rw");
            //Coloca o cursor no terceiro no quarto registro (salta os 3 registros anteriores)
            ra.seek((pos-1)*TAM_REG_PROD);
            byte[] b = new byte[TAM_REG_PROD];
            //Le o registro
       
  
            Arrays.fill(b, (byte)0);
            // Criamos um objeto ByteBuffer que permite métodos para
            // converter tipos em bytes

            ByteBuffer bb = ByteBuffer.wrap(b);

            // Convertemos a String em bytes
   
            // Copiamos os caracteres da string para a posicao 0 do ByteBuffer
            bb.put(POS_NOME_PROD,nome.getBytes() );
            // Colocamos os bytes do inteiro codigo a partir do byte 40
            bb.putInt(POS_COD_PROD, codigo);
            // Colocamos os bytes do float preco a partir do byte 44
            bb.putFloat(POS_PRECO_PROD, preco);
            // Colocamos os bytes do float preco a partir do byte 52
            bb.putInt(POS_QUANT_PROD,quantidade);
            ra.write( bb.array());       

            ra.close();
                
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}