/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.Services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.GerenteDao;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calis
 */
public class GerenteService {

    private final GerenteDao gerenteDao = new GerenteDao();

    public void salvarGerente(Gerente gerente) throws CadastroException, SQLException {
        if (gerente.getNome() == null || gerente.getNome().isBlank()) {
            throw new CadastroException("Gerente não possui um nome.");
        }
        if (gerente.getCpf() == null || gerente.getCpf().isBlank()) {
            throw new CadastroException("Gerente não possui um CPF informado.");
        }
        if (gerente.getEmail() == null || gerente.getEmail().isBlank()) {
            throw new CadastroException("Gerente não possui um e-mail informado.");
        }
        if (gerente.getTelefone() == null || gerente.getTelefone().isBlank()) {
            throw new CadastroException("Gerente não possui um telefone informado.");
        }
        if (gerente.getSenhaHash() == null || gerente.getSenhaHash().isBlank()) {
            throw new CadastroException("Gerente não possui uma senha informada.");
        }
        if (gerente.getAgencia() == null || gerente.getAgencia().getIdAgencia() == null) {
            throw new CadastroException("Gerente deve estar vinculado a uma agência.");
        }

        gerenteDao.inserirGerente(gerente);
    }

    public List<Gerente> buscarGerentes() {
        return gerenteDao.buscarTodosGerentes();
    }

    public static void main(String[] args) throws SQLException {
        GerenteService gerenteService = new GerenteService();

       
        Gerente gerente = new Gerente(); 
        try {
            gerenteService.salvarGerente(gerente);
        } catch (CadastroException ex) {
            Logger.getLogger(GerenteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

