package ic.uff.br;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
* exemplo uso collection
**/

public class App 
{
    public static void main( String[] args )
    {
        int[] inteiros = {1, 2, 3, 4, 5};
        Collection<Number> cn = new ArrayList<Number>();
        Collection<Integer> ci = new ArrayList<Integer>();

        for (int i: inteiros){
            ci.add(i);
        }

        for (int i: inteiros){
            cn.add(i);
        }

        Iterator<Integer> it = ci.iterator();
        Iterator<Integer> iy = ci.iterator();

        for (; it.hasNext();){
            System.out.print(it.next() + " ");
        }

        System.out.println();
        
        for (; iy.hasNext();){
            System.out.print(iy.next() + " ");
        }
    }
}
