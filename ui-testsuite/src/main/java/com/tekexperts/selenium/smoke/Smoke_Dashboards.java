package com.tekexperts.selenium.smoke;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

public class Smoke_Dashboards extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1740
	 * Test case name:Check Pipeline Dashboard
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Dashboard] link
	 * Test Step 4: Click on [Pipeline]button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Dashboard home page is shown
	 * 4. Pipeline page is shown
	 */
	@Test
	public void VAN1740_CheckBusinessManagement(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Pipeline page");
		dashHome.goToPipelineDashboard();
		info("Verify that Pipeline page is shown");
	    pipeDash.verifyPageTitle();
	}
	
	/**
	 * Test case ID: VAN-1741
	 * Test case name:Check Summary Dashboard
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Dashboard] link
	 * Test Step 4: Click on [Summary]button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Dashboard home page is shown
	 * 4. Summary page is shown
	 */
	@Test
	public void VAN1741_CheckSummaryDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Summary page");
		dashHome.goToSummaryDashboard();
		info("Verify that Summary page is shown");
	    sumDash.verifyPageTitle();
	}
	
	/**
	 * Test case ID: VAN-1742
	 * Test case name:Check Lost Dashboard
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Dashboard] link
	 * Test Step 4: Click on [Lost]button
	 * Test Step 5: Click on [Business Unit] tab
	 * Test Step 6: Click on [Product Line] tab
	 * Test Step 7: Click on [Lost by Reason] tab
	 * Test Step 8: Click on [Renewal Type] tab
	 * Test Step 9: Click on [Chanel or Direct] tab
	 * Test Step 10: Click on [Duration] tab
	 * Test Step 11: Click on [Deal Size] tab
	 * Test Step 12: Click on [Deal Summary] tab
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Dashboard Home page is shown
	 * 4=>12. Lost page is shown with correct tab's content
	 */
	@Test
	public void VAN1742_00_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
		info("Verify that Lost page is shown");
	    lostBU.verifyPageTitle();
	}
	
	@Test
	public void VAN1742_01_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Reason page is shown");
	    lostReason.verifyDashboard();
	}
	
	@Test
	public void VAN1742_02_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Channel page is shown");
	    lostChannel.verifyDashboard();
	}
	
	@Test
	public void VAN1742_03_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Deal Size page is shown");
	    lostSize.verifyDashboard();
	}
	
	@Test
	public void VAN1742_04_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Deal Summary page is shown");
	    lostSummary.verifyDashboard();
	}
	
	@Test
	public void VAN1742_05_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Duration page is shown");
	    lostDuration.verifyDashboard();
	}
	
	@Test
	public void VAN1742_06_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Product line page is shown");
	    lostPL.verifyDashboard();
	}
	
	@Test
	public void VAN1742_07_CheckLostDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Lost page");
		dashHome.goToLostDashboard();
	    info("Verify that Lost by Renewal Type page is shown");
	    lostRenewal.verifyDashboard();
	}
	/**
	 * Test case ID: VAN-1743
	 * Test case name:Check Renewal Dashboard
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Dashboard] link
	 * Test Step 4: Click on [Renewal Rate]button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Dashboard Home page is shown
	 * 4. Renewal rate page is shown
	 */
	@Test
	public void VAN1743_CheckRenewalDashboard(){
		info("Go to Dashboard page");
		navMenu.goToDashboard();
		info("Go to Renewal Rate page");
		dashHome.goToRenewalRate();
		info("Verify that Renewal Rate page is shown");
	    renewalDash.verifyPageTitle();
	}
}
