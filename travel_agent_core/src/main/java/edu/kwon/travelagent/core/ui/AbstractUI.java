package edu.kwon.travelagent.core.ui;

import org.springframework.util.StringUtils;

import ru.xpoft.vaadin.DiscoveryNavigator;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractUI extends UI implements ViewChangeListener {

	private static final long serialVersionUID = 9170972564399365378L;
	
	public static String AFTER_LOG_IN_PANEL_NAME = "";
	
	private VerticalLayout topPanel;
	private VerticalLayout mainPanel;
	private VerticalLayout bottomPanel;
	private VerticalLayout content;

	@Override
	protected void init(VaadinRequest request) {
		content = new VerticalLayout();
		Panel panel = new Panel();
		panel.setSizeFull();
		panel.setStyleName(ValoTheme.PANEL_BORDERLESS);
		panel.setContent(content);
		setContent(panel);
		
		this.topPanel = buildTopPanel();
		if (this.topPanel != null) {
			content.addComponent(this.topPanel);
		}
		
		this.mainPanel = buildMainPanel();
		DiscoveryNavigator navigator;
		if (this.mainPanel != null) {
			this.mainPanel.setSizeFull();
			content.addComponent(this.mainPanel);
			content.setExpandRatio(this.mainPanel, 1);
			navigator = new DiscoveryNavigator(this, this.mainPanel);
		} else {
			navigator = new DiscoveryNavigator(this, this);
		}
		
		this.bottomPanel = buildBottomPanel();
		if (this.bottomPanel != null) {
			content.addComponent(this.bottomPanel);
		}
		
		navigator.addViewChangeListener(this);
		setAfterLogInPanelName();
	}
	
	public boolean beforeViewChange(ViewChangeEvent event) {
		if (StringUtils.isEmpty(event.getViewName())) {
			if (this.topPanel != null) {
				this.topPanel.setVisible(false);
			}
			if (this.bottomPanel != null) {
				this.bottomPanel.setVisible(false);
			}
			content.setHeight(100, Unit.PERCENTAGE);
			if (isLogIn()) {
				Page.getCurrent().setUriFragment("!" + AFTER_LOG_IN_PANEL_NAME);
				return false;
			}
		} else {
			if (this.topPanel != null) {
				this.topPanel.setVisible(true);
			}
			if (this.bottomPanel != null) {
				this.bottomPanel.setVisible(true);
			}
			content.setHeightUndefined();
			if (!isLogIn()) {
				Page.getCurrent().setUriFragment("!");
				return false;
			}
		}
		return true;
	}

	public void afterViewChange(ViewChangeEvent event) {
	}
	
	protected abstract VerticalLayout buildTopPanel();
	
	protected abstract VerticalLayout buildMainPanel();
	
	protected abstract VerticalLayout buildBottomPanel();
	
	protected abstract boolean isLogIn();
	
	protected abstract void setAfterLogInPanelName();

}
