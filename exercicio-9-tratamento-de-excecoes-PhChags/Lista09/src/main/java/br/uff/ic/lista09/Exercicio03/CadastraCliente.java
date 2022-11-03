/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista09.Exercicio03;

import java.util.ArrayList;
import br.uff.ic.lista09.Exercicio03.Exceptions.*;

/**
 *
 * @author Pedro
 */
public class CadastraCliente {
    private final int MAX_CLIENTES = 10;
    private ArrayList<Cliente> clientes = new ArrayList<>(MAX_CLIENTES);

    public void inserirClientes(int cpf, String nome, int idade) throws DadoInvalidoException, ClienteJaCadastradoException, RepositorioException {
        Cliente c = new Cliente(cpf, nome, idade);
        Cliente cliente = null;

        if (clientes.size() == MAX_CLIENTES) {
            throw new RepositorioException();
        }
        try {
            cliente = buscarCliente(cpf);
        }
        catch (ClienteInexistenteException ex) {
            clientes.add(c);
        }
        if (cliente != null) {
            throw new ClienteJaCadastradoException();
        }
    }

    public Cliente buscarCliente(int cpf) throws ClienteInexistenteException {
        int buscaSucesso = 0;
        for (Cliente cliente: clientes) {
            if (cliente.getCpf() == cpf) {
                buscaSucesso = 1;
                return cliente;
            }
        }
        throw new ClienteInexistenteException();
    }
}
