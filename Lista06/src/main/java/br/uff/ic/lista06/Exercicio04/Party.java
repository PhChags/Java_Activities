/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio04;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Party{
    private int numPokedex;
    
    public void addPokemon(){
        Scanner tecladoStr = new Scanner(System.in);
        Scanner tecladoInt = new Scanner(System.in);
        Pokemon pokemon = new Pokemon();
        String nome, habilidade, tipo1, tipo2, nomeM, tipoM, tipopM, efeitoM;
        Double altura, peso, precisaoM;
        int hp, atk, def, spAtk, spDef, spd, forcaM, ppM;
        
        System.out.println("==================== ADICIONANDO POKEMON NA PARTY ====================");
        if(pokemon.getDualType())
            System.out.println("\nDualType\n");
        System.out.println("DIGITE O NUMERO DO POKEMON NA POKEDEX: ");
        this.numPokedex = tecladoInt.nextInt();
        System.out.println("DIGITE O NOME DO POKEMON: ");
        nome = tecladoStr.nextLine();
        System.out.println("DIGITE A ALTURA DO POKEMON: ");
        altura = tecladoInt.nextDouble();
        System.out.println("DIGITE O PESO DO POKEMON: ");
        peso = tecladoInt.nextDouble();
        System.out.println("DIGITE A HABILIDADE DO POKEMON: ");
        habilidade = tecladoStr.nextLine();
        System.out.println("DIGITE O TIPO DO POKEMON: ");
        tipo1 = tecladoStr.nextLine();
        
        if(pokemon.getDualType()){
            System.out.println("DIGITE O TIPO DO POKEMON: ");
            tipo2 = tecladoStr.nextLine();
            pokemon = new Pokemon(nome, altura, peso, tipo1, tipo2, habilidade);
        } else
            pokemon = new Pokemon(nome, altura, peso, tipo1, habilidade);
        
        System.out.println("=========================================================================");
        System.out.println("DIGITE OS ATRIBUTOS DO POKEMON: ");
        System.out.print("HP: \n");
        hp = tecladoInt.nextInt();
        System.out.print("ATK: \n");
        atk = tecladoInt.nextInt();
        System.out.print("DEF: \n");
        def = tecladoInt.nextInt();
        System.out.print("SP.ATK: \n");
        spAtk = tecladoInt.nextInt();
        System.out.print("SP.DEF: \n");
        spDef = tecladoInt.nextInt();
        System.out.print("SPD: \n");
        spd = tecladoInt.nextInt();
        pokemon = new Pokemon(hp, atk, def, spAtk, spDef, spd);   
        
        System.out.println("=========================================================================");
        System.out.println("DIGITE OS MOVES DO POKEMON: ");
        for (int i = 0; i < 4; i++){
            System.out.printf("\n-------- MOVE %d --------\n", (i+1));
            System.out.print("NOME: \n");
            nomeM = tecladoStr.nextLine();
            System.out.print("TIPO: \n");
            tipoM = tecladoStr.nextLine();
            System.out.print("[Fisico, Especial, Status]: \n");
            tipopM = tecladoStr.nextLine();
            System.out.print("EFEITO: \n");
            efeitoM = tecladoStr.nextLine();
            System.out.print("FORCA: \n");
            forcaM = tecladoInt.nextInt();
            System.out.print("PRECISAO: \n");
            precisaoM = tecladoInt.nextDouble();
            System.out.print("PP: \n");
            ppM = tecladoInt.nextInt();
            pokemon = new Pokemon(nomeM, tipoM, tipopM, efeitoM, forcaM, ppM, precisaoM, i);
        }
    }
}
