package ic.uff.br;

public class Carro extends Veiculo {
    private int numPassageiros;

    public Carro(String marca, String modelo, Cor cor, String placa, int renavam, int potencia, int numMarchas, int numPassageiros) {
        super(marca, modelo, cor, placa, renavam, potencia, numMarchas);
        this.numPassageiros = numPassageiros;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Carro{" + s + ", " + "numPassageiros=" + numPassageiros + '}';
    }

    public String toCharStream() {
        String s = super.toCharStream();
        return "Carro, " + s + ", " + numPassageiros;
    }

    
    @Override
    public void imprimir() {
        System.out.println(this.toString());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}