package edu.kwon.travelagent.fe.ui.view.header;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.travelagent.core.vaadin.themes.VaadinTheme;

/**
 * The page Top panel which contains header infomation
 * like logo, user, and menus
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
public class TopPanel extends VerticalLayout {

	private static final long serialVersionUID = -6431393804362388676L;
	
	private Image imgLogo;
	
	public TopPanel() {
		super();
		addStyleName(VaadinTheme.LAYOUT_BACKGROUND_WHITE);
		setSpacing(false);
		initGUI();
	}
	
	/**
	 * Init GUI component of top panel
	 */
	private void initGUI() {
		imgLogo = new Image(null, new ThemeResource("images/logo.jpg"));
		imgLogo.setHeight(45, Unit.PIXELS);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(true);
		horizontalLayout.addComponent(imgLogo);
		
		addComponent(horizontalLayout);
		addComponent(new TAFEMenu());
	}

}
