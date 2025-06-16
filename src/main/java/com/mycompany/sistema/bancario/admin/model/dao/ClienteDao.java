/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.bancario.admin.model.dao;

import com.mycompany.sistema.bancario.admin.model.domain.Cliente;
import com.mycompany.sistemabancario.admin.configurations.MYSQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calis
 */
public class ClienteDao {
public void inserirCliente(Cliente cliente) {
        String sql = " INSERT INTO clientes(nome, cpf, data_nascimento, email, telefone, senha_hash) VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection con = MySQL.connect();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getSenhaHash());
            ps.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> buscarTodosClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try(Connection con = MySQL();PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               var cliente = contruirClienteSql(rs);
                clientes.add(cliente);
                
                
            }
    }   catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return clientes;
    }

        
            public Cliente buscarClientePorId(Long idCliente) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try (Connection con = MYSQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
          ps.setLong(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getNString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setsenhaHash(rs.getString("senhaHast"));
                cliente.setTelefone(rs.getString("telefone"));

                return cliente;
            

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

      public  Cliente contruirClienteSql(ResultSet rs)throws SQLException   {
          
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getNString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setsenhaHash(rs.getString("senhaHast"));
                cliente.setTelefone(rs.getString("telefone"));
           return cliente;
           
          
      }   
            
            
      public static void main(String[] args) {
   //     Cliente cliente = new Cliente(null, "Kaylaine", "124568875", LocalDate.now(),
     //           "aluna.kaylaine.fat@unincor.edu.br", "4564654897", "54564515435454545");
        ClienteDao clienteDao = new ClienteDao();
       // var clientes = clienteDao.buscarTodosClientes();
       // clientes.forEach(c ->System.out.println("Id: " + c.getIdCliente()
         //       + "nome:  " + c.getNome()
        //));
         var c = clienteDao.buscarClientePorId(1l);
          System.err.println("Id: " + c.getIdCliente() + "Nome: "+ c.getNome());
    } 

    private Connection MySQL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
