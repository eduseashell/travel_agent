package edu.kwon.travelagent.fe.gui.master.header;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.UI;

import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.gui.menu.AbstractMenuBar;
import edu.kwon.frmk.vaadin.util.helper.VaadinHelper;
import edu.kwon.travelagent.fe.gui.MainUI;
import edu.kwon.travelagent.fe.gui.security.LoginPanel;
import edu.kwon.travelagent.fe.ui.view.dashboard.DashboardPanel;

/**
 * TAFEMenu Bar
 * "Travel Agent Front End" menu bar
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TAFEMenu extends AbstractMenuBar {
	
	private static final long serialVersionUID = -4241661350709674394L;

	/**
	 * Build menu
	 */
	protected void buildMenu() {
		MenuItem users = addItem(I18N.string("TAFEMenu.users"), null);
		users.addItem(I18N.string("TAFEMenu.dashboard"), new MenuCommand(DashboardPanel.NAME));
		
		users.addItem("Open", new MenuCommand(LoginPanel.NAME));
		users.addItem("Exit", new Command() {
			
			/** */
			private static final long serialVersionUID = 3768225081578437470L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getSession().setAttribute("isLogin", false);
				VaadinHelper.setUriFragment(MainUI.LOGIN_PANEL_NAME);
			}
		});
		
		MenuItem view = addItem("View", null);
		view.addItem("Edit", null);
		view.addItem("View", null);
	}

}
