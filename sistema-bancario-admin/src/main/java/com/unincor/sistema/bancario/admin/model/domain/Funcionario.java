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
public class Funcionario extends Pessoa  {
     
    
    private Long idFuncionario;
  private String turno;
            
            
    public Funcionario() {
    }

    public Funcionario( String nome, String cpf, LocalDate dataNascimento,
            String email, String telefone, String senhaHash) {
 
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senhaHash = senhaHash;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public String getTurno() {
        return turno;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
    
    
    
    
    
    
    
    
    
}
