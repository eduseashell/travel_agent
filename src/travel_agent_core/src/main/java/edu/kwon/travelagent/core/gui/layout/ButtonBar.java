package edu.kwon.travelagent.core.gui.layout;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;

public class ButtonBar extends HorizontalLayout {

	private static final long serialVersionUID = 3686260973812736441L;
	private static final String BTN_NEW = "New";
	private static final String BTN_EDIT = "Edit";
	private static final String BTN_DELETE = "Delele";
	private static final String BTN_SAVE = "Save";
	
	private Button btnNew;
	private Button btnEdit;
	private Button btnDelete;
	private Button btnSave;
	
	public ButtonBar() {
		setSpacing(true);
	}
	
	public void addNewButton(String caption) {
		if (btnNew == null) {
			addButton(caption, BTN_NEW);
		}
	}
	
	public void addEditButton(String caption) {
		if (btnEdit == null) {
			addButton(caption, BTN_EDIT);
		}
	}
	
	public void addDeleteButton(String caption) {
		if (btnDelete == null) {
			addButton(caption, BTN_DELETE);
		}
	}
	
	public void addSaveButton(String caption) {
		if (btnSave == null) {
			addButton(caption, BTN_SAVE);
		}
	}
	
	private void addButton(String caption, String type) {
		if (caption == null) {
			caption = type;
		}
		if (BTN_NEW.equals(type)) {
			btnNew = VaadinFactory.getButtonDanger(caption);
			btnNew.setIcon(FontAwesome.PLUS);
			addComponent(btnNew);
		} else if (BTN_EDIT.equals(type)) {
			btnEdit = VaadinFactory.getButton(caption);
			btnEdit.setIcon(FontAwesome.EDIT);
			addComponent(btnEdit);
		} else if (BTN_DELETE.equals(type)) {
			btnDelete = VaadinFactory.getButton(caption);
			btnDelete.setIcon(FontAwesome.TRASH_O);
			addComponent(btnDelete);
		} else if (BTN_SAVE.equals(type)) {
			btnSave = VaadinFactory.getButtonPrimary(caption);
			btnSave.setIcon(FontAwesome.SAVE);
			addComponent(btnSave);
		} else {
			addButton(VaadinFactory.getButton(caption));
		}
	}
	
	public void addButton(Button btn) {
		addComponent(btn);
	}
	
	public static ButtonBar buildDefaultCrudBar() {
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.addNewButton(null);
		buttonBar.addEditButton(null);
		buttonBar.addDeleteButton(null);
		return buttonBar;
	}
	
	public void addNewButtonClickListener(ClickListener listener) {
		if (btnNew != null) {
			btnNew.addClickListener(listener);
		}
	}
	
	public void addEditButtonClickListener(ClickListener listener) {
		if (btnEdit != null) {
			btnEdit.addClickListener(listener);
		}
	}
	
	public void addDeleteButtonClickListener(ClickListener listener) {
		if (btnDelete != null) {
			btnDelete.addClickListener(listener);
		}
	}
	
	public void addSaveButtonClickListener(ClickListener listener) {
		if (btnSave != null) {
			btnSave.addClickListener(listener);
		}
	}

}
