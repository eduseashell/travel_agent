package edu.kwon.travelagent.fe.gui.user.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.data.jpa.repository.user.UserService;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractFormLayout;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserFormLayout extends AbstractFormLayout<User> {

	private static final long serialVersionUID = -6588699059614697221L;
	
	@Autowired
	private UserService userService;
	
	private TextField txtUserName;
	private PasswordField txtPassword;
	
	@Override
	protected void init() {
		super.init();
		setCaption(I18N.string("user"));
	}

	@Override
	protected AbstractComponentContainer initGUI() {
		txtUserName = VaadinFactory.getTextField("user.name", 200, true);
		txtPassword = VaadinFactory.getPasswordField("password", 200, true);
		
		FormLayout form = new FormLayout();
		form.addComponent(txtUserName);
		form.addComponent(txtPassword);
		return form;
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

}
