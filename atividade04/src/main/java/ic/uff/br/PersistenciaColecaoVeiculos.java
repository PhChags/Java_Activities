package ic.uff.br;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class PersistenciaColecaoVeiculos {
    public static void salvar(ColecaoVeiculos colVeiculos, String nomeArq){
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(nomeArq);
            pw = new PrintWriter(fw);
            Iterator it = colVeiculos.getIterator();
            while (it.hasNext()){
                Veiculo v = (Veiculo)it.next();
                pw.println(v.toCharStream());
            }
            fw.close();
            pw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaColecaoVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void carregar(ColecaoVeiculos colVeiculos, String nomeArq){
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(nomeArq);
            br = new BufferedReader(fr);
            
            boolean eof = false;
            
            do{
                String s = br.readLine();
                if (s==null){
                    eof = true;
                }
                else{
                    
                    Scanner sn = new Scanner(s); 
                    sn.useDelimiter(",");
                    String tipo = sn.next();
                    String marca = sn.next();
                    String modelo = sn.next();
                    String corString = sn.next();
                    String placa = sn.next();
                    int renavam = Integer.parseInt(sn.next().trim());
                    int potencia = Integer.parseInt(sn.next().trim());
                    int numMarchas = Integer.parseInt(sn.next().trim());
                    sn.close();
                    
                    if (tipo.compareTo("carro")==0){
                        int numPassageiros = Integer.parseInt(sn.next().trim());
                        Veiculo.Cor cor = Veiculo.StringToCor(corString);
                        Carro aut = new Carro(marca,modelo,cor,placa,renavam,potencia,numMarchas,numPassageiros);
                        colVeiculos.adicionar(aut);
                    }
                    else if (tipo.compareTo("caminhao")==0){
                        int numEixos = Integer.parseInt(sn.next().trim());
                        float cargaMaxima = Float.parseFloat(sn.next().trim());
                        float altura = Float.parseFloat(sn.next().trim());
                        Veiculo.Cor cor = Veiculo.StringToCor(corString);
                        Caminhao cam = new Caminhao(marca,modelo,cor,placa,renavam,potencia,numMarchas,numEixos,cargaMaxima,altura);
                        colVeiculos.adicionar(cam);
                    }
                    else{
                        Veiculo.Cor cor = Veiculo.StringToCor(corString);
                        Moto mot = new Moto(marca,modelo,cor,placa,renavam,potencia,numMarchas);
                        colVeiculos.adicionar(mot);
                    }
                }
            }while (!eof);
            
            fr.close();
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(PersistenciaColecaoVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
