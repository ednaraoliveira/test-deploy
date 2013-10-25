package test.jboss6.monitor;

import javax.inject.Inject;

import test.jboss6.business.BookmarkBC;
import br.gov.frameworkdemoiselle.annotation.ManagedOperation;
import br.gov.frameworkdemoiselle.annotation.ManagedProperty;
import br.gov.frameworkdemoiselle.stereotype.ManagementController;


@ManagementController
public class BookmarkMonitor{
 
    @ManagedProperty(description="Determina se é possival incluir novos bookmarks")
    private boolean insertBookmarkEnabled = true;
 
    @Inject
    private BookmarkBC bookmarkBC;
 
    @ManagedOperation
    public int countRegisteredBookmarks(){
        return bookmarkBC.findAll().size();
    }
 
    public boolean getInsertBookmarkEnabled() {
        return insertBookmarkEnabled;
    }
 
    public void setInsertBookmarkEnabled(boolean insertBookmarkEnabled) {
        this.insertBookmarkEnabled = insertBookmarkEnabled;
    }
}