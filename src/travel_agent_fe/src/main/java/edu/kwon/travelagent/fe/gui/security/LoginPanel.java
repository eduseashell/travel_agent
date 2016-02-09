package edu.kwon.travelagent.fe.gui.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import edu.kwon.frmk.common.data.jpa.repository.security.auth.AuthenticationService;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.component.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.login.DefaultLoginPanel;
import edu.kwon.frmk.vaadin.util.helper.VaadinHelper;
import edu.kwon.travelagent.fe.gui.MainUI;

/**
 * Login Panel
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
@Component
@Scope("prototype")
@VaadinView(LoginPanel.VIEW_NAME)
public class LoginPanel extends DefaultLoginPanel {
	
	private static final long serialVersionUID = 6901879027592109979L;
	public static final String VIEW_NAME = "login";

	@Autowired
	private AuthenticationService authService;

	/**
	 * @see edu.kwon.travelagent.fe.ui.view.login.BaseLoginPanel#signIn(java.lang.String, java.lang.String)
	 */
	@Override
	protected void signIn(String username, String password) {
		try {
			authService.authenticate(username, password);
			VaadinHelper.setUriFragment(MainUI.WELCOME_PANEL_NAME);
		} catch (UsernameNotFoundException | BadCredentialsException e) {
			String caption = I18N.string("login");
			String desc = I18N.string("user.name.pwd.incorrect");
			Notification noti = VaadinFactory.getNotification(caption, desc, Type.ERROR_MESSAGE);
			noti.setStyleName("tray dark small closable login-help");
			noti.setPosition(Position.BOTTOM_CENTER);
			noti.setIcon(FontAwesome.EXCLAMATION);
			noti.show(Page.getCurrent());
		}
		// TODO catch other exception, expired etc...
	}

}
