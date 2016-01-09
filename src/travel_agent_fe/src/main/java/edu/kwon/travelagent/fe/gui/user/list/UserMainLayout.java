package edu.kwon.travelagent.fe.gui.user.list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.data.Item;
import com.vaadin.ui.Table.Align;

import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.frmk.vaadin.component.select.Column;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractMainLayout;
import edu.kwon.frmk.vaadin.gui.layout.crud.AbstractSearchPanel;

/**
 * @author eduseashell
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserMainLayout extends AbstractMainLayout<User> {

	private static final long serialVersionUID = 4807136632997528711L;
	
	@Autowired
	private UserSearchPanel searchPanel;
	
	@Override
	protected void init() {
		// TODO to remove, test only
		super.init();
		setCaption(I18N.string("users"));
//		renderTableRows();
	}

	@Override
	public void onTableDoubleClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<Column> buildTableColumn() {
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("id", "Id", Integer.class, Align.RIGHT, 100));
		columns.add(new Column("name", "Supplier Name", String.class, Align.LEFT, 100));
		return columns;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void renderRow(Item item, User row) {
		item.getItemProperty("id").setValue(1);
		item.getItemProperty("name").setValue("TEST");
	}
	
	@Override
	protected AbstractSearchPanel onCreateSearchPanel() {
		return searchPanel;
	}

	

}
