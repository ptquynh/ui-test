package com.tekexperts.selenium.smoke;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

public class Smoke_BusinessManagement extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1739
	 * Test case name: Check Business Management
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Executive Dashboard] link
	 * Test Step 4: Click on [KPIs Dashboard]link
	 * Test Step 5: Click on [ABCD] link
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Executive dashboard page is shown
	 * 4. KPIs dashboard page is shown
	 * 5. ABCD page is shown
	 */
	@Test
	public void VAN1739_CheckBusinessManagement(){
		info("Go to Executive Dashboard page");
		navMenu.goToExecutiveDashboard();
		info("Verify that Executive Dashboard page is shown");
		exeDashboard.verifyPageTitle();
		info("Go to KPIs Dashboard");
		info("Go to ABCD");
		navMenu.goToABCD();
		info("Verify that ABCD page is shown");
		abcd.verifyPageTitle();
	}
}
