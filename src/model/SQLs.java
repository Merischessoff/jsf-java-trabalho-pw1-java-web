package model;

public enum SQLs {
    LOGIN("SELECT * FROM usuario WHERE email = ? AND senha = ?"),
    INSERT_PRODUTO("INSERT INTO produto(nome, valorUnitario) VALUES (?, ?)"),
    INSERT_LIVRO("INSERT INTO livro(nome, valorUnitario, autor, ano, numPaginas) VALUES (?, ?, ?, ?, ?)"),
    LISTALL_LIVRO("SELECT * FROM livro"),
    UPDATE_LIVRO("UPDATE livro SET valorUnitario = ?, autor = ?, ano = ?, numPaginas = ?  WHERE nome = ?"),
    DELETE_LIVRO("DELETE FROM livro WHERE nome = ?"),
    INSERT_VESTUARIO("INSERT INTO vestuario(nome, valorUnitario, categoria, genero, tamanho) VALUES(?, ?, ?, ?, ?)"),
	LISTALL_VESTUARIO("SELECT * FROM vestuario"),
	UPDATE_VESTUARIO("UPDATE vestuario SET valorUnitario = ?, categoria = ?, genero = ?, tamanho = ? WHERE nome = ?"),
	DELETE_VESTUARIO("DELETE FROM vestuario WHERE nome = ?");
	
	private final String sql;
    SQLs(String sql){
        this.sql = sql; 
    }
    public String getSql() {
        return sql;
    }    
}

