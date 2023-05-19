package ic.uff.br;

public class Proprietario implements Imprimivel {
    private String nome;
    private int cpf;
    private int rg;
    private int numVeiculos;
    private Veiculo[] veiculos;

    public Proprietario(String nome, int cpf, int rg, int numVeiculos) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.numVeiculos = numVeiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getNumVeiculos() {
        return numVeiculos;
    }

    public void setNumVeiculos(int numVeiculos) {
        this.numVeiculos = numVeiculos;
    }

    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return "Proprietario{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", numVeiculos=" + numVeiculos + '}';
    }
    
    

    @Override
    public void imprimir() {
        System.out.println(this.toString());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}