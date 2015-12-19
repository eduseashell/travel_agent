package edu.kwon.travelagent.fe.gui.master.footer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.travelagent.core.vaadin.themes.TravelAgentTheme;
import edu.kwon.travelagent.fe.spring.config.util.FeAppConfig;

/**
 * Page footer
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class BottomPanel extends VerticalLayout {

	private static final long serialVersionUID = 4837434762355321889L;
	
	private Image imgLogo;
	private Label lblDesignAndBuild;
	private Label lblCopyRight;
	private Label lblVersion;
	
	public BottomPanel() {
		super();
		addStyleName(TravelAgentTheme.LAYOUT_BACKGROUND_WHITE);
		setSpacing(false);
		initGUI();
	}
	
	private void initGUI() {
		imgLogo = VaadinFactory.getImage(FeAppConfig.getAppLogo(), "app.com.logo.text");
		imgLogo.setHeight(45, Unit.PIXELS);
		
		lblDesignAndBuild = VaadinFactory.getLabel("designed.and.built");
		lblCopyRight = VaadinFactory.getLabel("copyright");
		lblCopyRight.setSizeUndefined();
		lblVersion = VaadinFactory.getLabel("version");
		lblVersion.setSizeUndefined();
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		horizontalLayout.addComponent(lblDesignAndBuild);
		horizontalLayout.setComponentAlignment(lblDesignAndBuild, Alignment.MIDDLE_CENTER);
		horizontalLayout.addComponent(imgLogo);
		
		addComponent(horizontalLayout);
		addComponent(lblCopyRight);
		addComponent(lblVersion);
		addStyleName(TravelAgentTheme.LAYOUT_FOOTER);
		
		setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);
		setComponentAlignment(lblCopyRight, Alignment.MIDDLE_CENTER);
		setComponentAlignment(lblVersion, Alignment.MIDDLE_CENTER);
	}

}
