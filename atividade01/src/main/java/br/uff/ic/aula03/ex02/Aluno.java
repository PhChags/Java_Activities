/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.aula03.ex02;


/**
 *
 * @author Pehper
 */
public class Aluno {
    private String nome;
    private int mat;
    private float cr;
    
    public Aluno(String vNome, int vMat, float vCr){
        this.nome = vNome;
        this.mat = vMat;
        this.cr = vCr;
    }
    
    public String getNome(){
        return this.nome;
    }
    public int getMat(){
        return this.mat;
    }
    public float getCr(){
        return this.cr;
    }
    
/*  public void setNome(String vNome){
        this.nome = vNome;
    }
    public void setMat(int vMat){
        this.mat = vMat;
    }
    public void setCr(float vCr){
        this.cr = vCr;
    }*/
}
