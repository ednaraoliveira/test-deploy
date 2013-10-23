package test.glassfish3_jdbc.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import test.glassfish3_jdbc.business.BookmarkBC;
import test.glassfish3_jdbc.domain.Bookmark;

@ViewController
@PreviousView("/bookmark_list.xhtml")
public class BookmarkEditMB extends AbstractEditPageBean<Bookmark, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookmarkBC bookmarkBC;

	@Override
	@Transactional
	public String delete() {
		try {
			this.bookmarkBC.delete(getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		try {
			this.bookmarkBC.insert(getBean());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		try {
			this.bookmarkBC.update(getBean());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getPreviousView();
	}

	@Override
	protected Bookmark handleLoad(Long id) {
		return null;
	}
}
