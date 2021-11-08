package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

import com.controllers.LoginPageController;
import com.database.DatabaseHandler;
import com.foodtracker.views.LoginPageView;
import com.foodtracker.views.SignUpView;

class LoginPageControllerTest {
	
	private int userID = -1;

	@Test
	void testGetUserId() {
		String userName = "admin@food.com";
		String pwd = "test";
		assertEquals(6, DatabaseHandler.getInstance().validateUser(userName, pwd));
		
	}

	@Test
	void testLoginPageController() {
		//fail("Not yet implemented");
	}

	@Test
	void testActionPerformed() {
		LoginPageView testView = new LoginPageView();
		ActionEvent e  = new ActionEvent(testView, 0, null);
		e.setSource(testView.getBtnSignUp());
		LoginPageController testAction = new LoginPageController(testView);
		testAction.actionPerformed(e);
		assertEquals(false, testView.getFrame().isVisible());
		
		
	
	}

	@Test
	void testSetStarsVisible() {
		//fail("Not yet implemented");
	}

	@Test
	void testMakeEmptyField() {
		//fail("Not yet implemented");
	}

	@Test
	void testFocusGained() {
		//fail("Not yet implemented");
	}

	@Test
	void testSetUserFeild() {
		//fail("Not yet implemented");
	}

	@Test
	void testSetPasswordFeild() {
		//fail("Not yet implemented");
	}

	@Test
	void testFocusLost() {
		//fail("Not yet implemented");
	}

}
