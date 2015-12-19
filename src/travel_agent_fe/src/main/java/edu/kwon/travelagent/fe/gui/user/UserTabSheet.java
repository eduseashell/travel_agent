package edu.kwon.travelagent.fe.gui.user;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractTabSheetLayout;

/**
 * User Tab Sheet
 * @author eduseashell
 *
 */
@org.springframework.stereotype.Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@VaadinView(UserTabSheet.VIEW_NAME)
public class UserTabSheet extends AbstractTabSheetLayout {

	private static final long serialVersionUID = -5259413296535848102L;
	
	public static final String VIEW_NAME = "user.views";

	@Override
	protected AbstractComponentContainer buildTableLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onNewActionClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onEditActionClicked(Long entityId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDeleteActionClicked(Long entityId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onRefreshMainLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initSelectedTab(Component selectedTab) {
		// TODO Auto-generated method stub
		
	}

}
