/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ic.uff.br.ii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author anselmo
 */
public class FrequenciaPalavrasTexto {

    public static void main(String[] args) {
        
        File file = new File("texto.txt");
        String[] palavras;
        Map<String,Integer> freq = new TreeMap<>();
        
        try{
            FileReader f = new FileReader(file);
            BufferedReader buff = new BufferedReader(f);
            boolean eof = false;
            do{

                String s = buff.readLine();
            
                if (s==null){
                    eof = true;
                }
                else{
                    palavras = s.split("[, .\";:!/-]");
                    
                    for (String p:palavras){
                        if (p.compareTo("")==0) continue;
                    
                        Integer fq = freq.get(p);
                        if( fq == null){
                            freq.put(p,1);
                        }
                        else{
                            freq.put(p,fq+1);
                        }
                    }
                }

            }while (!eof);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        Set<Entry<String,Integer>> entrySet = freq.entrySet();
        for (Entry<String,Integer> e:entrySet){
            System.out.println(e.toString());
        }

    }
}
