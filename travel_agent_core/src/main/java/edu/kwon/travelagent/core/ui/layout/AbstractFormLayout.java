package edu.kwon.travelagent.core.ui.layout;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;

public abstract class AbstractFormLayout extends AbstractLayout implements ClickListener {
	
	private static final long serialVersionUID = -7445312774424876403L;
	
	private Resource icon;
	private AbstractTabsheet tabsheet;
		
	public AbstractFormLayout() {
		setMargin(true);
		setSpacing(true);
		
		buildDefaultCRUDBar();
		addComponent(initGUI());
	}
	
	protected void buildDefaultCRUDBar() {
		ButtonBar crudBar = new ButtonBar();
		crudBar.addSaveButton("Save");
		crudBar.addSaveButtonClickListener(this);
		addComponent(crudBar, 0);
	}
	
	public Resource getIcon() {
		return icon;
	}

	public void setIcon(Resource icon) {
		this.icon = icon;
	}
	
	public void setIcon(String icon) {
		this.icon = new ThemeResource(icon);
	}
	
	public void buttonClick(ClickEvent event) {
		if (validate()) {
			save();
			tabsheet.setNeedRefresh(Boolean.TRUE);
		}
	}
	
	public void setMainPanel(AbstractTabsheet tabsheet) {
		this.tabsheet = tabsheet;
	}
	
	protected abstract void save();
	
	protected abstract Component initGUI();
	
	protected abstract void assignValues(Long entityId);
	
	protected abstract void reset();
	
	protected abstract boolean validate();
}
