package edu.kwon.travelagent.fe.gui.user.list;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractSearchPanel;

@org.springframework.stereotype.Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserSearchPanel extends AbstractSearchPanel {

	private static final long serialVersionUID = 8784219661911994041L;
	
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
		return e -> reset();
	}

	@Override
	public void reset() {
		txtSearchText.setValue("");
	}

}
