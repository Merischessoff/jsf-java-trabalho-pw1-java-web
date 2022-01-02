package controller;
import java.io.Serializable;

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
}
