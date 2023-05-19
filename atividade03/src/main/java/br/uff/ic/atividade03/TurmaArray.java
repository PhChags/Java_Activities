/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.atividade03;

/**
 *
 * @author Pehper
 */
public class TurmaArray implements Turmas{
    public class TurmaIterator{
        int pos;
        public TurmaIterator(){
            pos = 0;
        }
        
        public boolean hasNext(){
            return pos<numAlunos;
        }
        
        public Aluno next(){
            return alunos[pos++];
        }           
    }

    private int MAX_ALUNOS = 50;
    private int codigo;
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

    public TurmaIterator getIterator(){
        return new TurmaIterator();
    }
    
    public TurmaArray(){};
    
    public TurmaArray(int codigo){
        this.codigo = codigo;
        this.numAlunos = 0;
        this.alunos = new Aluno[MAX_ALUNOS];
    }
    
    @Override
    public void adicionaAluno(Aluno a){
        if (this.MAX_ALUNOS >= this.numAlunos){
            int n = this.numAlunos;
            this.alunos[n] = a;
            this.numAlunos++;
        } else
            System.out.println("Turma Cheia!");
    }
    
    @Override
    public Aluno removePrimeiro(){
        Aluno aluno = null;
        if (numAlunos>0){
            aluno = alunos[0];
            numAlunos--;
            for (int i=0;i<numAlunos;i++){
                alunos[i] = alunos[i+1];
            }
        }
        
        
        return aluno;
    }

    @Override
    public Aluno removeAluno(String nome){
        int pos=-1;
        Aluno aluno = null;
        
        for (int i=0;i<this.numAlunos;i++){
            if (alunos[i].getNome().compareTo(nome)==0){
                pos = i;
                aluno = alunos[pos];
            }
        }
        
        if (pos!=-1){
            for (int i=pos;i<numAlunos;i++){
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
}