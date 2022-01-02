package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	public int logar(String login, String senha){
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt =  connection.prepareStatement(SQLs.LOGIN.getSql())){
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				return 1;
			}
		}catch(SQLException e){ 
			e.printStackTrace();
			System.out.println("Excecao SQL - login usuario");
		}catch(Exception e){  
			e.printStackTrace();
			System.out.println("Excecao no codigo - login usuario");
		}
		return -1;
	}
    
}
