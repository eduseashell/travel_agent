package edu.kwon.travelagent.fe.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.travelagent.core.gui.main.AbstractUI;
import edu.kwon.travelagent.core.vaadin.themes.VaadinTheme;
import edu.kwon.travelagent.fe.ui.view.dashboard.DashboardPanel;
import edu.kwon.travelagent.fe.ui.view.footer.BottomPanel;
import edu.kwon.travelagent.fe.ui.view.header.TopPanel;
import edu.kwon.travelagent.fe.ui.view.login.LoginPanel;

/**
 * MainUI the application main page
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Theme(VaadinTheme.THEME_NAME)
@PreserveOnRefresh
@Title("Travel Agent")
public class MainUI extends AbstractUI {

	private static final long serialVersionUID = 5766722647521771460L;
	
	@Autowired
	private TopPanel topPanel;
	@Autowired
	private BottomPanel bottomPanel;
	
	@PostConstruct
	public void postConstruct() {
		LOGIN_PANEL_NAME = LoginPanel.NAME;
		WELCOME_PANEL_NAME = DashboardPanel.NAME;
	}

	/**
	 * @see edu.kwon.travelagent.core.gui.main.AbstractUI#buildTopPanel()
	 */
	@Override
	protected VerticalLayout buildTopPanel() {
		return topPanel;
	}
	
	@Override
	protected VerticalLayout buildBottomPanel() {
		return bottomPanel;
	}

}
