package com.tekexperts.selenium.smoke;

import org.testng.annotations.Test;
import static com.tekexperts.pipeline.common.TestLogger.info;
public class Smoke_Organization extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1729
	 * Test case name: Create a new region
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Organization] link
	 * Test Step 4: Click on [Region]button
	 * Test Step 5: Click on [Add] button
	 * Test Step 6: Input all required fields
	 * Test Step 7: Click on [Save] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Organization page is shown
	 * 4. Region page is shown
	 * 5. Add region page is shown
	 * 6. All data is input
	 * 7. A new region is created with correct input data
	 */
	@Test
	public void VAN1729_CreateANewRegion(){
		info("Prepare input data");
		String name = "region"+getRandomNumber();
		String status ="Disabled";
		String level ="";
		String regionType="";
		String parent="";
		String description="";
		
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Go to Region page");
		orgHome.goToRegion();
		info("Go to Add region page");
		region.goToAddRegion();
		info("Add a new region");
		region.add(name, status, level, regionType, parent, description);
		region.verifyRegionInTheTable(name,false);
	}
	
	/**
	 * Test case ID: VAN-1730
	 * Test case name: Create a new RTM
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Organization] link
	 * Test Step 4: Click on [RTM]button
	 * Test Step 5: Click on [Add] button
	 * Test Step 6: Input all required fields
	 * Test Step 7: Click on [Save] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Organization page is shown
	 * 4. RTM page is shown
	 * 5. Add RTM page is shown
	 * 6. All data is input
	 * 7. A new RTM is created with correct input data
	 */
	@Test
	public void VAN1730_CreateANewRTM(){
		info("Prepare input data");
		String name = "rtm"+getRandomNumber();
		String state ="Disabled";
		String description="";
		
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Go to RTM page");
		orgHome.goToRTM();
		info("Go to Add RTM page");
		rtm.goToAddRTM();
		info("Add a new RTM");
		rtm.add(name, state,description);
		rtm.searchByStatus(false,false);
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
	}
	
	/**
	 * Test case ID: VAN-1731
	 * Test case name: Create a new Business Unit
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Organization] link
	 * Test Step 4: Click on [Business Unit]button
	 * Test Step 5: Click on [Add] button
	 * Test Step 6: Input all required fields
	 * Test Step 7: Click on [Save] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Organization page is shown
	 * 4. Business Unit page is shown
	 * 5. Add Business Unit page is shown
	 * 6. All data is input
	 * 7. A new BU is created with correct input data
	 */
	@Test
	public void VAN1731_CreateANewBU(){
		info("Prepare input data");
		String name = "bu"+getRandomNumber();
		String state ="Disabled";
		String description="";
		
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Go to Business Unit page");
		orgHome.goToBU();
		info("Go to Add Business Unit page");
		bu.goToAddBU();
		info("Add a new Business Unit");
		bu.add(name, state,description);
		info("Search by Status");
		bu.searchByStatus(false,false);
		info("Search by Name");
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
	}
	
	/**
	 * Test case ID: VAN-1732
	 * Test case name: Create a new user
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Organization] link
	 * Test Step 4: Click on [User]button
	 * Test Step 5: Click on [Add] button
	 * Test Step 6: Input all required fields
	 * Test Step 7: Click on [Save] button
	 * Test Step 8: Login with new user
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Organization page is shown
	 * 4. User page is shown
	 * 5. Add User page is shown
	 * 6. All data is input
	 * 7. A new user is created with correct input data
	 * 8. The new user log in successfully
	 */
	@Test
	public void VAN1732_CreateANewUser(){
		info("Prepare input data");
		String fullName = "user"+getRandomNumber();
		String email = fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String pass=password;
		String confirmPass=password;
		Boolean isView = false;
		Boolean isRandomPass=false;
		String jobTitle="";
		String rtm="";
		String region="";
		String telephone="";
		String city ="";
		String country="";
		String status="Active";
		String role="";
		
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Go to User page");
		orgHome.goToUser();
		info("Go to Add User page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName, email, hpID, pass, confirmPass, isView, isRandomPass, jobTitle, rtm, region, telephone, city, country, status, role);
		user.searchByStatus(true,false);
		user.searchByFullName(fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Logout");
		mgLogInOut.signOut();
		info("Login with new user");
		mgLogInOut.signIn(hpID, pass);
	}
}
