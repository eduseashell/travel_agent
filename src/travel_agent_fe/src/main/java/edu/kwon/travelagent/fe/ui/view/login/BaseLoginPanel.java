package edu.kwon.travelagent.fe.ui.view.login;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.travelagent.core.ui.login.AbstractLoginView;
import edu.kwon.travelagent.core.vaadin.themes.VaadinTheme;

/**
 * Base Login Panel
 * @author Bunlong Taing
 * @since 0.0.1
 * @version 0.0.1
 */
public class BaseLoginPanel extends AbstractLoginView {

	/** */
	private static final long serialVersionUID = -6452066036379454674L;

	/**
	 * @see edu.kwon.travelagent.core.ui.login.AbstractLoginView#buildLoginForm()
	 */
	@Override
	protected Component buildLoginForm() {
		final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName(VaadinTheme.LOGIN_PANEL);

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        return loginPanel;
	}
	
	private Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName(VaadinTheme.LOGIN_FIELDS);

        final TextField username = VaadinFactory.getTextField("user.name");
        username.setIcon(FontAwesome.USER);
        username.focus();

        final PasswordField password = VaadinFactory.getPasswordField("password");
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button signin = VaadinFactory.getButtonPrimary("sign.in");
        signin.setClickShortcut(KeyCode.ENTER);

        fields.addComponents(username, password, signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

        signin.addClickListener(new ClickListener() {
			private static final long serialVersionUID = -1719928773666434856L;
			public void buttonClick(ClickEvent event) {
				signIn(username.getValue(), password.getValue());
			}
        });
        return fields;
    }

    private Component buildLabels() {
        CssLayout labels = new CssLayout();
        labels.addStyleName(VaadinTheme.LOGIN_LABELS);

        Label welcome = VaadinFactory.getLabel("log.in.welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = VaadinFactory.getLabel("app.name");
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);
        return labels;
    }

	@Override
	protected void signIn(String user, String password) {
		
	}

}
