package edu.kwon.travelagent.fe.gui.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.ui.AbstractComponentContainer;

import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.data.jpa.repository.user.UserService;
import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractTabSheetLayout;
import edu.kwon.travelagent.fe.gui.user.form.UserFormLayout;
import edu.kwon.travelagent.fe.gui.user.list.UserMainLayout;

/**
 * User Tab Sheet
 * @author eduseashell
 *
 */
@org.springframework.stereotype.Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@VaadinView(UserTabSheet.VIEW_NAME)
public class UserTabSheet extends AbstractTabSheetLayout<User> {

	private static final long serialVersionUID = -5259413296535848102L;
	
	public static final String VIEW_NAME = "views/user";
	
	private UserService userService = AppContext.getBean(UserService.class);
	@Autowired
	private UserMainLayout mainLayout;
	@Autowired
	private UserFormLayout formLayout;

	@Override
	public void postConstruct() {
		super.postConstruct();
		formLayout.setMainTabSheet(this);
	}
	
	@Override
	protected AbstractComponentContainer buildMainLayout() {
		mainLayout.setCrudListener(this);
		return mainLayout;
	}

	@Override
	public void onNewActionClicked() {
		formLayout.reset();
		addFormLayout(formLayout);
	}

	@Override
	protected void onEditItem(Long id) {
		formLayout.assignValues(id);
		addFormLayout(formLayout);
	}
	
	@Override
	protected void onRefreshMainLayout() {
		mainLayout.refresh();
	}

	@Override
	protected Long getSelectedItemId() {
		return mainLayout.getSelectedItemId();
	}

	@Override
	protected UserService getService() {
		return userService;
	}

}
