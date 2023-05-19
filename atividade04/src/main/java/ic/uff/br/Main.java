package ic.uff.br;

/**
 * 
 * @author Pehper
 */
public class Main {
    public static void main( String[] args ) {
        java.util.Locale.setDefault (java.util.Locale.ENGLISH);
        ColecaoVeiculos colVeiculos = new ColecaoVeiculos();
        ColecaoProprietarios colProprietarios = new ColecaoProprietarios();
        
        PersistenciaColecaoVeiculos.carregar(colVeiculos, "veiculos.txt");
        /*
        Automovel aut0 = new Automovel("Force", "Lightray", Veiculo.Cor.amarelo,"RAX4455",123456,
                105,6,5);
        Automovel aut1 = new Automovel("Energy", "Warrior", Veiculo.Cor.cinza,"PAX4325",123321,
                105,6,5);
        Caminhao cam0 = new Caminhao("Force","SuperCharger",Veiculo.Cor.preto, "PQR2345",343434,2000,6,3,10.0f,3.3f);
        Moto mot0 = new Moto("Power", "Samurai", Veiculo.Cor.azul , "ABC2343", 232323, 800,6);
        */
        
        Proprietario prop0 = new Proprietario("Anselmo Antunes Montenegro",111,222,1);
        Proprietario prop1 = new Proprietario("Jose Silva",111,222,1);
        
        //colVeiculos.adicionar(aut0);
        //colVeiculos.adicionar(aut1);
        //colVeiculos.adicionar(cam0);
        //colVeiculos.adicionar(mot0);
        
        colVeiculos.imprimir();
        
        colProprietarios.adicionar(prop0);
        colProprietarios.adicionar(prop1);
        
        colProprietarios.imprimir();
        
        PersistenciaColecaoVeiculos.salvar(colVeiculos, "veiculos.txt");
        
        /*
        Imprimivel[] lista = new Imprimivel[2];
        lista[0] = aut0;
        lista[1] = prop0;
        
        for (Imprimivel obj:lista){
            obj.imprimir();
        }
        */
    }
}
