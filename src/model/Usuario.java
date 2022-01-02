package model;

import java.io.Serializable;

public class Usuario implements Serializable{
    private static final long serialVersionUID = 7371518231621030644L;
    private String email;
    private String senha;
    
    public Usuario() {
    	
    }
    
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + "]";
	}

	public int logar() {
		return new UsuarioDAO().logar(this.getEmail(), this.getSenha());
	}
    
}
