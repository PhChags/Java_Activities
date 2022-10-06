/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.uff.ic.lista06.Exercicio01;

import br.uff.ic.lista06.Exercicio01.Evento.*;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {
        
        Evento evento = Cria.criaEvento();
        int op;
        do {
            Scanner tecladoInt = new Scanner(System.in);
            Scanner tecladoStr = new Scanner(System.in);
            System.out.println("============================== BEM VINDO A SEMANA A COMPUTACAO DO IC/UFF =============================");
            System.out.println("[0] ADICIONAR PALESTRA\n[1] INSCRICAO DE PARTICIPANTE\n[2] LISTA TODAS AS PALESTRAS QUE UM PARTICIPANTE SE INSCREVEU");
            System.out.println("[3] CONSULTAR VAGA EM UMA PALESTRA\n[4] VERIFICANDO SE UM PARTICIPANTE ESTA INSCRITO EM UMA PALESTRA\n[5] SAIR\n");
            op = tecladoInt.nextInt();
            switch (op) {
                case 0 -> Cria.criaPalestra();
                case 1 -> Cria.criaParticipante();
                case 2 -> {
                    System.out.println("DIGITE SEU NUMERO DE MATRICULA: ");
                    int numeroDeMatricula;
                    do {
                        numeroDeMatricula = tecladoInt.nextInt();
                    } while (numeroDeMatricula < 0);
                    Inscricao.listaPalestrasParticipanteInscrito(evento, numeroDeMatricula);
                }
                case 3 -> {
                    Palestra palestraSolicitada;
                    do {
                        System.out.println("INFORME A PALESTRA QUE DESEJA CONSULTAR A VAGA: ");
                        String palestraNome = tecladoStr.nextLine();
                        palestraSolicitada = evento.procuraPalestra(palestraNome);

                        if (palestraSolicitada == null) {
                            System.out.println("A PALESTRA SOLICITADA NAO FOI ENCONTRADA, VERIFIQUE O TITULO E TENTE NOVAMENTE ");
                        }

                    } while (palestraSolicitada == null);

                    System.out.printf("EXISTE %d VAGAS PARA A PALESTRA COM TITULO %s\n", palestraSolicitada.vagasDisponiveisNaPalestra(), palestraSolicitada.getTitulo());
                }
                case 4 -> {
                    System.out.println("DIGITE SEU NUMERO DE MATRICULA: ");
                    int numeroDeMatriculaA = 0;
                    do {
                        numeroDeMatriculaA = tecladoInt.nextInt();
                    } while (numeroDeMatriculaA < 0);

                    Palestra palestraDesejada;
                    do {
                        System.out.println("DIGITE O TITULO DA PALESTRA QUE DESEJA VERIFICAR A INSCRICAO: ");
                        String palestraNome = tecladoStr.nextLine();
                        palestraDesejada = evento.procuraPalestra(palestraNome);

                        if (palestraDesejada == null) {
                            System.out.println("O TITULO DA PALESTRA INSERIDO NAO FOI ENCONTRADO, VERIFIQUE O TITULO E TENTE NOVAMENTE ");
                        }

                    } while (palestraDesejada == null);

                    if (Inscricao.verificaInscricao(evento, palestraDesejada.getTitulo(), numeroDeMatriculaA)) {
                        System.out.println("O PARTICIPANTE ESTA INSCRITO NA PALESTRA");
                    } else {
                        System.out.println("O PARTICIPANTE NAO ESTA INSCRITO NA PALESTRA");
                    }
                }
                case 5 -> System.out.println("PROGRAMA FINALIZADO");
            }

        } while (op != 5);
        
    }
}
