package edu.kwon.travelagent.fe.gui.user.list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.data.Item;
import com.vaadin.server.FontAwesome;

import edu.kwon.frmk.common.data.jpa.repository.entities.audit.AuditEntityService;
import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.data.jpa.repository.user.UserService;
import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.component.table.Column;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractMainLayout;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractSearchPanel;
import edu.kwon.frmk.vaadin.util.helper.StringHelper;

/**
 * @author eduseashell
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserMainLayout extends AbstractMainLayout<User> {

	private static final long serialVersionUID = 4807136632997528711L;
	
	private UserService userService = AppContext.getBean(UserService.class);
	
	@Autowired
	private UserSearchPanel searchPanel;
	
	@Override
	protected void init() {
		super.init();
		setCaption(I18N.string("users"));
		setIcon(FontAwesome.USERS);
	}

	@Override
	protected List<Column> buildTableColumn() {
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column(User.ID, I18N.string("id"), Long.class, 70));
		columns.add(new Column(User.FIRST_NAME, I18N.string("first.name"), String.class, 150));
		columns.add(new Column(User.LAST_NAME, I18N.string("last.name"), String.class, 150));
		columns.add(new Column(User.USER_NAME, I18N.string("user.name"), String.class, 150));
		columns.add(new Column(User.PHONE_1, I18N.string("primary.phone"), String.class, 110));
		columns.add(new Column(User.E_MAIL, I18N.string("e.mail"), String.class, 250));
		columns.add(new Column(User.ACTIVE, I18N.string("active"), String.class, 70));
		return columns;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void renderRow(Item item, User user) {
		item.getItemProperty(User.ID).setValue(user.getId());
		item.getItemProperty(User.FIRST_NAME).setValue(user.getFirstName());
		item.getItemProperty(User.LAST_NAME).setValue(user.getLastName());
		item.getItemProperty(User.USER_NAME).setValue(user.getUserName());
		item.getItemProperty(User.PHONE_1).setValue(user.getPhone1());
		item.getItemProperty(User.E_MAIL).setValue(user.getEmail());
		item.getItemProperty(User.ACTIVE).setValue(StringHelper.toActiveMsg(user.getActive()));
	}
	
	@Override
	protected AbstractSearchPanel<User> onCreateSearchPanel() {
		return searchPanel;
	}

	@Override
	protected AuditEntityService<User> getService() {
		return userService;
	}

}
