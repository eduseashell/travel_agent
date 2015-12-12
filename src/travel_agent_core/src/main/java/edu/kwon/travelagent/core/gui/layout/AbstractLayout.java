package edu.kwon.travelagent.core.gui.layout;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractLayout extends VerticalLayout implements View {

	private static final long serialVersionUID = 4604528382074499136L;
	
	public AbstractLayout() {
		setMargin(true);
	}
	
	public void enter(ViewChangeEvent event) {
	}

}
