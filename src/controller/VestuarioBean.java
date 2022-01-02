package controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Vestuario;

@ManagedBean
@SessionScoped
public class VestuarioBean implements Serializable{
    private static final long serialVersionUID = 356240640918386194L;
    private Vestuario vestuario = new Vestuario();
    private List<Vestuario> lista ;

    public VestuarioBean() {
        this.vestuario = new Vestuario();
     }
    public Vestuario getVestuario() {
        return vestuario;
    }
    public void setVestuario(Vestuario vestuario) {
        this.vestuario = vestuario;
    }

    public List<Vestuario> getLista() {
        if(lista == null)
           lista = vestuario.listAll();
        return lista;
    }
   
    public String atualizar(Vestuario vestuario){
    	FacesContext context = FacesContext.getCurrentInstance();
    	int retorno = vestuario.update();
    	if(retorno < 0) {
        	String msg = "Erro ao atualizar Vestuario";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage(":editarVestuario:mensagem", mensagem);
        	return "editarVestuario";
        }
        else {
            lista = vestuario.listAll();
	    	limpar();
	        return "listarVestuario";
        }
    }
    
    public String cadastrar() {
    	FacesContext context = FacesContext.getCurrentInstance();
        int retorno = vestuario.insert();
        if(retorno < 0) {
        	String msg = "Erro ao cadastrar Vestuario";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage("cadastrarVestuario:mensagem", mensagem);
        	return "cadastrarVestuario";
        }else {
        	lista = vestuario.listAll();
	        limpar();
	        return "listarVestuario";
        }
    }
    
    public String excluir(Vestuario vestuario){
    	FacesContext context = FacesContext.getCurrentInstance();
        int retorno = vestuario.delete(vestuario);
        if(retorno < 0) {
        	String msg = "Erro ao excluir o vestuario";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage("listarVestuario:mensagem", mensagem);
        	return "listarVestuario";
        }else {
        	lista = vestuario.listAll();
	        limpar();
	        return "listarVestuario";
        }
    }
    
     public String editar(Vestuario vestuario){
        this.vestuario = vestuario;
        return "editarVestuario";
    }
    
  public void limpar() {
	  this.vestuario = new Vestuario();
  }
}
