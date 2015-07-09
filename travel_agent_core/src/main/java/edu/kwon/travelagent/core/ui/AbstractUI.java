package edu.kwon.travelagent.core.ui;

import org.springframework.util.StringUtils;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ru.xpoft.vaadin.DiscoveryNavigator;

/**
 * Abstract UI: A VAADIN UI extended class
 * with a layout of top, main (middle), and bottom
 * @author Bunlong Taing
 *
 * @since Jul 4, 2015
 * @since 0.0.1
 * @version 0.0.1
 */
public abstract class AbstractUI extends UI implements ViewChangeListener {

	private static final long serialVersionUID = 9170972564399365378L;
	
	public static String AFTER_LOG_IN_PANEL_NAME = "";
	
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
//			mainPanel.setSizeFull();
			navigator = new DiscoveryNavigator(this, mainPanel);
		} else {
			navigator = new DiscoveryNavigator(this, mainPanelHolder);
		}
		
		bottomPanel = buildBottomPanel();
		if (bottomPanel != null) {
			bottomPanelHolder.addComponent(bottomPanel);
		}
		
		navigator.addViewChangeListener(this);
		setAfterLogInPanelName();
	}
	
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
	
	public boolean beforeViewChange(ViewChangeEvent event) {
		if (StringUtils.isEmpty(event.getViewName())) {		// if is empty, it is login
			topPanelHolder.removeAllComponents();
			bottomPanelHolder.removeAllComponents();
			content.setHeight(100, Unit.PERCENTAGE);
			if (isLogIn()) {
				Page.getCurrent().setUriFragment("!" + AFTER_LOG_IN_PANEL_NAME);
				return false;
			}
		} else {
			topPanelHolder.addComponent(topPanel);
			bottomPanelHolder.addComponent(bottomPanel);
			content.setHeightUndefined();
			if (!isLogIn()) {
				Page.getCurrent().setUriFragment("!");
				return false;
			}
		}
		return true;
	}
	
	protected ComponentContainer buildMainPanel() {
		return new VerticalLayout();
	}

	public void afterViewChange(ViewChangeEvent event) {
	}
	
	protected abstract VerticalLayout buildTopPanel();
	
	protected abstract VerticalLayout buildBottomPanel();
	
	protected abstract boolean isLogIn();
	
	protected abstract void setAfterLogInPanelName();

}
