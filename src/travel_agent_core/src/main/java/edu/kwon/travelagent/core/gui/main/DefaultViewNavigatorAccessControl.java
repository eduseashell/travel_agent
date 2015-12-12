package edu.kwon.travelagent.core.gui.main;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.UI;

import edu.kwon.frmk.vaadin.util.VaadinHelper;

/**
 * View navigation handler
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
public class DefaultViewNavigatorAccessControl implements ViewChangeListener {

	private static final long serialVersionUID = -3789628007247201335L;
	
	private AbstractUI ui;
	
	public DefaultViewNavigatorAccessControl(AbstractUI ui) {
		this.ui = ui;
	}

	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		if (AbstractUI.LOGIN_PANEL_NAME == null) {
			throw new IllegalStateException("UI Login Panel Name cannot be null.");
		}
		if (AbstractUI.LOGIN_PANEL_NAME.equals(event.getViewName())) {
			if (isLogIn()) {
				// User already login, go to welcome page
				VaadinHelper.setUriFragment(AbstractUI.WELCOME_PANEL_NAME);
				return false;
			}
			ui.prepareForLoginPanel();
		} else {
			if (!isLogIn()) {
				VaadinHelper.setUriFragment(AbstractUI.LOGIN_PANEL_NAME);
				return false;
			}
			ui.prepareForViewPanel();
		}
		return true;
	}
	
	/**
	 * Whether the user is already login
	 * @return
	 */
	public boolean isLogIn() {
		Boolean isLogIn = (Boolean) UI.getCurrent().getSession().getAttribute("isLogin");
		if (isLogIn == null) {
			return false;
		} else {
			return isLogIn;
		}
	}

	@Override
	public void afterViewChange(ViewChangeEvent event) { }

}
