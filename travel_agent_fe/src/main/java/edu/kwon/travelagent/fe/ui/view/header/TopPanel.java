package edu.kwon.travelagent.fe.ui.view.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.frmk.common.share.spring.util.AppConfig;
import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.travelagent.core.config.PropertiesParam;
import edu.kwon.travelagent.core.vaadin.themes.VaadinTheme;

/**
 * The page Top panel which contains header infomation
 * like logo, user, and menus
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TopPanel extends VerticalLayout {

	private static final long serialVersionUID = -6431393804362388676L;
	
	private Image imgLogo;
	
	@Autowired
	private TAFEMenu menu;
	
	public TopPanel() {
		super();
		addStyleName(VaadinTheme.LAYOUT_BACKGROUND_WHITE);
		setSpacing(false);
	}
	
	/**
	 * Post Contruct
	 */
	public void PostContruct() {
		initGUI();
	}
	
	/**
	 * Init GUI component of top panel
	 */
	private void initGUI() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(true);
		horizontalLayout.addComponent(buildBrand());
		horizontalLayout.addComponent(menu);
		horizontalLayout.setComponentAlignment(menu, Alignment.MIDDLE_LEFT);
		
		addComponent(horizontalLayout);
	}
	
	private ComponentContainer buildBrand() {
		imgLogo = VaadinFactory.getImage(AppConfig.getConfigValue(PropertiesParam.APP_LOGO), "Company Logo");
		imgLogo.setHeight(45, Unit.PIXELS);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		horizontalLayout.addComponent(imgLogo);
		
		return horizontalLayout;
	}

}
