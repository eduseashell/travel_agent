package edu.kwon.travelagent.fe.gui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.frmk.vaadin.gui.main.AbstractUI;
import edu.kwon.frmk.vaadin.gui.main.DefaultErrorViewProvider;
import edu.kwon.frmk.vaadin.gui.user.UserTabSheet;
import edu.kwon.travelagent.core.vaadin.themes.TravelAgentTheme;
import edu.kwon.travelagent.fe.gui.master.footer.BottomPanel;
import edu.kwon.travelagent.fe.gui.master.header.TopPanel;
import edu.kwon.travelagent.fe.gui.security.LoginPanel;

/**
 * MainUI the application main page
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Theme(TravelAgentTheme.THEME_NAME)
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
		LOGIN_PANEL_NAME = LoginPanel.VIEW_NAME;
		WELCOME_PANEL_NAME = UserTabSheet.VIEW_NAME;
		
		DefaultErrorViewProvider errorViewProvider = new DefaultErrorViewProvider();
		errorViewProvider.setErrorViewClass(LoginPanel.class);
		errorViewProvider.setErrorViewName(LoginPanel.VIEW_NAME);
		setErrorViewProvider(errorViewProvider);
	}

	/**
	 * @see edu.kwon.frmk.vaadin.gui.main.AbstractUI#buildTopPanel()
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
