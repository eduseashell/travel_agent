package edu.kwon.travelagent.fe.gui.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

import edu.kwon.travelagent.fe.gui.layout.AbstractCrudTabSheetLayout;
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
public class UserTabSheet extends AbstractCrudTabSheetLayout {

	private static final long serialVersionUID = -5259413296535848102L;
	
	public static final String VIEW_NAME = "views/user";
	
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
	protected void onRefreshMainLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initSelectedTab(Component selectedTab) {
		// TODO Auto-generated method stub
		
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
	protected Long getSelectedItemId() {
		return mainLayout.getSelectedItemId();
	}

}
