package model;

public class Produto {
	private String nome = "";
	private double valorUnitario = 0;
	
	public Produto() {
		super();
	}

	public Produto(String nome, double valorUnitario) {
		super();
		this.nome = nome;
		this.valorUnitario = valorUnitario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", valorUnitario=" + valorUnitario + "]";
	}
	
}
