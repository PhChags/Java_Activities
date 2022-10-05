/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista04.Exercicio02;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Scanner tecladoStr = new Scanner(System.in);
        Scanner tecladoInt = new Scanner(System.in);
        String nomeCliente;

        do {
            double valorFatura;
            String dataFatura; 
            String codigo;
            String dataBoleto;
            double valorBoleto;
            int qtdBol;

            System.out.println("INFORME O NOME DO CLIENTE: ");
            nomeCliente = tecladoStr.nextLine();
            System.out.println("INFORME O VALOR DA FATURA: ");
            valorFatura = tecladoInt.nextDouble();
            System.out.println("INFORME A DATA DE VENCIMENTO DA FATURA: ");
            dataFatura = tecladoStr.nextLine();
            System.out.println("Seja bem vindo(a), " + nomeCliente);
            System.out.println("INFORME A QUANTIDADE DE BOLETOS PARA PAGAR DA FATURA DE VENCIIMENTO " + dataFatura);
            qtdBol = tecladoInt.nextInt();

            Fatura fatura = new Fatura(nomeCliente, dataFatura, valorFatura);
            Boleto listaBoletos = new Boleto();

            for (int i = 0; i < qtdBol; i++) {
                System.out.println("DIGITE O CODIGO DO BOLETO: ");
                codigo = tecladoStr.next();

                System.out.println("DIGITE O VALOR DO BOLETO: ");
                valorBoleto = tecladoInt.nextDouble();

                System.out.println("DIGITE A DATA DE VENCIMENTO DO BOLETO: ");
                dataBoleto = tecladoStr.next();

                Boleto boleto = new Boleto(codigo, dataBoleto, valorBoleto);
                listaBoletos.addBoletos(boleto);
            }
            if (listaBoletos.getListaDeBoletos().size() != 0) {
                Pagamento pagamento = new Pagamento(valorFatura, dataFatura, "BOLETO");
                imprimir(fatura, listaBoletos, pagamento, qtdBol, valorFatura);
            } else {
                System.out.println("NAO HAH BOLETOS ADICIONADOS, TENTE NOVAMENTE");
            }
            
            tecladoInt.next();
        } while (!"fim".equals(nomeCliente.toLowerCase()));

    }

    public static void imprimir(Fatura fatura, Boleto listaBoletos, Pagamento pagamento, int qtdBoleto, double valorFatura) {
        String estadoFatura;
        if (fatura.estarPaga(listaBoletos.getListaDeBoletos(), valorFatura)) {
            estadoFatura = "PAGA";
        } else {
            estadoFatura = "NAO PAGA";
        }
        System.out.print("FATURA DE " + fatura.getValor() + " COM " + qtdBoleto + " BOLETO NO VALOR DE ");
        for (int i = 0; i < qtdBoleto; i++) {
            if (i != qtdBoleto - 1) {
                System.out.print(listaBoletos.getListaDeBoletos().get(i).getValor() + ", ");
            } else {
                System.out.print("e " + listaBoletos.getListaDeBoletos().get(i).getValor() + ": ");
            }
        }
        System.out.print("FATURA " + estadoFatura);
    }
}
