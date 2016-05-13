package com.tekexperts.selenium.smoke;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

public class Smoke_HistoricalData extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1748
	 * Test case name:Check Historical Data
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Historical Data] link
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Historical Data home page is shown
	 */
	@Test
	public void VAN1748_CheckHistoricalData(){
		info("Go to Dashboard page");
		navMenu.goToHistoricalData();
		info("Verify that the page is shown");
		hisData.verifyPageTitle();
	}
}
