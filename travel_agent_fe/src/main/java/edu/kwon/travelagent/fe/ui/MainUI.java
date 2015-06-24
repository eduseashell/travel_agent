package edu.kwon.travelagent.fe.ui;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.travelagent.core.ui.AbstractUI;
import edu.kwon.travelagent.core.vaadin.themes.VaadinTheme;
import edu.kwon.travelagent.fe.ui.view.dashboard.DashboardPanel;
import edu.kwon.travelagent.fe.ui.view.footer.BottomPanel;
import edu.kwon.travelagent.fe.ui.view.header.TopPanel;

/**
 * MainUI the application main page
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope("prototype")
@Theme(VaadinTheme.THEME_NAME)
public class MainUI extends AbstractUI {

	private static final long serialVersionUID = 5766722647521771460L;

	/**
	 * @see edu.kwon.travelagent.core.ui.AbstractUI#buildTopPanel()
	 */
	@Override
	protected VerticalLayout buildTopPanel() {
		return new TopPanel();
	}

	@Override
	protected VerticalLayout buildMainPanel() {
		return new VerticalLayout();
	}
	
	@Override
	protected VerticalLayout buildBottomPanel() {
		return new BottomPanel();
	}

	@Override
	protected boolean isLogIn() {
		Boolean isLogIn = (Boolean) UI.getCurrent().getSession().getAttribute("isLogin");
		if (isLogIn == null) {
			return false;
		} else {
			return isLogIn;
		}
	}

	@Override
	protected void setAfterLogInPanelName() {
		AFTER_LOG_IN_PANEL_NAME = DashboardPanel.NAME;
	}

}
