package test.glassfish3_jdbc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.Priority;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import test.glassfish3_jdbc.domain.Bookmark;
import test.glassfish3_jdbc.persistence.BookmarkDAO;

@BusinessController
public class BookmarkBC implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Inject
     private BookmarkDAO bookmarkDAO;

     @Transactional
     public void insert(Bookmark bookmark) throws Exception {
             bookmarkDAO.insert(bookmark);
     }

     @Transactional
     public void delete(Long id) throws Exception {
             bookmarkDAO.delete(id);
     }

     @Transactional
     public void update(Bookmark bookmark) throws Exception {
             bookmarkDAO.update(bookmark);
     }

     public Bookmark findById(Long id) throws Exception {
             return bookmarkDAO.findById(id);
     }

     public List<Bookmark> findAll() throws Exception {
             return bookmarkDAO.findAll();
     }

     @Startup
     @Priority(2)
     @Transactional
     public void load() throws Exception {
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
                     
                     insert(new Bookmark("Uol", "http://www.uol.com.br"));
                     insert(new Bookmark("Terra", "http://www.terra.com.br"));
                     insert(new Bookmark("G1", "http://www.g1.com.br"));
                     insert(new Bookmark("Globo", "http://www.globo.com.br"));
                     
     }
	
}
