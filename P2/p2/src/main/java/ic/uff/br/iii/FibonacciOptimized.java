/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.iii;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author anselmoantunesmontenegro
 */
public class FibonacciOptimized {
    private int numberRecCalls;
    private Map<Integer,Integer> fib;
    
    public FibonacciOptimized(){
        numberRecCalls = 0;
        fib = new TreeMap<Integer,Integer>();
        
    }
    
    public void init(){
        numberRecCalls = 0;
    }
    
    public void clear(){
        fib.clear();
    }
    
    public int fibonacci(int n){
        int result;
        
        if (fib.get(n)==null){    
            if ((n==0)||(n==1)){
                result = 1;
            }
            else{
                numberRecCalls +=2;
                result = fibonacci(n-1) + fibonacci(n-2);
            } 
            fib.put(n, result);
        }
        else{
            result = fib.get(n);
        }
        return result;
    }    

    public int getNumberRecCalls() {
        return numberRecCalls;
    }

    public Map<Integer, Integer> getFib() {
        return fib;
    }
    
    
}
