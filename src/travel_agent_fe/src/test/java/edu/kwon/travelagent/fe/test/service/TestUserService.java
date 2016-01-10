package edu.kwon.travelagent.fe.test.service;

import edu.kwon.frmk.common.data.jpa.repository.user.User;
import edu.kwon.frmk.common.data.jpa.repository.user.UserService;
import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.travelagent.fe.test.BaseTest;

public class TestUserService extends BaseTest {
	
	public TestUserService() {
		
		User user = new User();
		user.setUserName("Super Admin - TEST");
		user.setPassword("Password");
		
		UserService service = AppContext.getBean(UserService.class);
		service.save(user);
	}

}
