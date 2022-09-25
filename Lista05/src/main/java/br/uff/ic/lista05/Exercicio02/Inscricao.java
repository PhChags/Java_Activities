/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista05.Exercicio02;

import java.util.ArrayList;
import java.util.Objects;

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

    protected static void inscreveParticipante(int numeroMatricula, String nome, String email, String tipo, Palestra palestraSolicitada) {
        Participante participante = new Participante(numeroMatricula, nome, email, tipo);
        palestraSolicitada.addParticipantes(participante);
    }
    
    protected static boolean verificaInscricao(Evento evento, String tituloPalestra, int numeroDeMatricula) {
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

    protected static ArrayList<String> listaPalestrasParticipanteInscrito(Evento evento, int matricula) { 
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
