package model;

import java.util.List;


public class Vestuario extends Produto{
	private String categoria = "";
	private String genero = "";
	private String tamanho = "";
	
	public Vestuario(String nome, double valorUnitario, String categoria, String genero, String tamanho) {
		super(nome, valorUnitario);
		this.categoria = categoria;
		this.genero = genero;
		this.tamanho = tamanho;
	}

	public Vestuario() {
		super();
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	@Override
	public String toString() {
		return "Vestuario [categoria=" + categoria + ", genero=" + genero + ", tamanho=" + tamanho + "]";
	}
		
	public int insert() {
		return new VestuarioDAO().insert(this);
	}
	public List<Vestuario> listAll(){
		return new VestuarioDAO().listAll();
	}
	
	public int update(){
		return new VestuarioDAO().update(this);
	}
	public int delete(Vestuario p){
		return new VestuarioDAO().delete(p);
	}
	
}
