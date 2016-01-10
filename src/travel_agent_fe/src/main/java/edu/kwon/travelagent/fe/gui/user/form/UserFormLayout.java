package edu.kwon.travelagent.fe.gui.user.form;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.data.jpa.repository.user.UserService;
import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractFormLayout;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserFormLayout extends AbstractFormLayout<User> {

	private static final long serialVersionUID = -6588699059614697221L;
	
	private UserService userService = AppContext.getBean(UserService.class);
	
	private TextField txtFirstName;
	private TextField txtMiddleName;
	private TextField txtLastName;
	private TextField txtNickName;
	private TextField txtTitle;
	
	private TextField txtPhone1;
	private TextField txtPhone2;
	private TextField txtEMail;
	private TextField txtBirthPlace;
	private DateField dfBirthDate;
	
	private TextField txtUserName;
	private PasswordField txtPassword;
	
	@Override
	protected void init() {
		super.init();
		setCaption(I18N.string("user"));
	}
	
	private void initControls() {
		txtFirstName = VaadinFactory.getTextField("first.name", 180, true);
		txtMiddleName = VaadinFactory.getTextField("middle.name", 180);
		txtLastName = VaadinFactory.getTextField("last.name", 180, true);
		txtNickName = VaadinFactory.getTextField("nick.name", 180);
		txtTitle = VaadinFactory.getTextField("title", 180);
		
		txtPhone1 = VaadinFactory.getTextField("primary.phone", 180);
		txtPhone2 = VaadinFactory.getTextField("secondary.name", 180);
		txtEMail = VaadinFactory.getTextField("e.mail", 180);
		txtBirthPlace = VaadinFactory.getTextField("birth.place", 180, true);
		dfBirthDate = VaadinFactory.getDateField("birth.date");
		
		txtUserName = VaadinFactory.getTextField("user.name", 200, true);
		txtPassword = VaadinFactory.getPasswordField("password", 200, true);
	}

	@Override
	protected AbstractComponentContainer initGUI() {
		initControls();
		Panel panel = createGeneralAccountSettingsPanel();
		
		FormLayout form = new FormLayout();
		form.addComponent(txtUserName);
		form.addComponent(txtPassword);
		return form;
	}
	
	private Panel createGeneralAccountSettingsPanel() {
		Panel panel = VaadinFactory.getPanel("general.account.settings");
		
		HorizontalLayout content = new HorizontalLayout();
		content.setMargin(true);
		content.setSpacing(true);
		
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(txtTitle);
		formLayout.addComponent(txtFirstName);
		formLayout.addComponent(txtMiddleName);
		formLayout.addComponent(txtLastName);
		formLayout.addComponent(txtNickName);
		formLayout.addComponent(txtUserName);
		formLayout.addComponent(txtPassword);
		content.addComponent(formLayout);
		
		formLayout = new FormLayout();
		formLayout.addComponent(txtBirthPlace);
		formLayout.addComponent(dfBirthDate);
		formLayout.addComponent(txtPhone1);
		formLayout.addComponent(txtPhone2);
		formLayout.addComponent(txtEMail);
		
		return panel;
	}

	@Override
	public void assignValues(Long entityId) {
		reset();
		if (entityId != null) {
			entity = userService.findById(entityId);
			fillDataToControls();
		}
	}

	@Override
	protected boolean validate() {
		return true;
	}

	@Override
	protected void fillDataToControls() {
		txtUserName.setValue(entity.getUserName());
		txtPassword.setValue(entity.getPassword());
	}

	@Override
	protected void fillDataToEntity() {
		if (entity == null) {
			entity = new User();
		}
		entity.setUserName(txtUserName.getValue());
		entity.setPassword(txtPassword.getValue());
	}
	
	@Override
	public void reset() {
		super.reset();
		txtUserName.setValue("");
		txtPassword.setValue("");
	}

	@Override
	protected UserService getService() {
		return userService;
	}

}
