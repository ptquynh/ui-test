package com.tekexperts.selenium.func.others;
import org.testng.annotations.Test;
import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_NavigationBar extends TestConfig{
	/**
	* Test case ID:VAN-1413
	* Test case name:"Check expanding/collapsing left menu"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Check left menu's status"
	* Expected Result:"The left menu is expanded by default"
	* Test Step 4:"Click on [Expand/Collapse] button on navigation bar"
	* Expected Result:"The menu is collapsed"
	* Test Step 5:"Click on [Expand/Collapse] button again"
	* Expected Result:"The menu is expanded"
	*/
	@Test
	public void VAN1413_CheckExpandingcollapsingLeftMenu(){
		info("Verify that the left menu is expanded");
		waitForAndGetElement(navMenu.ELEMENT_LEFT_MENU_EXPAND_STATUS,2000,1);
		info("Click on Expand/Collapse button");
		navMenu.expandCollapseMenu();
		info("Verify that the left menu is collapsed");
		waitForAndGetElement(navMenu.ELEMENT_LEFT_MENU_COLLAPSE_STATUS,2000,1);
		info("Click on Expand/Collapse button again");
		navMenu.expandCollapseMenu();
		info("Verify that the left menu is expanded again");
		waitForAndGetElement(navMenu.ELEMENT_LEFT_MENU_EXPAND_STATUS,2000,1);
	}
}