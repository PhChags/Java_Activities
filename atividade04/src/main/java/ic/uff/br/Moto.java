package ic.uff.br;

public class Moto extends Veiculo {
    public Moto(String marca, String modelo, Cor cor, String placa, int renavam, int potencia, int numMarchas) {
        super(marca, modelo, cor, placa, renavam, potencia, numMarchas);
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Moto{" + s + '}';
    }    

    public String toCharStream() {
        String s = super.toCharStream();
        return "moto, " + s;
    }        
    @Override
    public void imprimir() {
        System.out.println(this.toString());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
