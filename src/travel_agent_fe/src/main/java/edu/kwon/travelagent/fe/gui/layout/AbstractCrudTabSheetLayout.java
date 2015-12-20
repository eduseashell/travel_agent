package edu.kwon.travelagent.fe.gui.layout;

import com.vaadin.server.Page;

import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractTabSheetLayout;

/**
 * @author eduseashell
 */
public abstract class AbstractCrudTabSheetLayout extends AbstractTabSheetLayout {

	private static final long serialVersionUID = -3046868173780012435L;
	
	@Override
	public void onEditActionClicked() {
		if (getSelectedItemId() == null) {
			VaadinFactory.getNotification(I18N.string("edit"), I18N.string("msg.info.to.edit"))
				.show(Page.getCurrent());
		} else {
			onEditItem(getSelectedItemId());
		}
	}
	
	@Override
	public void onDeleteActionClicked() {
		if (getSelectedItemId() == null) {
			VaadinFactory.getNotification(I18N.string("edit"), I18N.string("msg.info.to.delete"))
				.show(Page.getCurrent());
		} else {
			onDeleteItem(getSelectedItemId());
		}
	}
	
	protected void onDeleteItem(Long id) {
		// TODO delete item
	}
	
	protected abstract void onEditItem(Long id);
	protected abstract Long getSelectedItemId();

}
