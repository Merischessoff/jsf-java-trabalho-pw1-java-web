package controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Livro;

@ManagedBean
@SessionScoped
public class LivroBean implements Serializable{
    private static final long serialVersionUID = 356240640918386194L;
    private Livro livro = new Livro();
    private List<Livro> lista ;

    public LivroBean() {
        this.livro = new Livro();
     }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLista() {
        if(lista == null)
           lista = livro.listAll();
        return lista;
    }
   
    public String atualizar(Livro livro){
    	FacesContext context = FacesContext.getCurrentInstance();
    	int retorno = livro.update();
    	if(retorno < 0) {
        	String msg = "Erro ao atualizar Livro";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage("editarLivro:mensagem", mensagem);
        	return "editarLivro";
        }else {
            lista = livro.listAll();
	    	limpar();
	        return "listarLivro";
        }
    }
    
    public String cadastrar() {
    	FacesContext context = FacesContext.getCurrentInstance();
        int retorno = livro.insert();
        if(retorno < 0) {
        	String msg = "Erro ao cadastrar Livro";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage("cadastrarLivro:mensagem", mensagem);
        	return "cadastrarLivro";
        }else {
        	lista = livro.listAll();
	        limpar();
	        return "listarLivro";
        }
    }
    
    public String excluir(Livro livro){
    	FacesContext context = FacesContext.getCurrentInstance();
        int retorno = livro.delete(livro);
        if(retorno < 0) {
        	String msg = "Erro ao excluir o livro";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage("listarLivro:mensagem", mensagem);
        	return "listarLivro";
        }else {
        	lista = livro.listAll();
	        limpar();
	        return "listarLivro";
        }
    }
    
     public String editar(Livro livro){
        this.livro = livro;
        return "editarLivro";
    }
    
  public void limpar() {
	  this.livro = new Livro();
  }
}
