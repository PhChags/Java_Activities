import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main( String[] args ){
        Collection<Produto> produtos = new ArrayList<Produto>();
        
        produtos.add(new Produto("arroz",13,10.0f,100));
        produtos.add(new Produto("ovos",21,16.0f,80));
        produtos.add(new Produto("feijao",34,13.0f,100));
        produtos.add(new Produto("maca",36,8.0f,120));
        produtos.add(new Produto("iogurte",42,8.0f,30));
        produtos.add(new Produto("leite",46,6.0f,80));
        produtos.add(new Produto("carne",56,60.0f,30));
        produtos.add(new Produto("macarrao",62,5.0f,100));
        produtos.add(new Produto("laranja",65,6.0f,200));
        
        System.out.println("Salvando arquivo binario "+"produtos.bin");
        PersistenciaBinariaProduto.salvar_produtos(produtos, "produtos.bin");
        
        System.out.println("Lendo arquivo binario "+"produtos.bin");
        Collection<Produto> produtosLidos = PersistenciaBinariaProduto.ler("produtos.bin");
        
        for (Produto p:produtosLidos){
            System.out.println(p);
        }
              
        System.out.println("Alterando registro 4");
        PersistenciaBinariaProduto.escreveRegistroPos("produtos.bin", 4, "cerveja", 100, 5.0f, 500);
        
        System.out.println("Lendo registro na posicao 4 diretamente");
        Produto p = PersistenciaBinariaProduto.lerRegistroPos("produtos.bin",4);
        System.out.println(p);
        
        
        Collection<Produto> produtosModificados = PersistenciaBinariaProduto.ler("produtos.bin");
        System.out.println("Arquivo modificado " + "produtos.bin");
        for (Produto pm:produtosModificados){
            System.out.println(pm);
        }
    }
}