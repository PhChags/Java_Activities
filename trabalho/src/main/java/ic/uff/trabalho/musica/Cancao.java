package ic.uff.trabalho.musica;

public class Cancao extends Musica{
    private Letra letra;

    public Cancao(String titulo, Duracao duracao, String autores, int data, String genero, Letra letra) {
        super(titulo, duracao, autores, data, genero);
        this.letra = letra;
    }

 
    @Override
    public String toString() {
        String s = super.toString();
        return "Cancao{" + s + "letra=" + letra + '}';
    }
}
