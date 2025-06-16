/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author calis
 */

public class GerenteDao {

    public void inserirGerente(Gerente gerente) {
        String sql = "INSERT INTO GERENTES(cpf, nome, data_nascimento, email, telefone, senha_hash, id_agencia) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, gerente.getCpf());
            ps.setString(2, gerente.getNome());
            ps.setDate(3, Date.valueOf(gerente.getDataNascimento()));
            ps.setString(4, gerente.getEmail());
            ps.setString(5, gerente.getTelefone());
            ps.setString(6, gerente.getSenhaHash());
            ps.setLong(7, gerente.getAgencia().getIdAgencia());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Gerente> listarTodosGerentes() {
        String sql = "SELECT * FROM GERENTES";
        List<Gerente> gerentes = new ArrayList<>();
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gerentes.add(construirGerenteSql(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gerentes;
    }

    public Gerente buscarGerentePorId(Long id) {
        String sql = "SELECT * FROM GERENTES WHERE id_gerente = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirGerenteSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Gerente buscarGerentePorCpf(String cpf) {
        String sql = "SELECT * FROM GERENTES WHERE cpf = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirGerenteSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Gerente construirGerenteSql(ResultSet rs) throws SQLException {
        Gerente gerente = new Gerente();
        gerente.setIdGerente(rs.getLong("id_gerente"));
        gerente.setCpf(rs.getString("cpf"));
        gerente.setNome(rs.getString("nome"));
        gerente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        gerente.setEmail(rs.getString("email"));
        gerente.setTelefone(rs.getString("telefone"));
        gerente.setSenhaHash(rs.getString("senha_hash"));

        Agencia agencia = new Agencia();
        agencia.setIdAgencia(rs.getLong("id_agencia"));
        gerente.setAgencia(agencia);

        return gerente;
    }

    public static void main(String[] args) {
        GerenteDao gerenteDao = new GerenteDao();

        System.out.println("Teste de inserir gerente:");
        Gerente gerente = new Gerente();
        gerente.setCpf("12345678900");
        gerente.setNome("Carlos Silva");
        gerente.setDataNascimento(java.time.LocalDate.of(1980, 5, 20));
        gerente.setEmail("carlos.silva@email.com");
        gerente.setTelefone("35999998888");
        gerente.setSenhaHash("senha123");

        Agencia agencia = new Agencia();
        agencia.setIdAgencia(1L); // Coloque o id_agencia existente no seu banco de dados
        gerente.setAgencia(agencia);

        gerenteDao.inserirGerente(gerente);

        System.out.println("Teste listar todos gerentes:");
        List<Gerente> gerentes = gerenteDao.listarTodosGerentes();
        gerentes.forEach(g -> System.out.println("Nome: " + g.getNome() + ", CPF: " + g.getCpf()));

        System.out.println("Teste buscar gerente por ID:");
        Gerente g = gerenteDao.buscarGerentePorId(1L);
        if (g != null) {
            System.out.println("Nome: " + g.getNome() + ", CPF: " + g.getCpf());
        }

        System.out.println("Teste buscar gerente por CPF:");
        Gerente gCpf = gerenteDao.buscarGerentePorCpf("12345678900");
        if (gCpf != null) {
            System.out.println("Nome: " + gCpf.getNome() + ", CPF: " + gCpf.getCpf());
        }
    }

    public List<Gerente> buscarTodosGerentes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

