package ic.uff.br;

public abstract class Veiculo implements Imprimivel {

    public enum Cor{cinza, branco, azul, vermelho, preto, amarelo,verde};

    private String marca;
    private String modelo;
    private Cor cor;
    private String placa;
    private int renavam;
    private int potencia;
    private int numMarchas;

    public Veiculo(String marca, String modelo, Cor cor, String placa, int renavam, int potencia, int numMarchas) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.renavam = renavam;
        this.potencia = potencia;
        this.numMarchas = numMarchas;
    }

    public static Cor StringToCor(String s){
        Cor cor = null;
        if (s.compareTo("amarelo")==0){
            return Cor.amarelo;
        }
        else if (s.compareTo("azul")==0){
            return Cor.azul;
        }
        else if (s.compareTo("branco")==0){
            return Cor.branco;
        }
        else if (s.compareTo("cinza")==0){
            return Cor.cinza;
        }
        else if (s.compareTo("verde")==0){
            return Cor.verde;
        }
        else if (s.compareTo("vermelho")==0){
            return Cor.vermelho;
        }
        return null;
    }
   
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNumMarchas() {
        return numMarchas;
    }

    public void setNumMarchas(int numMarchas) {
        this.numMarchas = numMarchas;
    }

    @Override
    public String toString() {
        return "marca=" + marca + ",modelo=" + modelo + ",cor=" + cor + ", placa=" + placa + ", renavam=" + renavam + ", potencia=" + potencia + ", numMarchas=" + numMarchas;
    }
    
    public String toCharStream(){
        return marca + ", " + modelo + ", " + cor + ", " + placa + ", " + renavam + ", " + potencia + ", " + numMarchas;
    }
}