package ic.uff.br;

public class ColecaoVeiculos implements Imprimivel {
    private int numVeiculos;
    private Veiculo[] veiculos;
    private final static int MAX_VEICULOS = 10;

    
    class ColecaoVeiculosIterator implements Iterator{
        private int i;
        public ColecaoVeiculosIterator(){
            this.i = 0;
        }

        @Override
        public boolean hasNext() {
            return (i<numVeiculos);
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Object next() {
            return veiculos[i++];
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    public ColecaoVeiculos(){
        this.veiculos = new Veiculo[ColecaoVeiculos.MAX_VEICULOS];
    };
    
    public void adicionar(Veiculo veiculo){
        veiculos[numVeiculos++] = veiculo;
    }
    
    public Iterator getIterator(){
        return new ColecaoVeiculosIterator();
    }

        @Override
    public void imprimir() {
        Iterator it = new ColecaoVeiculosIterator();
        while (it.hasNext()){
            Veiculo v = (Veiculo)it.next();
            v.imprimir();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }        
}