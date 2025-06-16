/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

import java.time.LocalDate;

/**
 * 
 * @author calis
 */
public class Gerente extends Pessoa {
    
    private Long idGerente;    
    private Agencia agencia;

    public Gerente() {
    }
    
    public Gerente(Long idCliente, String nome, String cpf, LocalDate dataNascimento,
            String email, String telefone) {
        this.idGerente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

 

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
}