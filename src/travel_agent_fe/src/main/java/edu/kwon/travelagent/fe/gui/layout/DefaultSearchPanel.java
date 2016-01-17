package edu.kwon.travelagent.fe.gui.layout;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import edu.kwon.frmk.common.data.jpa.repository.entities.audit.AuditEntity;
import edu.kwon.frmk.common.data.jpa.repository.entities.root.RootSpecification;
import edu.kwon.frmk.vaadin.component.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractSearchPanel;

public class DefaultSearchPanel<T extends AuditEntity> extends AbstractSearchPanel<T> {

	private static final long serialVersionUID = -5051741067714638818L;
	
	private TextField txtSearchText;

	@Override
	protected Component initGUI() {
		txtSearchText = VaadinFactory.getTextField("search");
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(txtSearchText);
		return layout;
	}
	
	@Override
	protected RootSpecification<T> getSpecification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		txtSearchText.setValue("");
	}

}
