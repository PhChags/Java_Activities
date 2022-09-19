/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04.Exercicio07;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String resp, resp2, nome, end, formPag, data, hora, prodName, tipoProd;
        float valor;
        int qnt, id;
        
        System.out.println("Deseja adicionar algum pedido? (S/N)");
        resp = teclado.next();
        while("S".equals(resp) || "s".equals(resp)){
            
            teclado.nextLine();
            System.out.println("Informe o nome do cliente desse pedido: ");
            nome = teclado.nextLine();
            teclado.nextLine();
            System.out.println("Informe o endereco do cliente desse pedido: ");
            end = teclado.nextLine();
            teclado.nextLine();
            System.out.println("Informe a data em que o pedido foi feito: ");
            data = teclado.nextLine();
            teclado.nextLine();
            System.out.println("Informe o horario em que o pedido foi feito: ");
            hora = teclado.nextLine();
            teclado.nextLine();
            System.out.println("Informe a forma de pagamento do pedido: ");
            formPag = teclado.nextLine();
            Pedido pedido = new Pedido(nome, end, formPag);
            pedido = new Pedido(data, hora);

            teclado.nextLine();
            System.out.println("Informe o id do produto comprado: ");
            id = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Informe o nome do produto comprado: ");
            prodName = teclado.nextLine();
            teclado.nextLine();
            System.out.println("Informe o tipo do produto comprado: ");
            tipoProd = teclado.nextLine();
            teclado.nextLine();
            System.out.println("Informe o valor do produto comprado: ");
            valor = teclado.nextFloat();
            teclado.nextLine();
            System.out.println("Informe a quantidade pedida pelo cliente: ");
            qnt = teclado.nextInt();
            teclado.nextLine();

            Produto produto = new Produto(id, prodName, valor, tipoProd);
            Item item = new Item(produto, qnt);
            pedido.setItem(item);

            System.out.println("Hah mais itens no pedido? (S/N)");
            resp2 = teclado.next();

            while("S".equals(resp2) || "s".equals(resp2)){
                teclado.nextLine();
                System.out.println("Informe o id do produto comprado: ");
                id = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Informe o nome do produto comprado: ");
                prodName = teclado.nextLine();
                teclado.nextLine();
                System.out.println("Informe o tipo do produto comprado: ");
                tipoProd = teclado.nextLine();
                teclado.nextLine();
                System.out.println("Informe o valor do produto comprado: ");
                valor = teclado.nextFloat();
                teclado.nextLine();
                System.out.println("Informe a quantidade pedida pelo cliente: ");
                qnt = teclado.nextInt();
                teclado.nextLine();

                produto = new Produto(id, prodName, valor, tipoProd);
                item = new Item(produto, qnt);
                pedido.setItem(item);
                

                System.out.println("Hah mais itens no pedido? (S/N)");
                resp2 = teclado.next();
                teclado.nextLine();
            }
           
            System.out.println();
            System.out.print("O cliente " + nome + " deve pagar um total de R$");
            System.out.printf("%.2f", pedido.getTotalAPagar());
            System.out.print(" por meio de " + formPag);
            System.out.println();
            System.out.println(" Deseja adicionar outro pedido? (S/N)");
            resp = teclado.next();
        }
    }
}