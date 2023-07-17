package ic.uff.atividade08.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static < T extends Comparable<T> > void substituiNegativos(List<T> l, T value){
        for (int i = 0; i < l.size(); i++){
            if(l.get(i).compareTo(value) < 0){
                l.set(i, value);
            }
        }
    }

    public static void main(String[] args) {
        int inteiros[] = {1, -1, 3, -5, -6, 7, 9, 1, 0, 3, 0, 0, 7, 9};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int i:inteiros){
            arr.add(i);
        }

        System.out.print("Array {");
        for(Integer i: arr)
            System.out.print(" " + i + ";");
        System.out.println("}");
        
        substituiNegativos(arr, arr.get(8));

        System.out.print("Array Modificado {");
        for(Integer i: arr)
            System.out.print(" " + i + ";");
        System.out.println("}");
    }
}
