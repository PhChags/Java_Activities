/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ic.uff.br.iii;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author anselmoantunesmontenegro
 */
public class FibonnaciMemoization {

    

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        FibonacciOptimized fo = new FibonacciOptimized();
        
        System.out.println("Original...");
        for (int i=0;i<10;i++){
            f.init();
            System.out.println("Fib("+i+")="+f.fibonacci(i));
            System.out.println("Number of recursive calls" + f.getNumberRecCalls());
        }
        
        System.out.println("Optimized with memory clear...");
        for (int i=0;i<10;i++){
            fo.init();
            fo.clear();
            System.out.println("Fib("+i+")="+fo.fibonacci(i));
            System.out.println("Number of recursive calls" + fo.getNumberRecCalls());
        }
        
        System.out.println("Optimized keeping past memory...");
        for (int i=0;i<10;i++){
            fo.init();
            System.out.println("Fib("+i+")="+fo.fibonacci(i));
            System.out.println("Number of recursive calls" + fo.getNumberRecCalls());
        }
        
        Set<Map.Entry<Integer,Integer>> fib = fo.getFib().entrySet();
        for (Map.Entry<Integer,Integer> fibEntry:fib){
            System.out.println(fibEntry);
        }
    }
}
