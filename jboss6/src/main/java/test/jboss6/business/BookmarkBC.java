package test.jboss6.business;


import javax.inject.Inject;

import test.jboss6.config.PropertiesConfig;
import test.jboss6.domain.Bookmark;
import test.jboss6.persistence.BookmarkDAO;
import test.jboss6.security.Login;
import br.gov.frameworkdemoiselle.annotation.Priority;
import br.gov.frameworkdemoiselle.lifecycle.Shutdown;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	PropertiesConfig propertiesConfig;
	
	@Inject
	Login login;
	
	@Inject
	private SecurityContext securityContext;	
	
	@Startup
	@Priority(2)
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}
	}
	
	@Startup
	@Priority(1)
	public void initServer() {
		System.out.println("********************** INICIANDO O SERVIDOR ********************** ");
	}
	
	@Startup
	@Priority(3)
	public void executeGrant() {
		System.out.println("********************** HABILITANDO AS PERMISSÕES ********************** ");
	}
	
	@Startup
	@Priority(4)
	public void readConfig() {
		System.out.println("********************** CONFIGURACOES ********************** ");
		System.out.println("backgroundColor....: " + propertiesConfig.getBackgroundColor());
		System.out.println("fontFamily.........: " + propertiesConfig.getFontFamily());
		System.out.println("fontColor..........: " + propertiesConfig.getFontColor());
		System.out.println("fontSize...........: " + propertiesConfig.getFontSize());
		System.out.println("textAlign..........: " + propertiesConfig.getAlign());
	}	
	
	@Shutdown
	@Priority(1)
	public void removeGrant() {
		System.out.println("********************** DESABILITANDO AS PERMISSÕES ********************** ");
	}

	@Shutdown
	@Priority(2)
	public void stopServer() {
		System.out.println("********************** FINALIZANDO O SERVIDOR ********************** ");
	}	
	
	
	@Override
	@RequiredRole("admin")
	public void insert(Bookmark bean) {
		System.out.println("Inserindo...");
		super.insert(bean);
	}	
	
	public void logar() {
		System.out.println("LOGANDO...");
		login.setLogin("admin");
		login.setPassword("admin");
		login.setRole("admin");
		securityContext.login();
	}

	
}
