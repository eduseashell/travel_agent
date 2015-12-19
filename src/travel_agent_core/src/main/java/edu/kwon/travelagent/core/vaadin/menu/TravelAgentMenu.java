package edu.kwon.travelagent.core.vaadin.menu;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.kwon.frmk.common.data.jpa.repository.menus.menu.Menu;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.gui.menu.AbstractMenuBar;

/**
 * TravelAgentMenu
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TravelAgentMenu extends AbstractMenuBar {

	private static final long serialVersionUID = 7617779502184985905L;

	/**
	 * @see edu.kwon.frmk.vaadin.gui.menu.AbstractMenuBar#buildMenu()
	 */
	@Override
	protected void buildMenu() {
		Menu menu = MenuHelper.builtMenu();
		
		for (edu.kwon.frmk.common.data.jpa.repository.menus.item.MenuItem item : menu.getMenuItems()) {
			addMenuToMenuBar(item, null);
		}
	}
	
	private void addMenuToMenuBar(edu.kwon.frmk.common.data.jpa.repository.menus.item.MenuItem item, MenuItem parent) {
		if (parent != null) {
			parent.addItem(I18N.string(item.getCaptionKey()), new MenuCommand(item.getAction()));
		} else {
			parent = addItem(I18N.string(item.getCaptionKey()), null);
		}
		if (item.getChildren() != null) {
			for (edu.kwon.frmk.common.data.jpa.repository.menus.item.MenuItem child : item.getChildren()) {
				addMenuToMenuBar(child, parent);
			}
		}
	}

}
