/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.aula01;

/**
 *
 * @author Pehper
 */
public class Aluno {
    private String nome;
    private int mat;
    private float cr;
    
    public String getNome(){
        return nome;
    }
    public int getMat(){
        return mat;
    }
    public float getCr(){
        return cr;
    }
    
    public void setNome(String vNome){
        nome = vNome;
    }
    public void setMat(int vMat){
        mat = vMat;
    }
    public void setCr(float vCr){
        cr = vCr;
    }
}
