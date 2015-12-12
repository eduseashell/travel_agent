package edu.kwon.travelagent.core.ui.layout;

import javax.management.Query;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;

public abstract class AbstractSearchLayout extends Panel implements ClickListener {

	private static final long serialVersionUID = -1530748963546870334L;

	private Button btnSearch;
	private Button btnReset;

	public AbstractSearchLayout() {
		setCaption("Search");
		VerticalLayout content = new VerticalLayout();
		content.setMargin(true);
		setContent(content);

		content.addComponent(initGUI());
		content.addComponent(buildSearchAndResetLayout());
	}

	private HorizontalLayout buildSearchAndResetLayout() {
		btnSearch = VaadinFactory.getButtonPrimary("Search");
		btnSearch.setIcon(FontAwesome.SEARCH);
		btnSearch.setClickShortcut(KeyCode.ENTER);
		btnReset = VaadinFactory.getButton("Reset");
		btnReset.setIcon(FontAwesome.REFRESH);
		btnReset.addClickListener(this);

		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setSpacing(true);
		buttonLayout.addComponent(btnSearch);
		buttonLayout.addComponent(btnReset);

		return buttonLayout;
	}
	
	public void buttonClick(ClickEvent event) {
		if (event.getButton() == btnReset) {
			reset();
		}
	}
	
	public void addSearchClickListener(ClickListener listener) {
		btnSearch.addClickListener(listener);
	}
	
	protected abstract Component initGUI();

	public abstract Query getRestrictions();
	
	public abstract void reset();

}
