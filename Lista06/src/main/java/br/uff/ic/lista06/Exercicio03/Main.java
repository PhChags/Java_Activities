/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    
    public static void main(String[] args) {
        Agenda agenda = Agenda.getInstance();
        Main.executaMenu(agenda);
    }
    
    private static void executaMenu(Agenda agenda){
        String[] menuTags = {"Encerrar" , "Adicionar contato", "Mostrar agenda", "Procurar contato"};
        Scanner teclado = new Scanner(System.in);
        boolean encerrar = false;
        
        while(!encerrar){
            System.out.println("=====================================");
            for(int i = 0; i < 4; i++){
                System.out.printf("[%d] - %s\n", i, menuTags[i]);
            }
            System.out.println("=====================================");
            System.out.print("==> ");
            int op = Integer.parseInt(teclado.next());
            switch (op) {
                case 0:
                    encerrar = true;
                    break;
                case 1:
                    String[] addTags = {"Cancelar", "Pessoa fisica", "Pessoa juridica"};
                    for (int i = 0; i < 3; i++) {
                        System.out.printf("[%d] - %s\n", i, addTags[i]);
                    }
                    op = Integer.parseInt(teclado.next());
                    switch (op) {
                        case 1:
                            agenda.addContato(criarPessoaFisica());
                            break;
                        case 2:
                            agenda.addContato(criarPessoaJuridica());
                    }
                    break;
                case 2:
                    Main.mostrarAgenda(agenda);
                    break;
                case 3:
                    String[] procurarTags = {"Cancelar", "Pessoa Fisica", "Pessoa Juridica"};
                    for (int i = 0; i < 3; i++) {
                        System.out.printf("[%d] - %s\n", i, procurarTags[i]);
                    }
                    op = Integer.parseInt(teclado.next());
                    switch (op) {
                        case 1:
                            System.out.println("CPF:");
                            String cpf = teclado.next();
                            agenda.procurarContato(cpf, "Pessoa Fisica");
                            break;
                        case 2:
                            System.out.println("CNPJ:");
                            String cnpj = teclado.next();
                            agenda.procurarContato(cnpj, "Pessoa Juridica");
                            break;
                    }
                    break;
            }
        }
    }
        private static Fisica criarPessoaFisica() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Nome:");
        String nome = teclado.nextLine();
        System.out.println("CPF:");
        String cpf = teclado.nextLine();
        System.out.println("Endereco:");
        String endereco = teclado.nextLine();
        System.out.println("Data de aniversario:");
        String aniversario = teclado.nextLine();
        System.out.println();

        return new Fisica(endereco, nome, cpf, aniversario);
    }

    private static Juridica criarPessoaJuridica() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Razao social:");
        String razaoSocial = teclado.nextLine();
        System.out.println("CNPJ:");
        String cnpj = teclado.nextLine();
        System.out.println("Endereco:");
        String endereco = teclado.nextLine();
        System.out.println("Faturamento:");
        double faturamento = Double.parseDouble(teclado.next());
        System.out.println();

        return new Juridica(endereco, razaoSocial, cnpj, faturamento);
    }
    
    static void mostrarPessoaFisica(Fisica pessoa) {
        System.out.printf("""
                          Nome: %s
                          CPF: %s
                          Endereco: %s
                          Data de aniversario: %s
                          """,
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getEndereco(),
                pessoa.getAniversario()
        );
    }

    static void mostrarPessoaJuridica(Juridica contato) {
        System.out.printf("""
                          Razao social: %s
                          CNPJ: %s
                          Endereco: %s
                          Faturamento: %.2f
                          """,
                contato.getRazaoSocial(),
                contato.getCnpj(),
                contato.getEndereco(),
                contato.getFaturamento()
        );
    }

    private static void mostrarAgenda(Agenda agenda) {
        ArrayList contatos;
        contatos = agenda.getContatos();
        
        for (Object contato : contatos) {
            System.out.println("-------------------------------------");
            if (contato.getClass().equals(Fisica.class)) {
                Main.mostrarPessoaFisica((Fisica) contato);
            }
            if (contato.getClass().equals(Juridica.class)) {
                Main.mostrarPessoaJuridica((Juridica) contato);
            }
        }
    }
}
