package test.tomcat7.security;

import java.security.Principal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;

@SessionScoped
public class LoginAuthenticator implements Authenticator {
	

	private static final long serialVersionUID = 1L;

	@Inject
	private Login credential;
	
	//private User user;
	private Principal principal; 
	
	@Override
	public void authenticate() {
		if ((credential.getLogin().equals("admin"))&&(credential.getPassword().equals("admin"))) {
		
			principal = new Principal() {
				
				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			
		}
		
	}

	@Override
	public Principal getUser() {
		
		//retornar o objeto User carregado no authenticate
		
		//c�digo para retornar usu�rio logado
		return principal;
	}

	@Override
	public void unAuthenticate() {
		principal = null;
		
		// TODO Auto-generated method stub
	}

}
