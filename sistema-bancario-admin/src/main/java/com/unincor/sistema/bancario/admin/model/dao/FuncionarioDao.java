/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.configurations.MySQL;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;
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

public class FuncionarioDao {

    public void inserirFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios(nome, cpf, data_nascimento, email, telefone, senha_hash) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(4, funcionario.getEmail());
            ps.setString(5, funcionario.getTelefone());
            ps.setString(6, funcionario.getSenhaHash());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = construirFuncionarioSql(rs);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public Funcionario buscarFuncionarioPorId(Long idFuncionario) {
        String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, idFuncionario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirFuncionarioSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        String sql = "SELECT * FROM funcionarios WHERE cpf = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirFuncionarioSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Funcionario construirFuncionarioSql(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(rs.getLong("id_funcionario"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        funcionario.setEmail(rs.getString("email"));
        funcionario.setTelefone(rs.getString("telefone"));
        funcionario.setSenhaHash(rs.getString("senha_hash"));
        return funcionario;
    }

    public static void main(String[] args) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();

      
        Funcionario f = new Funcionario();
        f.setNome("João Silva");
        f.setCpf("12345678900");
        f.setDataNascimento(java.time.LocalDate.of(1990, 5, 20));
        f.setEmail("joao@empresa.com");
        f.setTelefone("31999998888");
        f.setSenhaHash("senha123hash");
        funcionarioDao.inserirFuncionario(f);


        var funcionario = funcionarioDao.buscarFuncionarioPorId(1L);
        if (funcionario != null) {
            System.out.println("Id: " + funcionario.getIdFuncionario() + " Nome: " + funcionario.getNome());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}