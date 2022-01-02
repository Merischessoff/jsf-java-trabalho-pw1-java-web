/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;


public class ConnectionFactory {
    public Connection getConnection() {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String urlBD="jdbc:mysql://localhost:3306/bd";
           return DriverManager.getConnection(urlBD, "meri", "@Teste@1");
        } catch (SQLException e) {
            System.out.println("Exceção SQL - ConnectionFactory");
        } catch(ClassNotFoundException e){
            System.out.println("Exceção Classe não encontrada - ConnectionFactory");
        }
        return null;
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{  

        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd?serverTimezone=UTC","meri","@Teste@1");  
            System.out.println("tentando conexao");  
    }
    
}
