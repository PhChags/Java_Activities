/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.aula03.ex04;

/**
 *
 * @author Pehper
 */
public class Turma {
    private int MAX_ALUNOS = 10;
    private int codigo;
    private String curso;
    private int numAlunos;
    private Aluno[] alunos;
    
    
    public int getCodigo() {
        return codigo;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public int getMAX_ALUNOS() {
        return MAX_ALUNOS;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public Turma(){};
    
    public Turma(int codigo){
        this.codigo = codigo;
        this.numAlunos = 0;
        this.alunos = new Aluno[MAX_ALUNOS];
    }
    
    public void adicionaAluno(Aluno a){
        if (this.MAX_ALUNOS >= this.numAlunos){
            int n = this.numAlunos;
            this.alunos[n] = a;
            this.numAlunos++;
        } else
            System.out.println("Turma Cheia!");
    }
    
/*  public Aluno removePrimeiro(){
        Aluno aluno = null;
        if (numAlunos>0){
            aluno = alunos[0];
            numAlunos--;
            for (int i=0;i<numAlunos;i++){
                alunos[i] = alunos[i+1];
            }
        }
        
        
        return aluno;
    }*/
    
    public Aluno removeAluno(int vMat){
        int pos = -1;
        Aluno aluno = null;
        
        for (int i = 0; i < this.numAlunos; i++){
            if (alunos[i].getMat() == vMat){
                pos = i;
                aluno = alunos[pos];
            }
        }
        
        if (pos != -1){
            for (int i = pos; i < numAlunos; i++){
                alunos[i] = alunos[i+1]; 
            }
            numAlunos--;
        }
        
        return aluno;
    }
    
    public void imprime(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("Turma: " + codigo);
        for (int i = 0; i < this.numAlunos; i++){
            Aluno a = this.alunos[i];
            System.out.println(a.toString());
        }
        System.out.println("------------------------------------------------------------------");
    }
    
    public Aluno getAluno(int vMat){
        Aluno aluno = null;
        
        for (int i = 0; i < this.numAlunos; i++){
            if (alunos[i].getMat() == vMat){
                aluno = alunos[i];
            }
        }
        
        return aluno;
    }
}