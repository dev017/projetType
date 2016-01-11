package com.projet.type.view.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.primefaces.application.exceptionhandler.ExceptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;

import com.projet.type.entity.Users;
import com.projet.type.service.data.IUsersService;
import com.projet.type.utilitaires.Utils;
import com.projet.type.view.util.MessageFactory;


@Component("loginBean")
@Scope("session")
@RequestScoped
public class LoginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6749712399939669235L;
	private String userId;
    private String password;
//    @Value("${application-appName}")
//    private String applicationName;

//	@Autowired
//	IsendmailService sendMailService;
    
    @Autowired
    IUsersService usersService;
    
    @Autowired
    Environment env;
    
    private Users userConnected;
//    @ManagedProperty(value = "#{sessionRegistry}")
//    private SessionRegistry sessionRegistry;

    /**
     * l'authentification se fait par cette méthode 
     */
    public String doLogin() throws IOException, ServletException {
         
        //cette méthode prend le context et le passe a spring
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((SecurityContextHolderAwareRequestWrapper) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        
//        //mettre le userId dans la sessions
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId", userId);
//        
//        //récupérer le user par son login et le mettre dans la session
        Users u=usersService.getUserByLogin(userId);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
        
        //redirection vers la page suivante        
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
       
        return null;
    }

    public String doLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/logout.xhtml";
    }

    public void sendNewPassword(){
    	//récupérer le user par son login et le mettre dans la session
        Users user=usersService.getUserByLogin(userId);
        if(null != user){
        	String pass = Utils.makeRandomPass();
        	String encryptBcrypt = Utils.encryptBcrypt(pass);
        	user.setPassword(encryptBcrypt);
        	usersService.saveUsers(user);
//        	sendMailService.sendLoginAccess(user.getName(),user.getLogin(),pass, user.getMail());
        }else{
        	String message= "Le login saisi est introuvable.";
	        FacesMessage facesMessage = MessageFactory.getMessage(message,"Erreur: ",FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	        return;
        }
    }
    
    public void sendMailException() {
    	if(Arrays.asList(env.getDefaultProfiles()).contains("prod")){
    		 FacesContext context = FacesContext.getCurrentInstance();
        	 ExceptionInfo info = context.getApplication().evaluateExpressionGet(context, "#{pfExceptionHandler}", ExceptionInfo.class);
        	 
        	 
    		 userConnected = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    		 if(userConnected!=null){
    			 String body="Une exception à été catcher pour:"+userConnected.getLogin()+"\r\n";
    			 String sujet ="Exception:"; 
    			 if(info!=null){
    				 sujet=info.getType();
    				 body+=info.getFormattedStackTrace();
    			 }
//    			 sendMailService.sendMail("dev017@gmail.com", sujet,body );
    		 }
		}
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
