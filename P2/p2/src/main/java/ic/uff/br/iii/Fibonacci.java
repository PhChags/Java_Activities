/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uff.br.iii;


/**
 *
 * @author anselmoantunesmontenegro
 */
public class Fibonacci {
    private int numberRecCalls;

    
    public Fibonacci(){
        numberRecCalls =0;
   
    }
    
    public void init(){
        numberRecCalls = 0;
    }
    
    public int fibonacci(int n){
        int result;
        
  
        if ((n==0)||(n==1)){
            result = 1;
        }
        else{
            numberRecCalls +=2;
            result = fibonacci(n-1) + fibonacci(n-2);
        } 

        return result;
    }  

    public int getNumberRecCalls() {
        return numberRecCalls;
    }

    
    
}
