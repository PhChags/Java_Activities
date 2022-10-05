/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exerecicio03;

import java.util.*;
import java.text.DateFormat;

/**
 *
 * @author Pedro
 */
public class Menu {
    private Locale idioma = new Locale("pt", "BR");
    private int formato = DateFormat.DEFAULT;

    public void escolher(int op, Agenda agenda) {
        switch (op) {
            case 0:
                break;
            case 1: 
                mostrarCompromissos(agenda);
                break;
            case 2: 
                criarCompromisso(agenda);
                break;
            case 3: 
                mudarIdioma();
                break;
            case 4:
                mudarFormato();
                break;
            default:
                System.out.println("OPCAO INVALIDA");
        }
    }

    public void mostrarOpcoes() {
        System.out.println("[0] - ENCERRAR");
        System.out.println("[1] - MOSTRAR COMPROMISSOS DO DIA");
        System.out.println("[2] - CRIAR COMPROMISSO");
        System.out.println("[3] - ALTERAR IDIOMA");
        System.out.println("[4] - ALTERAR FORMATO DA DATA");
        System.out.printf("==> ");
        System.out.println();
    }

    public void mostrarCompromissos(Agenda agenda) {
        Scanner teclado = new Scanner(System.in);

        System.out.printf("Data (DD/MM/AAAA): ");
        String[] input = teclado.next().split("/");
        ArrayList<Integer> data = new ArrayList<>();
        for (String num: input) {
            data.add(Integer.parseInt(num));
        }

        Calendar diaProcurado = Calendar.getInstance();
        diaProcurado.set(data.get(2), data.get(1) - 1, data.get(0));
        DateFormat padraoDia = DateFormat.getDateInstance(formato, idioma);

        
        System.out.printf("%s\n\n", padraoDia.format(diaProcurado.getTime()));

        ArrayList<Compromisso> horarios = agenda.verificarDia(data.get(0), data.get(1) - 1, data.get(2));

        if (horarios.isEmpty()) {
            System.out.println("NENHUM COMPROMISSO MARCADO");
        } else {
            DateFormat padraoHora = DateFormat.getTimeInstance(formato, idioma);
            for (Compromisso compromisso: horarios) {
                System.out.printf("%s: ", padraoHora.format(compromisso.getData().getTime()));
                System.out.printf("%s (%s) / LOCAL: %s\n", compromisso.getTitulo(), compromisso.getDescricao(), compromisso.getLocal());
            }
        }
        System.out.println();
        
    }

    public void criarCompromisso(Agenda agenda) {
        Scanner teclado = new Scanner(System.in);

        System.out.printf("TITULO: ");
        String titulo = teclado.nextLine();
        System.out.printf("DESCRICAO: ");
        String descricao = teclado.nextLine();
        System.out.printf("LOCAL: ");
        String local = teclado.nextLine();

        System.out.printf("DATA (DD/MM/YYYY) : ");
        String[] input = teclado.nextLine().split("/");
        ArrayList<Integer> dia = new ArrayList<>();
        for (String num: input) {
            dia.add(Integer.parseInt(num));
        }
        System.out.printf("HORA (HH:MM) : ");
        input = teclado.nextLine().split(":");
        ArrayList<Integer> hora = new ArrayList<>();
        for (String num: input) {
            hora.add(Integer.parseInt(num));
        }

        Calendar data = Calendar.getInstance();
        data.set(dia.get(2), dia.get(1) - 1, dia.get(0), hora.get(0), hora.get(1), 0);

        agenda.addCompromisso(titulo, descricao, local, data);
        System.out.println();
    }

   public void mudarIdioma() {
        Scanner teclado = new Scanner(System.in);
        int op;
        do {
            System.out.println("[0] - CANCELAR");
            System.out.println("[1] - PORTUGUES-BR");
            System.out.println("[2] - INGLES");
            System.out.printf("==> ");
            System.out.println();

            op = teclado.nextInt();
            if (op == 1) {
                idioma = new Locale("pt", "BR");
            } else if (op == 2) {
                idioma = Locale.US;
            } else if (op != 0) {
                System.out.println("OPCAO INVALIDA");
            }
        } while (op < 0 || op > 2);
        System.out.println();
    }

    public void mudarFormato() {
        Scanner teclado = new Scanner(System.in);
        int op;
        do {
            System.out.println("[0] - CANCELAR");
            System.out.println("[1] - CURTO");
            System.out.println("[2] - NORMAL");
            System.out.println("[3] - LONGO");
            System.out.println("[4] - COMPLETO");
            System.out.printf("==> ");
            System.out.println();

            op = teclado.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    formato = DateFormat.SHORT;
                    break;
                case 2:
                    formato = DateFormat.MEDIUM;
                    break;
                case 3:
                    formato = DateFormat.LONG;
                    break;
                case 4:
                    formato = DateFormat.FULL;
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        } while (op < 0 || op > 4);
        System.out.println();
    }
}
