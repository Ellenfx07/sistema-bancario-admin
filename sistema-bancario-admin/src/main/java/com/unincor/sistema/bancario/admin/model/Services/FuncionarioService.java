/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.Services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.FuncionarioDao;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calis
 */
public class FuncionarioService {

    private final FuncionarioDao funcionarioDao = new FuncionarioDao();

    public void salvarFuncionario(Funcionario funcionario) throws CadastroException, SQLException {
        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new CadastroException("Funcionário não possui um nome.");
        }
        if (funcionario.getCpf() == null || funcionario.getCpf().isBlank()) {
            throw new CadastroException("Funcionário não possui um CPF informado.");
        }
        if (funcionario.getEmail() == null || funcionario.getEmail().isBlank()) {
            throw new CadastroException("Funcionário não possui um e-mail informado.");
        }
        if (funcionario.getTelefone() == null || funcionario.getTelefone().isBlank()) {
            throw new CadastroException("Funcionário não possui um telefone informado.");
        }
        if (funcionario.getSenhaHash() == null || funcionario.getSenhaHash().isBlank()) {
            throw new CadastroException("Funcionário não possui uma senha informada.");
        }

        funcionarioDao.inserirFuncionario(funcionario);
    }

    public List<Funcionario> buscarFuncionarios() {
        return funcionarioDao.buscarTodosFuncionarios();
    }

    public static void main(String[] args) throws SQLException {
        FuncionarioService funcionarioService = new FuncionarioService();

        Funcionario funcionario = new Funcionario(); 

        try {
            funcionarioService.salvarFuncionario(funcionario);
        } catch (CadastroException ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    

