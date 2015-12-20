package edu.kwon.travelagent.fe.gui.layout;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractSearchPanel;

public class DefaultSearchPanel extends AbstractSearchPanel {

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
	protected ClickListener onSearchActionClicked() {
		// TODO default search panel on search action clicked
		return null;
	}

	@Override
	public void reset() {
		txtSearchText.setValue("");
	}

}
