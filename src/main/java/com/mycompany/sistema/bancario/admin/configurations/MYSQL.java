package com.mycompany.sistemabancario.admin.configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class MYSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_bancario";
    
    private static final String USER = "root";
    
    private static final String PASS = "admin";
    
        public static Connection connect() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
        public static void main(String[] args) {
        System.out.println(connect());
    }
}