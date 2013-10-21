package test.glassfish3.message;

import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.Message;


public interface InfoMessages {

	final Message FAVORITO_INSERT_OK = new DefaultMessage("{bookmark-insert-ok}");
	final Message FAVORITO_UPDATE_OK = new DefaultMessage("{bookmark-update-ok}");
	final Message FAVORITO_DELETE_OK = new DefaultMessage("{bookmark-delete-ok}");

}
