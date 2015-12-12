package edu.kwon.travelagent.fe.ui.view.dashboard;

import java.util.Date;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Panel;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.travelagent.core.ui.layout.AbstractLayout;

/**
 * Dashboard Panel
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@VaadinView(DashboardPanel.NAME)
public class DashboardPanel extends AbstractLayout {

	private static final long serialVersionUID = 6139998643434014631L;
	public static final String NAME = "fe.dashboard";
	
	public DashboardPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		InlineDateField dateField = new InlineDateField();
		dateField.setValue(new Date());
		dateField.setEnabled(false);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		horizontalLayout.addComponent(buildInfoLayout());
		horizontalLayout.addComponent(dateField);
		addComponent(horizontalLayout);
		setComponentAlignment(horizontalLayout, Alignment.TOP_CENTER);
		
		horizontalLayout = buildButtonLayout();
		addComponent(horizontalLayout);
		setComponentAlignment(horizontalLayout, Alignment.TOP_CENTER);
		
		horizontalLayout = buildButtonLayout();
		addComponent(horizontalLayout);
		setComponentAlignment(horizontalLayout, Alignment.TOP_CENTER);
	}
	
	private Panel buildInfoLayout() {
		Panel infoPanel = new Panel();
		infoPanel.setCaption("Information Panel");
		
		return infoPanel;
	}
	
	private HorizontalLayout buildButtonLayout() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(true);
		horizontalLayout.setSpacing(true);
		
		horizontalLayout.addComponent(getButton("images/sample/user.png"));
		horizontalLayout.addComponent(getButton("images/sample/user.png"));
		horizontalLayout.addComponent(getButton("images/sample/logout.png"));
		horizontalLayout.addComponent(getButton("images/sample/logout.png"));
		
		return horizontalLayout;
	}
	
	private Button getButton(String image) {
		Button btn = VaadinFactory.getButton(null, image);
		btn.setWidth(160, Unit.PIXELS);
		btn.setHeight(160, Unit.PIXELS);
		return btn;
	}

}
