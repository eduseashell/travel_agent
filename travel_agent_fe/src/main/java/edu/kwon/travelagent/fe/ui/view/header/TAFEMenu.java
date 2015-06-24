package edu.kwon.travelagent.fe.ui.view.header;

import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.travelagent.core.ui.menu.AbstractMenuBar;
import edu.kwon.travelagent.fe.ui.view.dashboard.DashboardPanel;
import edu.kwon.travelagent.fe.ui.view.login.LoginPanel;

/**
 * TAFEMenu Bar
 * "Travel Agent Front End" menu bar
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
public class TAFEMenu extends AbstractMenuBar {
	
	private static final long serialVersionUID = -4241661350709674394L;

	/**
	 * Build menu
	 */
	protected void buildMenu() {
		MenuItem users = addItem(I18N.string("TAFEMenu.users"), null);
		users.addItem(I18N.string("TAFEMenu.dashboard"), new MenuCommand(DashboardPanel.NAME));
		users.addItem("Open", new MenuCommand(LoginPanel.NAME));
		users.addItem("Exit", null);
		
		MenuItem view = addItem("View", null);
		view.addItem("Edit", null);
		view.addItem("View", null);
	}

}
