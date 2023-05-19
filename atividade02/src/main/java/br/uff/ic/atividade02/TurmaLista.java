/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.atividade02;

/**
 *
 * @author Pehper
 */
public class TurmaLista implements Turmas{
    public class NoAluno {
        private Aluno aluno;
        private NoAluno prox;

        public NoAluno(){
            this.aluno = null;
            this.prox =  null;
        }
        public NoAluno(Aluno vAluno, NoAluno vProx){
            this.aluno = vAluno;
            this.prox =  vProx;
        }
    }
    
    private NoAluno ini, fim;
    private int codigo;
    private int numAlunos;
    
    
    public int getCodigo() {
        return codigo;
    }

    public int getNumAlunos() {
        return numAlunos;
    }
    
    public TurmaLista(){};
    
    public TurmaLista(int codigo){
        this.codigo = codigo;
        this.numAlunos = 0;
        this.fim = null;
        this.ini = null;
    }
    
    @Override
    public void adicionaAluno(Aluno a){
        NoAluno aux = new NoAluno(a, null);
        if (this.ini == null){
            this.ini = aux;
            this.fim = this.ini;
        } else {
            this.fim.prox = aux;
            this.fim = aux;
        }
        this.numAlunos++;
    }
    
    @Override
    public Aluno removePrimeiro(){
        Aluno alu = null;
        if(this.ini != null){
            alu = this.ini.aluno;
            this.ini = this.ini.prox;
            if(this.ini == null)
                this.fim = null;
        }
        return alu;
    }
//remove aluno é com busca
    @Override
    public Aluno removeAluno(String nome){
        NoAluno aux, pre;
        Aluno alu = null;
        aux = this.ini;
        pre = null;
        
        while ((aux != null) && (aux.aluno.getNome().compareTo(nome)!=0)){
                pre = aux;
                aux = aux.prox;
        }
        
        if (aux != null){
            if (pre == null) {
                this.ini = aux.prox; 
            } 
            else {
                pre.prox = aux.prox;
            } 
            if (this.ini == null){
                this.fim = null;
            }
            alu = aux.aluno;
            numAlunos--;
        }
        
        return alu;
    }
    
    public void imprime(){
        NoAluno aux;
        aux = ini;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Turma: " + codigo);
        for (int i = 0; i < this.numAlunos; i++){
            Aluno a = aux.aluno;
            aux = aux.prox;
            System.out.println(a.toString());
        }
        System.out.println("------------------------------------------------------------------");
    }
    
}
