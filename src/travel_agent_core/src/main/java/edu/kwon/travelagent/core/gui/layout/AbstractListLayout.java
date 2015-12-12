package edu.kwon.travelagent.core.gui.layout;

import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.frmk.vaadin.component.select.SimpleTable;

public abstract class AbstractListLayout extends VerticalLayout implements ItemClickListener {

	private static final long serialVersionUID = -3764552665962371644L;
	
	private Resource icon;
	private AbstractSearchLayout searchLayout;
	private AbstractTabsheet tabsheet;
	private Item selectedItem;
	private Long selectedItemId;
	protected SimpleTable table;
	
	public AbstractListLayout() {
		setMargin(true);
		setSpacing(true);
		
		searchLayout = buildSearchPanel();
		searchLayout.addSearchClickListener(new SearchClickListener());
		addComponent(searchLayout);
		addComponent(initGUI());
		
		table.addItemClickListener(this);
	}

	protected void buildDefaultCRUDBar() {
		ButtonBar crudBar = ButtonBar.buildDefaultCrudBar();
		crudBar.addNewButtonClickListener(new NewButtonListener());
		crudBar.addEditButtonClickListener(new EditButtonListener());
		crudBar.addDeleteButtonClickListener(new DeleteButtonListener());
		addComponent(crudBar, 0);
	}
	
	public abstract Component initGUI();
	
	public abstract AbstractSearchLayout buildSearchPanel();
	
	protected void buildTableDataSource(List<?> entities) {
		if (entities != null) {
//			for (T row : entities) {
//				renderRow(table.addItem(row.getId()), row);
//			}
		} else {
			Notification info = new Notification("Information", "Sorry, no item found.", Type.HUMANIZED_MESSAGE);
			info.setDelayMsec(2000);
			info.show(Page.getCurrent());
		}
	}
	
//	public abstract void renderRow(Item item, T entity);
	
	protected abstract List<Column> buildColumns();

	private class SearchClickListener implements ClickListener {
		private static final long serialVersionUID = 5002744533707652856L;

		public void buttonClick(ClickEvent event) {
//			buildTableDataSource(searchLayout.getRestrictions().getResultList());
		}
	}
	
	private class NewButtonListener implements ClickListener {
		private static final long serialVersionUID = 409666159411013956L;

		public void buttonClick(ClickEvent event) {
			tabsheet.addNewEntity();
		}
	}
	
	private class EditButtonListener implements ClickListener {
		private static final long serialVersionUID = -6345612035764585791L;

		public void buttonClick(ClickEvent event) {
			if (selectedItemId == null) {
				Notification info = new Notification("Information", "To edit, please select one item.", Type.HUMANIZED_MESSAGE);
				info.setDelayMsec(2000);
				info.show(Page.getCurrent());
			} else {
				tabsheet.editEntity(getSelectedItemId());
			}
		}
	}
	
	private class DeleteButtonListener implements ClickListener {
		private static final long serialVersionUID = 2239593442237027172L;

		public void buttonClick(ClickEvent event) {
			if (selectedItemId == null) {
				Notification info = new Notification("Information", "To delete, please select one item.", Type.HUMANIZED_MESSAGE);
				info.setDelayMsec(2000);
				info.show(Page.getCurrent());
			} else {
				tabsheet.deleteEntity(getSelectedItemId());
			}
		}
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
	
	public void refresh() {
		// TODO
	}
	
	public void setMainPanel(AbstractTabsheet tabsheet) {
		this.tabsheet = tabsheet;
	}
	
	public Item getSelectedItem() {
		return selectedItem;
	}
	
	public Long getSelectedItemId() {
		return selectedItemId;
	}

	public void itemClick(ItemClickEvent event) {
		selectedItem = event.getItem();
		selectedItemId = (Long) event.getItemId();
	}
	
}
