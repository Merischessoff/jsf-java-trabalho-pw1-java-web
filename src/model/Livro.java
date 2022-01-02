package model;


import java.util.List;

public class Livro extends Produto{
	private String autor = "";
	private int ano = 0;
	private int numPaginas = 0;
	public Livro() {
		super();
	}
	
	public Livro(String nome, double valorUnitario, String autor, int ano, int numPaginas) {
		super(nome, valorUnitario);
		this.autor = autor;
		this.ano = ano;
		this.numPaginas = numPaginas;
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}

	@Override
	public double getValorUnitario() {
		// TODO Auto-generated method stub
		return super.getValorUnitario();
	}

	@Override
	public void setValorUnitario(double valorUnitario) {
		// TODO Auto-generated method stub
		super.setValorUnitario(valorUnitario);
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	@Override
	public String toString() {
		return "LivroBean [autor=" + autor + ", ano=" + ano + ", numPaginas=" + numPaginas + "]";
	}
	public int insert() {
		return new LivroDAO().insert(this);
	}
	public List<Livro> listAll(){
		return new LivroDAO().listAll();
	}
	public int update(){
		return new LivroDAO().update(this);
	}
	public int delete(Livro p){
		return new LivroDAO().delete(p);
	}
}
