/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio04;

/**
 *
 * @author Pedro
 */
public class Atributos {
    private int hp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int spd;
    
    public Atributos(int healthPoints, int attack, int defense, int spcAtk, int spcDef, int speed){
        this.hp = healthPoints;
        this.atk = attack;
        this.def = defense;
        this.spAtk = spcAtk;
        this.spDef = spcDef;
        this.spd = speed;
    }
    public int getHp(){
        return this.hp;
    }
    public int getAtk(){
        return this.atk;
    }
    public int getSpAtk(){
        return this.spAtk;
    }
    public int getDef(){
        return this.def;
    }
    public int getSpDef(){
        return this.spDef;
    }
    public int getSpd(){
        return this.spd;
    }
}
