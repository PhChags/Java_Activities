/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista05.Exercicio02;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */

public class Cria {
    private static Evento evento;
    
    public static Evento criaEvento() {
        Scanner teclado = new Scanner(System.in);
        String dataInicio, dataFinal, horarioInicio, horarioFinal;

        System.out.println("============================== PREENCHENDO AS INFORMACOES DO EVENTO DA SEMANA DA COMPUTACAO =============================");

        System.out.println("INFORME A DATA DE INICIO:\tNO FORMATO: DD/MM/AAAA");
        dataInicio = teclado.nextLine();
        System.out.println("INFORME A DATA DE ENCERRAMENTO:\tNO FORMATO: DD/MM/AAAA");
        dataFinal = teclado.nextLine();
        System.out.println("INFORME O HORARIO DE INICIO:\tNO FORMATO 24 HORAS");
        horarioInicio = teclado.nextLine();
        System.out.println("INFORME O HORARIO DE FIM:\tNO FORMATO 24 HORAS");
        horarioFinal = teclado.nextLine();

        evento = Inscricao.inscreveEvento(dataInicio, dataFinal, horarioInicio, horarioFinal);
        return evento;
    }
    public static void criaPalestra() {

        Scanner tecladoStr = new Scanner(System.in);
        Scanner tecladoInt = new Scanner(System.in);
        String tituloPalestra;
        
        System.out.println("============================== PREENCHENDO AS INFORMACOES DA PALESTRA =============================");

        Palestra palestraExistente;
        do {
            System.out.println("DIGITE O TITULO DA PALESTRA: ");
             tituloPalestra = tecladoStr.nextLine();

            palestraExistente = evento.procuraPalestra(tituloPalestra);

            if (palestraExistente != null ) {
                System.out.println("PALESTRA JA CADASTRADA");
            }
        }
        while (palestraExistente != null);

        System.out.println("INFORME O NOME DO PALESTRANTE: ");
        String nomePalestrante = tecladoStr.nextLine();

        System.out.println("INFORME O LOCAL DA PALESTRA: ");
        String local = tecladoStr.nextLine();

        System.out.println("INFORME A DATA DA PALESTRA: \tNO FORMATO DD/MM/AAAA");
        String dataPalestra = tecladoStr.nextLine();

        System.out.println("INFORME O HORARIO DE INICIO: \tNO FORMATO 24 HORAS");
        String horario = tecladoStr.nextLine();

        System.out.println("INFORME O PRAZO DE DURACAO EM MINUTOS: ");
        int duracao = tecladoInt.nextInt();

        System.out.println("INFORME O NUMERO MAXIMO DE PARTICIPANTES NESSA PALESTRA: ");
        int numeroMax = tecladoInt.nextInt();

        Inscricao.inscrevePalestra(evento, tituloPalestra, nomePalestrante, local, horario, duracao, numeroMax, dataPalestra);
    }
    public static void criaParticipante() {
        Scanner tecladoStr = new Scanner(System.in);
        Scanner tecladoInt = new Scanner(System.in);
        boolean palestraEmMaxDeParticipante = true;
        Palestra palestraSolicitada;
        
        System.out.println("============================== PARTICIPANTE ==============================");

        System.out.println("INFORME O NOME DO PARTICIPANTE: ");
        String nome = tecladoStr.nextLine();

        System.out.println("INFORME O NUMERO DE MATRICULA: ");
        int numeroMatricula = tecladoInt.nextInt();

        System.out.println("INFORME O EMAIL: ");
        String email = tecladoStr.nextLine(); 

        System.out.println("INFORME O CARGO: ");
        String tipo = tecladoStr.nextLine();
        evento.disponibilidadeDaPalestra();

        do {
            System.out.println("INFORME A PALESTRA DESEJADA");
            String palestraDesejada = tecladoStr.nextLine();

            palestraSolicitada = evento.procuraPalestra(palestraDesejada);

            if (palestraSolicitada == null ) {
                System.out.println("A PALESTRA SOLICITADA NAO FOI ENCONTRADA. VERIFIQUE E TENTE NOVAMENTE");
                evento.disponibilidadeDaPalestra();
            } else {
                if (palestraSolicitada.vagasDisponiveisNaPalestra() > 0) {
                    palestraEmMaxDeParticipante = false;
                } else {
                    System.out.println("SEM VAGAS DISPONIVEIS PARA ESTA PALESTRA"); 
                }
            }
        } while (palestraSolicitada == null || palestraEmMaxDeParticipante);
        
        System.out.println("INSCRICAO REALIZADA COM SUSSECO");
        Inscricao.inscreveParticipante(numeroMatricula, nome, email, tipo, palestraSolicitada);
    }
}