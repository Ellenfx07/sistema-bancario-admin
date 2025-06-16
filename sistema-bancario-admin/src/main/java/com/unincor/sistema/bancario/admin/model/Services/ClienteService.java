/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.Services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.ClienteDao;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calis
 */

  
   
public class ClienteService {

    private final ClienteDao clienteDao = new ClienteDao();

    public void salvarCliente(Cliente cliente) throws CadastroException, SQLException {
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new CadastroException("Cliente não possui um nome.");
        }
        if (cliente.getCpf() == null || cliente.getCpf().isBlank()) {
            throw new CadastroException("Cliente não possui um CPF informado.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isBlank()) {
            throw new CadastroException("Cliente não possui um e-mail informado.");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().isBlank()) {
            throw new CadastroException("Cliente não possui um telefone informado.");
        }
        if (cliente.getSenhaHash() == null || cliente.getSenhaHash().isBlank()) {
            throw new CadastroException("Cliente não possui uma senha informada.");
        }

        clienteDao.inserirCliente(cliente);
    }

    public List<Cliente> buscarClientes() {
        return clienteDao.listarTodosClientes();
    }

    public static void main(String[] args) throws SQLException {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente(); 

        try {
            clienteService.salvarCliente(cliente);
        } catch (CadastroException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    

