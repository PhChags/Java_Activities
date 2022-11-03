/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.lista09.Exercicio01;

/**
 *
 * @author Pedro
 */
public class TrabalhaExcecoes {
    //Number Formart ocorre quando se tenta fazer um cast de uma variavel não inteira para inteira
    //Illegal Argument ocorre quando se tenta passar um argumento nao aceito
    
    public static void testaIllegalArgument() {
        try {
            int num = -7;
            System.out.println(ehPar(num));
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Argumento invalido");
        }
    }

    public static boolean ehPar(int num){
         if (num < 0) {
            throw new IllegalArgumentException();
        }
        return num % 2 == 0;
    }
    
    public static void testaNumberFormart(String[] args) {
        String a = "a"; String b = "b";
        try {
            Integer.parseInt(a);
            Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            System.out.println("Erro de conversao");
        }
        System.out.println("A : " +a+"\nB : "+b);
    }
}
