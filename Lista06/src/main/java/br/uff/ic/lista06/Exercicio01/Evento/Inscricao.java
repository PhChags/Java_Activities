/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio01.Evento;

import java.util.ArrayList;
import java.util.Objects;
import br.uff.ic.lista06.Exercicio01.Participante.*;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Inscricao {

    protected static Evento inscreveEvento(String dataI, String horaI, String dataF, String horaF) {
        Evento evento = Evento.getInstancia(dataI, dataF, horaI, horaF);
        return evento;
    }

    protected static void inscrevePalestra(Evento evento, String titulo, String nomePalestrante, String local, String horario, int duracaoP, int numeroMax, String dataP) {    
        Palestra palestra = new Palestra(titulo, nomePalestrante, local, horario, duracaoP, numeroMax, dataP);
        evento.addPalestra(palestra);
    }

    protected static void inscreveParticipante(String numeroMatricula, String nome, String email, String tipo, Palestra palestraSolicitada) {
        Scanner teclado = new Scanner(System.in);
        String variavel;
        if (tipo.equals(("aluno").toLowerCase())){
            System.out.println("INFORME SEU CURSO: ");
            variavel = teclado.nextLine();
            Aluno aluno = new Aluno(numeroMatricula, nome, email, variavel);
            Participante participante = new Participante(aluno);
            palestraSolicitada.addParticipantes(participante);
        }
        if (tipo.equals(("professor").toLowerCase())){
            System.out.println("INFORME SEU DEPARTAMENTO: ");
            variavel = teclado.nextLine();
            Professor professor = new Professor(numeroMatricula, nome, email, variavel);
            Participante participante = new Participante(professor);
            palestraSolicitada.addParticipantes(participante);
        }
        if (tipo.equals(("funcionario").toLowerCase())){
            System.out.println("INFORME SEU CARGO: ");
            variavel = teclado.nextLine();
            Funcionario funcionario = new Funcionario(numeroMatricula, nome, email, variavel);
            Participante participante = new Participante(funcionario);
            palestraSolicitada.addParticipantes(participante);
        }
    }
    
    public static boolean verificaInscricao(Evento evento, String tituloPalestra, int numeroDeMatricula) {
        ArrayList<String> participantePalestra = new ArrayList<>();
        participantePalestra = listaPalestrasParticipanteInscrito(evento, numeroDeMatricula);
        
        if (!participantePalestra.isEmpty()) {
            for (int i = 0;  i < participantePalestra.size(); i++) {
                if (Objects.equals(participantePalestra.get(i), tituloPalestra)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static ArrayList<String> listaPalestrasParticipanteInscrito(Evento evento, int matricula) { 
        ArrayList<Palestra> palestras = evento.getPalestras();
        ArrayList<String> participantePalestra = new ArrayList<>();

        for (int i = 0;  i < palestras.size(); i++) {
            ArrayList<Participante> participantes = palestras.get(i).getParticipantes();
            for (int j = 0; j < participantes.size() ;j++)
                if (participantes.get(j).getMatricula() == matricula) {
                    participantePalestra.add(palestras.get(i).getTitulo());
                }
        }
        imprimindoParticipantePalestrasInscritas(matricula, participantePalestra);
        return participantePalestra;
    }

    protected static void imprimindoParticipantePalestrasInscritas(int numeroDeMatricula, ArrayList<String> palestras) {
        System.out.println("PARTICIPANTE COM NUMERO DE MATRICULA " + numeroDeMatricula);
        if (!palestras.isEmpty()) {
            System.out.println("SE INSCREVEU NAS PALESTRAS: ");
            for (int i = 0;  i < palestras.size(); i++) {
                if (palestras.get(i) != null) {
                    System.out.printf("%s\n", palestras.get(i));
                }
            }
        } else {
            System.out.println("O PARTICIPANTE NAO SE INSCREVEU EM NENHUMA PALESTRA");
        }
    }
}
