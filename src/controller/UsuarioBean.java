package controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private static final long serialVersionUID = 356240640918386194L;
    private Usuario usuario = new Usuario();
    private Usuario usuarioLogado = new Usuario();
    private List<Usuario> lista ;

    public UsuarioBean() {
        this.usuario = new Usuario();
     }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

//    public List<Usuario> getLista() {
//        if(lista == null)
//           lista = usuario.listar();
//        return lista;
//    }
//   
//    public String atualizar(Usuario user){
//    	FacesContext context = FacesContext.getCurrentInstance();
//    	boolean retorno = user.atualizar();
//    	if(!retorno) {
//        	String msg = "Erro ao atualizar usu�rio";
//        	FacesMessage mensagem = new FacesMessage(msg);
//        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
//        	context.addMessage(null, mensagem);
//        }
//        else
//            lista = usuario.listar();
//    	limpar();
//        return "listar";
//    }
//    public String cadastrar() {
//    	FacesContext context = FacesContext.getCurrentInstance();
//        boolean retorno = usuario.cadastrar();
//        if(!retorno) {
//        	String msg = "Erro ao cadastrar usu�rio";
//        	FacesMessage mensagem = new FacesMessage(msg);
//        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
//        	context.addMessage(null, mensagem);
//        }
//        else
//        	lista = usuario.listar();
//        limpar();
//        return "listar";
//    }
    
    public String logar() {
        if(usuario.logar()>-1){
           this.usuarioLogado = usuario;    
           usuario = new Usuario();
           return "menu";
        }
        else {
        	FacesContext context = FacesContext.getCurrentInstance();
        	String msg = "Usuário ou senha Inválidos. Tente novamente!";
            FacesMessage mensagem = new FacesMessage(msg);
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
           	context.addMessage(":login:mensagem", mensagem);
            return "login";
        }
    }
//    public void limpar() {
//       this.usuario = new Usuario();
//    }
    
//    public String excluir(Usuario user){
//    	FacesContext context = FacesContext.getCurrentInstance();
//        boolean retorno = user.excluir();
//        if(!retorno) {
//        	String msg = "Erro ao excluir usu�rio";
//        	FacesMessage mensagem = new FacesMessage(msg);
//        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
//        	context.addMessage(null, mensagem);
//        }
//        else
//        	lista = usuario.listar();
//        limpar();
//        return "listar";
//    }
//     public String editar(Usuario user){
//        this.usuario = user;
//        return "editar";
//    }
}
