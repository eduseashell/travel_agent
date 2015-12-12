package edu.kwon.travelagent.fe.ui.view.header;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.UI;

import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.util.VaadinHelper;
import edu.kwon.travelagent.core.gui.menu.AbstractMenuBar;
import edu.kwon.travelagent.fe.ui.MainUI;
import edu.kwon.travelagent.fe.ui.view.dashboard.DashboardPanel;
import edu.kwon.travelagent.fe.ui.view.login.LoginPanel;

/**
 * TAFEMenu Bar
 * "Travel Agent Front End" menu bar
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TAFEMenu extends AbstractMenuBar {
	
	private static final long serialVersionUID = -4241661350709674394L;

	private I18N i18n;

	/**
	 * Build menu
	 */
	protected void buildMenu() {
		i18n = AppContext.getBean(I18N.class);
		MenuItem users = addItem(i18n.string("TAFEMenu.users"), null);
		users.addItem(i18n.string("TAFEMenu.dashboard"), new MenuCommand(DashboardPanel.NAME));
		
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
