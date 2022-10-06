/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio04;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Pokemon {
    protected String nome;
    private double peso;
    private double altura;
    protected String tipo1;
    protected String tipo2;
    private boolean dualtype = segundoTipo();
    protected String habilidade;
    protected Atributos atributos;
    protected ArrayList<Ataques> ataques = new ArrayList<>();
    private int nivel;
    private int nivelEvolui;
    
    public Pokemon(){
    }
    public Pokemon(String nomeP, double altP, double pesoP, String t1P, String t2P, String habilidadeP){
        this.nome = nomeP;
        this.altura = altP;
        this.peso = pesoP;
        this.tipo1 = t1P;
        this.tipo2 = t2P;
        this.habilidade = habilidadeP;
    }
    public Pokemon(String nomeP, double altP, double pesoP, String t1P, String habilidadeP){            
        this.nome = nomeP;
        this.altura = altP;
        this.peso = pesoP;
        this.tipo1 = t1P;
        this.habilidade = habilidadeP;
    }
    public Pokemon(int hp, int atk, int def, int spAtk, int spDef, int spd){
        atributos = new Atributos(hp, atk, def, spAtk, spDef, spd);
    }
    public Pokemon(String nomeP, String tipoP, String tipopP, String efeitoP, int powerP, int ppP, double precisaoP, int indexP){
        ataques.set(indexP, new Ataques(nomeP, tipoP, tipopP, efeitoP, precisaoP, powerP, ppP));
    }
    public void evoluirPokemon() {
            if (nivel == nivelEvolui) {
                    System.out.println("PARABENS SEU POKEMON EVOLUIU"); //Os status do pokemon aumentariam
            }
    }
    private static boolean segundoTipo(){
        Random random =  new Random();
        return random.nextBoolean();
    }
    public boolean getDualType(){
        return this.dualtype;
    }
    public Atributos getAtributos(){
        return this.atributos;
    }
    public ArrayList<Ataques> getAtaques(){
        return this.ataques;
    }
}
