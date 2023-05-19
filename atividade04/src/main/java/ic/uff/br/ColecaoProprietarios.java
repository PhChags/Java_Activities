package ic.uff.br;

public class ColecaoProprietarios {
    private int numProprietarios;
    private Proprietario[] proprietarios;
    private static final int MAX_PROP = 10;
    
        class ColecaoProprietariosIterator implements Iterator{
            private int i;
            public ColecaoProprietariosIterator(){
                this.i = 0;
            }

            @Override
            public boolean hasNext() {
                return (i<numProprietarios);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object next() {
                return proprietarios[i++];
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }
        
    public ColecaoProprietarios() {
        this.proprietarios = new Proprietario[ColecaoProprietarios.MAX_PROP];
    }
    
    public void adicionar(Proprietario proprietario){
        proprietarios[numProprietarios++] = proprietario;
    }
    
    public Iterator getIterator(){
        return new ColecaoProprietariosIterator();
    }
    
    public void imprimir(){
        Iterator it = new ColecaoProprietariosIterator();
        while (it.hasNext()){
            Proprietario prop = (Proprietario)it.next();
            prop.imprimir();
        }
    }
            
}