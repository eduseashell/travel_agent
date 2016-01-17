package edu.kwon.travelagent.fe.gui.security;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.ui.UI;

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
@VaadinView(LoginPanel.NAME)
public class LoginPanel extends DefaultLoginPanel {
	
	private static final long serialVersionUID = 6901879027592109979L;
	public static final String NAME = "";

	/**
	 * @see edu.kwon.travelagent.fe.ui.view.login.BaseLoginPanel#signIn(java.lang.String, java.lang.String)
	 */
	@Override
	protected void signIn(String user, String password) {
		if (!StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)) {
			UI.getCurrent().getSession().setAttribute("isLogin", true);
			VaadinHelper.setUriFragment(MainUI.WELCOME_PANEL_NAME);
		}
		
//		String msg = "<span>Welcome " + user + " with password: " + password + " to the agency flight</span>";
//		Notification notification = new Notification("Welcome to Agency flight");
//        notification.setDescription(msg);
//        notification.setHtmlContentAllowed(true);
//        notification.setDelayMsec(3000);
//        notification.setStyleName("tray dark small closable login-help");
//        notification.setPosition(Position.BOTTOM_CENTER);
//        notification.show(Page.getCurrent());
	}

}
