package edu.kwon.travelagent.fe.gui.user.form;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.data.jpa.repository.user.UserService;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.common.share.util.DateUtil;
import edu.kwon.frmk.common.share.util.NumberUtil;
import edu.kwon.frmk.vaadin.component.factory.VaadinFactory;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractFormLayout;
import edu.kwon.frmk.vaadin.util.Validator;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserFormLayout extends AbstractFormLayout<User> {

	private static final long serialVersionUID = -6588699059614697221L;
	
	@Autowired
	private UserService userService;
	
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
	private PasswordField txtConfirmPwd;
	
	private DateField dfLastPwdModified;
	private DateField dfLastLogIn;
	private DateField dfLastLogOut;
	private TextField txtMaxTimePwdChange;
	private TextField txtMaxAttemptLogInAllow;
	private CheckBox cbDefaultPwd;
	private CheckBox cbNeedPwdChange;
	private CheckBox cbLocked;
	private CheckBox cbActive;
	
	@Override
	protected void init() {
		super.init();
		setCaption(I18N.string("user"));
		setIcon(FontAwesome.USER);
	}
	
	@Override
	protected AbstractComponentContainer initGUI() {
		initControls();
		
		Panel personalInfoPanel = createPersonalInfoPanel();
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		horizontalLayout.setWidth(100, Unit.PERCENTAGE);
		horizontalLayout.addComponent(createGeneralAccountSettingsPanel());
		horizontalLayout.addComponent(personalInfoPanel);
		horizontalLayout.setExpandRatio(personalInfoPanel, 1);
		
		VerticalLayout content = new VerticalLayout();
		content.setSpacing(true);
		content.addComponent(horizontalLayout);
		content.addComponent(createAccountInfoPanel());
		content.addComponent(createContactInfoPanel());
		
		return content;
	}
	
	private void initControls() {
		txtFirstName = VaadinFactory.getTextField("first.name", true);
		txtMiddleName = VaadinFactory.getTextField("middle.name");
		txtLastName = VaadinFactory.getTextField("last.name", true);
		txtNickName = VaadinFactory.getTextField("nick.name");
		txtTitle = VaadinFactory.getTextField("title");
		
		txtPhone1 = VaadinFactory.getTextField("primary.phone");
		txtPhone2 = VaadinFactory.getTextField("secondary.name");
		txtEMail = VaadinFactory.getTextField("e.mail");
		txtBirthPlace = VaadinFactory.getTextField("place.of.birth");
		dfBirthDate = VaadinFactory.getDateField("date.of.birth", true);
		
		txtUserName = VaadinFactory.getTextField("user.name", true);
		txtPassword = VaadinFactory.getPasswordField("password", true);
		txtConfirmPwd = VaadinFactory.getPasswordField("confirm.password", true);
		
		dfLastPwdModified = VaadinFactory.getDateField("last.pwd.modified.date");
		dfLastLogIn = VaadinFactory.getDateField("last.log.in.date");
		dfLastLogOut = VaadinFactory.getDateField("last.log.out.date");
		txtMaxTimePwdChange = VaadinFactory.getTextField("max.time.to.change.pwd");
		txtMaxAttemptLogInAllow = VaadinFactory.getTextField("max.attempt.log.in.allow");
		cbDefaultPwd = VaadinFactory.getCheckBox("default.pwd");
		cbNeedPwdChange = VaadinFactory.getCheckBox("need.pwd.change");
		cbLocked = VaadinFactory.getCheckBox("locked");
		cbActive = VaadinFactory.getCheckBox("active");
	}
	
	private Panel createGeneralAccountSettingsPanel() {
		HorizontalLayout content = new HorizontalLayout();
		content.setSpacing(true);
		content.setMargin(true);
		
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(txtUserName);
		formLayout.addComponent(txtPassword);
		formLayout.addComponent(txtConfirmPwd);
		formLayout.addComponent(cbActive);
		content.addComponent(formLayout);
		
		Panel panel = VaadinFactory.getPanel("general.account.settings");
		panel.setContent(content);
		panel.setWidth(450, Unit.PIXELS);
		
		return panel;
	}
	
	private Panel createAccountInfoPanel() {
		HorizontalLayout content = new HorizontalLayout();
		content.setSpacing(true);
		content.setMargin(true);
		
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(dfLastLogIn);
		formLayout.addComponent(dfLastLogOut);
		formLayout.addComponent(dfLastPwdModified);
		content.addComponent(formLayout);
		
		formLayout = new FormLayout();
		formLayout.addComponent(txtMaxTimePwdChange);
		formLayout.addComponent(txtMaxAttemptLogInAllow);
		content.addComponent(formLayout);
		
		formLayout = new FormLayout();
		formLayout.addComponent(cbDefaultPwd);
		formLayout.addComponent(cbNeedPwdChange);
		formLayout.addComponent(cbLocked);
		content.addComponent(formLayout);
		
		Panel panel = VaadinFactory.getPanel("account.info");
		panel.setContent(content);
		
		return panel;
	}
	
	private Panel createPersonalInfoPanel() {
		HorizontalLayout content = new HorizontalLayout();
		content.setSpacing(true);
		content.setMargin(true);
		
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(txtTitle);
		formLayout.addComponent(txtFirstName);
		formLayout.addComponent(txtMiddleName);
		formLayout.addComponent(txtLastName);
		content.addComponent(formLayout);
		
		formLayout = new FormLayout();
		formLayout.addComponent(txtNickName);
		formLayout.addComponent(txtBirthPlace);
		formLayout.addComponent(dfBirthDate);
		content.addComponent(formLayout);
		
		Panel panel = VaadinFactory.getPanel("personal.info");
		panel.setContent(content);
		
		return panel;
	}
	
	private Panel createContactInfoPanel() {
		HorizontalLayout content = new HorizontalLayout();
		content.setSpacing(true);
		content.setMargin(true);
		
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(txtPhone1);
		formLayout.addComponent(txtPhone2);
		formLayout.addComponent(txtEMail);
		content.addComponent(formLayout);
		
		Panel panel = VaadinFactory.getPanel("contact.info");
		panel.setContent(content);
		
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
	protected void fillDataToControls() {
		txtFirstName.setValue(entity.getFirstName());
		txtMiddleName.setValue(entity.getMiddleName());
		txtLastName.setValue(entity.getLastName());
		txtNickName.setValue(entity.getNickName());
		txtTitle.setValue(entity.getTitle());
		txtPhone1.setValue(entity.getPhone1());
		txtPhone2.setValue(entity.getPhone2());
		txtEMail.setValue(entity.getEmail());
		txtBirthPlace.setValue(entity.getBirthPlace());
		dfBirthDate.setValue(entity.getBirthDate());
		txtUserName.setValue(entity.getUserName());
		
		dfLastPwdModified.setValue(entity.getLastPwdModifiedDate());
		dfLastLogIn.setValue(entity.getLastLogInDate());
		dfLastLogOut.setValue(entity.getLastLogOutDate());
		txtMaxTimePwdChange.setValue(NumberUtil.toString(entity.getMaxTimePwdChange()));
		txtMaxAttemptLogInAllow.setValue(NumberUtil.toString(entity.getMaxAttemptLogInAllow()));
		cbDefaultPwd.setValue(entity.getDefaultPwd());
		cbNeedPwdChange.setValue(entity.getNeedPwdChange());
		cbLocked.setValue(entity.getLocked());
		cbActive.setValue(entity.getActive());
	}

	@Override
	protected void fillDataToEntity() {
		if (entity == null) {
			entity = new User();
		}
		entity.setFirstName(txtFirstName.getValue());
		entity.setMiddleName(txtMiddleName.getValue());
		entity.setLastName(txtLastName.getValue());
		entity.setNickName(txtNickName.getValue());
		entity.setTitle(txtTitle.getValue());
		entity.setPhone1(txtPhone1.getValue());
		entity.setPhone2(txtPhone2.getValue());
		entity.setEmail(txtEMail.getValue());
		entity.setBirthPlace(txtBirthPlace.getValue());
		entity.setBirthDate(dfBirthDate.getValue());
		entity.setUserName(txtUserName.getValue());
		if (StringUtils.isNotBlank(txtPassword.getValue())) {
			entity.setPassword(txtPassword.getValue());
		}
	}
	
	@Override
	protected boolean validate() {
		boolean valid = true;
		String msgPwdNotMatch = I18N.string("password.not.match");
		String msgInvalidBD = I18N.string("user.age.limit");
		Date minBirthDate = DateUtil.addYear(DateUtil.now(), -18);
		
		valid &= Validator.validateRequiredTextField(txtFirstName);
		valid &= Validator.validateRequiredTextField(txtLastName);
		valid &= Validator.validateRequiredTextField(txtUserName);
		valid &= Validator.validateRequiredDateField(dfBirthDate) &&
				 Validator.validateDateFieldBefore(dfBirthDate, minBirthDate, msgInvalidBD);
		valid &= Validator.validateEMailTextField(txtEMail);
		
		// Validate pwd only the password field is not blank
		if (StringUtils.isNotBlank(txtPassword.getValue())) {
			valid &= Validator.validateMinStringLength(txtPassword, 8);
			valid &= Validator.validateRequiredTextField(txtConfirmPwd) &&
					 Validator.validateMinStringLength(txtConfirmPwd, 8) &&
					 Validator.validateEqualString(txtPassword, txtConfirmPwd, msgPwdNotMatch);
		}
		return valid;
	}
	
	@Override
	public void reset() {
		super.reset();
		txtFirstName.setValue(null);
		txtMiddleName.setValue(null);
		txtLastName.setValue(null);
		txtNickName.setValue(null);
		txtTitle.setValue(null);
		txtPhone1.setValue(null);
		txtPhone2.setValue(null);
		txtEMail.setValue(null);
		txtBirthPlace.setValue(null);
		dfBirthDate.setValue(null);
		txtUserName.setValue(null);
		txtPassword.setValue(null);
		txtConfirmPwd.setValue(null);
		
		dfLastPwdModified.setValue(null);
		dfLastLogIn.setValue(null);
		dfLastLogOut.setValue(null);
		txtMaxTimePwdChange.setValue(null);
		txtMaxAttemptLogInAllow.setValue(null);
		cbDefaultPwd.setValue(Boolean.FALSE);
		cbNeedPwdChange.setValue(Boolean.FALSE);
		cbLocked.setValue(Boolean.FALSE);
		cbActive.setValue(Boolean.FALSE);
	}

	@Override
	protected UserService getService() {
		return userService;
	}
	
	@Override
	protected void onSaveAction() {
		if (StringUtils.isNotBlank(txtPassword.getValue())) {
			// Save and encrypt password
			super.onSaveAction();
		} else {
			// Update with old password, no encrypted
			update();
		}
	}
	
	/**
	 * Update the user without changing the password
	 */
	private void update() {
		fillDataToEntity();
		if (entity == null) {
			throw new IllegalStateException("Entity cannot be null");
		} else if (StringUtils.isEmpty(entity.getPassword())) {
			throw new IllegalStateException("User password cannot be empty");
		}
		getService().update(entity);
		String caption = I18N.string("save");
		String desc = I18N.string("msg.success.save");
		VaadinFactory.getNotification(caption, desc)
			.show(Page.getCurrent());
	}

}
