package edu.kwon.travelagent.core.gui.main;

import ru.xpoft.vaadin.DiscoveryNavigator;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Abstract UI: A VAADIN UI extended class
 * with a layout of top, main (middle), and bottom
 * @author eduseashell
 *
 * @since Jul 4, 2015
 * @since 0.0.1
 * @version 0.0.1
 */
public abstract class AbstractUI extends UI {

	private static final long serialVersionUID = 9170972564399365378L;
	
	private static final String DEFAULT_WELCOME_PANEL_NAME = "";
	private static final String DEFAULT_LOGIN_PANEL_NAME = "";
	public static String WELCOME_PANEL_NAME = DEFAULT_WELCOME_PANEL_NAME;
	public static String LOGIN_PANEL_NAME = DEFAULT_LOGIN_PANEL_NAME;
	
	private VerticalLayout topPanelHolder;
	private VerticalLayout mainPanelHolder;
	private VerticalLayout bottomPanelHolder;
	
	private VerticalLayout content;
	private ComponentContainer topPanel;
	private ComponentContainer mainPanel;
	private ComponentContainer bottomPanel;

	@Override
	protected void init(VaadinRequest request) {
		initControls();
		
		topPanel = buildTopPanel();
		if (topPanel != null) {
			topPanelHolder.addComponent(topPanel);
		}
		
		mainPanel = buildMainPanel();
		DiscoveryNavigator navigator;
		if (mainPanel == null) {
			navigator = new DiscoveryNavigator(this, mainPanel);
		} else {
			navigator = new DiscoveryNavigator(this, mainPanelHolder);
		}
		navigator.addViewChangeListener(getViewAccessControl());
		
		bottomPanel = buildBottomPanel();
		if (bottomPanel != null) {
			bottomPanelHolder.addComponent(bottomPanel);
		}
	}
	
	/**
	 * Initialize controls
	 */
	private void initControls() {
		topPanelHolder = new VerticalLayout();
		topPanelHolder.setHeightUndefined();
		mainPanelHolder = new VerticalLayout();
		mainPanelHolder.setSizeFull();
		bottomPanelHolder = new VerticalLayout();
		content = new VerticalLayout();
		
		Panel panel = new Panel();
		panel.setSizeFull();
		panel.setStyleName(ValoTheme.PANEL_BORDERLESS);
		panel.setContent(content);
		
		content.addComponent(mainPanelHolder);
		content.setExpandRatio(mainPanelHolder, 1);
		content.addComponent(bottomPanelHolder);
		
		VerticalLayout bodyLayout = new VerticalLayout();
		bodyLayout.setSizeFull();
		bodyLayout.addComponent(topPanelHolder);
		bodyLayout.addComponent(panel);
		bodyLayout.setExpandRatio(panel, 1);
		setContent(bodyLayout);
	}
	
	/**
	 * Prepare the UI for login panel
	 * which remove the top and bottom panel
	 * and set proper content height
	 */
	public void prepareForLoginPanel() {
		topPanelHolder.removeAllComponents();
		bottomPanelHolder.removeAllComponents();
		content.setHeight(100, Unit.PERCENTAGE);
	}
	
	/**
	 * Prepare the UI for View (except Login)
	 * include the top and bottom panel
	 * and set proper content height
	 */
	public void prepareForViewPanel() {
		topPanelHolder.addComponent(topPanel);
		bottomPanelHolder.addComponent(bottomPanel);
		content.setHeightUndefined();
	}
	
	/**
	 * The view navigation access control
	 * Override this method to provide an alternative access
	 * control to DefaultViewNavigatorAccessControl
	 * @return
	 */
	protected ViewChangeListener getViewAccessControl() {
		return new DefaultViewNavigatorAccessControl(this);
	}
	
	protected ComponentContainer buildMainPanel() {
		return new VerticalLayout();
	}

	protected abstract VerticalLayout buildTopPanel();
	
	protected abstract VerticalLayout buildBottomPanel();
	
}
