/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.AgenciaDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author calis
 */

public class AgenciaService {

    private final AgenciaDao agenciaDao = new AgenciaDao();

    public void salvarAgencia(Agencia agencia) throws CadastroException {
        if (agencia.getCodigoAgencia() == null || agencia.getCodigoAgencia().isBlank()) {
            throw new CadastroException("Agência não possui um código de agência");
        }

  
        Agencia agenciaBusca = agenciaDao.buscarAgenciaPorCodigo(agencia.getCodigoAgencia());
        if (agenciaBusca != null) {
            throw new CadastroException("Código da agência já está cadastrado");
        }
        
      
       if (agencia.getCidade() == null || agencia.getCidade().isBlank()) {
            throw new CadastroException("Agência não possui uma cidade informada!!");
        }
       if (agencia.getUf() == null || agencia.getUf().isBlank()) {
            throw new CadastroException("Agência não possui uma uf informada!!");
        }
        agenciaDao.inserirAgencia(agencia);
    }
    
    public List<Agencia> buscarAgencias(){
        return agenciaDao.listarTodasAgencias();
    }

    public static void main(String[] args) {
        AgenciaService agenciaService = new AgenciaService();
        Agencia agencia = new Agencia(null, null, "Três Corações", "MG", "Rei Pelé", "25", "3741000");
        
        try {
            agenciaService.salvarAgencia(agencia);
        } catch (CadastroException ex) {
                        Logger.getLogger(AgenciaService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}