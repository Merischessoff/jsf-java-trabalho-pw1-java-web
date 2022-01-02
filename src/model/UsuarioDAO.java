package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Encryptor;

public class UsuarioDAO {
	public int logar(String login, String senha){
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt =  connection.prepareStatement(SQLs.LOGIN.getSql())){
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				String senhaBanco = Encryptor.decrypt("Bar12345Bar12345", "RandomInitVector", rs.getString("senha"));
				if(senhaBanco.equalsIgnoreCase(senha)) {
					return 1;
				}
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
