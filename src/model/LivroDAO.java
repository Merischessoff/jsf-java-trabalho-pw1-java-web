package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;



public class LivroDAO implements GenericDAO<Livro>{
		@Override
		public int insert(Livro livro) {
			int chavePrimaria = -1;
			try(Connection connection = new ConnectionFactory().getConnection(); 
				PreparedStatement stmt = connection.prepareStatement(SQLs.INSERT_LIVRO.getSql(), Statement.RETURN_GENERATED_KEYS)){
				stmt.setString(1, livro.getNome());
				stmt.setDouble(2, livro.getValorUnitario());
				stmt.setString(3, livro.getAutor());
				stmt.setInt(4, livro.getAno());
				stmt.setInt(5, livro.getNumPaginas());
				stmt.execute();
				ResultSet chaves = stmt.getGeneratedKeys();
				if (chaves.next())  
					return chavePrimaria= chaves.getInt(1);
			}catch(SQLException e){
				System.out.println("Excecao no codigo - LivroBean insert");
				e.printStackTrace();
			}
			return chavePrimaria;
		}

		@Override
		public int update(Livro l) {
	        try(Connection connection = new ConnectionFactory().getConnection();
	        	PreparedStatement stmt = 
	                connection.prepareStatement(SQLs.UPDATE_LIVRO.getSql());){
	            System.out.println("SQL = "+SQLs.UPDATE_LIVRO.getSql());
	            System.out.println("Conexão aberta!");
	            stmt.setDouble(1, l.getValorUnitario());
	            stmt.setString(2, l.getAutor());
	            stmt.setInt(3, l.getAno());
	            stmt.setInt(4, l.getNumPaginas());
	            stmt.setString(5, l.getNome());
	            stmt.executeUpdate();
	            return 0;
	        }catch(SQLException e){
	            System.out.println("excecao com recursos - atualizar livro");
	        }
			return -1;
		}

		@Override
		public int delete(Livro l) {
	        try(Connection connection = new ConnectionFactory().getConnection();
		        PreparedStatement stmt = 
		                connection.prepareStatement(SQLs.DELETE_LIVRO.getSql());){
	            stmt.setString(1, l.getNome());
	            stmt.executeUpdate();
	            return 0;
	        }catch(SQLException e){
	            System.out.println("excecao com recursos - remover livro");
	        }
	        return -1;
		}

		@Override
		public Livro findByID(int id) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public  List<Livro> listAll() {
			List<Livro> lista = new LinkedList<>();

			try(Connection connection = new ConnectionFactory().getConnection();
					PreparedStatement stmt = 
							connection.prepareStatement(SQLs.LISTALL_LIVRO.getSql())){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					String nome = rs.getString("nome");
					double valorUnitario = rs.getDouble("valorUnitario");
					String autor = rs.getString("autor");
					int ano = rs.getInt("ano");
					int numPaginas = rs.getInt("numPaginas");
					lista.add(new Livro(nome, valorUnitario, autor, ano, numPaginas));
				}
				return lista;
			}catch(SQLException e){ 
				System.out.println("Exce��o SQL - listAll Livro");
			}catch(Exception e){  
				System.out.println("Exce��o no c�digo - listAll Livro!");
			}
			return null;
		}

		
}