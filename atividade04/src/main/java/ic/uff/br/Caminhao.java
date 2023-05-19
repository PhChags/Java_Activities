package ic.uff.br;

public class Caminhao extends Veiculo{
    private int numEixos;
    private float cargaMaxima;
    private float altura;

    public Caminhao(String marca, String modelo , Cor cor, String placa, int renavam,
            int potencia, int numMarchas, int numEixos, float cargaMaxima,
            float altura) {
        super(marca, modelo, cor, placa, renavam, potencia, numMarchas);
        this.numEixos = numEixos;
        this.cargaMaxima = cargaMaxima;
        this.altura = altura;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(float cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Caminhao{" + s + ", " + "numEixos=" + numEixos + ", cargaMaxima=" + 
                cargaMaxima + ", altura=" + altura + '}';
    }

    public String toCharStream() {
        String s = super.toCharStream();
        return "caminhao, " + s + ", " + numEixos + ", " + 
                cargaMaxima + ", " + altura;
    }

    
    @Override
    public void imprimir() {
        System.out.println(this.toString());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
