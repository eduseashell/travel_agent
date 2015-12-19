package edu.kwon.travelagent.core.vaadin.menu;

import java.util.ArrayList;

import edu.kwon.frmk.common.data.jpa.repository.menus.item.MenuItem;
import edu.kwon.frmk.common.data.jpa.repository.menus.menu.Menu;

/**
 * 
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
public class MenuHelper {
	
	public static Menu builtMenu() {
		// TODO load from database
		MenuItem users = getMenuItem("TAFEMenu.users", null);
		users.setChildren(new ArrayList<MenuItem>());
		users.getChildren().add(getMenuItem("users", ""));
		users.getChildren().add(getMenuItem("exit", ""));
		
		MenuItem view = getMenuItem("TAFEMenu.dashboard", null);
		view.setChildren(new ArrayList<MenuItem>());
		view.getChildren().add(getMenuItem("edit", ""));
		view.getChildren().add(getMenuItem("view", ""));
		
		Menu menu = new Menu();
		menu.setMenuItems(new ArrayList<MenuItem>());
		menu.getMenuItems().add(users);
		menu.getMenuItems().add(view);
		
		return menu;
	}
	
	// TODO remove
	private static MenuItem getMenuItem(String key, String action) {
		MenuItem item = new MenuItem();
		item.setCaptionKey(key);
		item.setAction(action);
		return item;
	}

}
