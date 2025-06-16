/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.bancario.admin.model.domain;

/**
 *
 * @author calis
 */
public class Agencia {
    private long id_agencia ;
   private String  codigo_agencia; 
    private String cidade; 
   private String  uf; 
   private String  logradouro;
   private Integer  numero ;
   private  String  cep;

    public Agencia(long id_agencia, String codigo_agencia, String cidade, String uf, String logradouro, Integer numero, String cep) {
        this.id_agencia = id_agencia;
        this.codigo_agencia = codigo_agencia;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    public Agencia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public long getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(long id_agencia) {
        this.id_agencia = id_agencia;
    }

    public String getCodigo_agencia() {
        return codigo_agencia;
    }

    public void setCodigo_agencia(String codigo_agencia) {
        this.codigo_agencia = codigo_agencia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCodigoAgencia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdAgencia(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCodigoAgencia(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNumero(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getnumero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
}

