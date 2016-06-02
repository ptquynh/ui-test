package com.tekexperts.selenium.func.others;
import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.organization.User.fields;
import com.tekexperts.pipeline.administration.organization.User.filters;
import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.pipelineManagement.dashboard.DashboardHome.droplist;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_Users extends TestConfig{
		
	/**
	* Test case ID:VAN-1544
	* Test case name:"Add a new active user with Sale Opts role"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [User] button"
	* Expected Result:"User page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Create User page is shown"
	* Test Step 6:"Select Sale Opts role"
	* Expected Result:"The role is selected"
	* Test Step 7:"Input all remain required fields with valid data"
	* Expected Result:"All data is input successfully"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"The new user is added to the system with correct input data"
	* Test Step 10:"Go to Pipeline Dashboard"
	* Expected Result:"The new user's name is displayed in the drop-down list."
	* Test Step 11:"Go to Summary Dashboard"
	* Expected Result:"The new user's name is displayed in the drop-down list."
	* Test Step 12:"Go to Lost Dashboard"
	* Expected Result:"The new user's name is displayed in the drop-down list."
	* Test Step 13:"Go to Renewal Dashboard"
	* Expected Result:"The new user's name is displayed in the drop-down list."
	* Test Step 14:"Go to Unassign SRS page in Operation page(need manager account to see this page)"
	* Expected Result:"The user's name is displayed in the drop-down list. of [Sales Rep] column"
	*/
	@Test
	public void VAN1544_AddANewActiveUserWithSaleOptsRole(){
		info("Add a new active user with Sale Opts role");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role = roleData.getContentByType(7);
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Pipeline dashboard");
		dashboard.goToPipelineDashboard();
		dashboard.goToDroplist(droplist.SALESREP);
		dashboard.verifyDroplist("Sales Rep",fullName);
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Summary dashboard");
		dashboard.goToSummaryDashboard();
		sumDashboard.verifySaleRepInList(fullName);
		
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Lost dashboard");
		dashboard.goToLostDashboard();
		lostBUDash.verifySaleRepInList(fullName);
		lostBUDash.goToByReasonDashboard();
		lostByReasonDash.verifySaleRepInList(fullName);
		lostBUDash.goToChannelDashboard();
		lostChannelDash.verifySaleRepInList(fullName);
		lostBUDash.goToDealSizeDashboard();
		lostDealSizeDash.verifySaleRepInList(fullName);
		lostBUDash.goToDealSummaryDashboard();
		lostDealSumDash.verifySaleRepInList(fullName);
		lostBUDash.goToDurationDashboard();
		lostDuraDash.verifySaleRepInList(fullName);
		lostBUDash.goToProductLineDashboard();
		lostProDash.verifySaleRepInList(fullName);
		lostBUDash.goToRenewalTypeDashboard();
		lostRenewalDash.verifySaleRepInList(fullName);
		
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Renewal dashboard");
		dashboard.goToRenewalRate();
		renewalDash.verifySaleRepInList(fullName);
	}
	/**
	* Test case ID:VAN-1545
	* Test case name:"Edit a active user with Sale Opts role"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [User] button"
	* Expected Result:"User page is shown"
	* Test Step 5:"Click on a link in [Full Name] column"
	* Expected Result:"Edit User page is shown"
	* Test Step 6:"Select Sale Opts role"
	* Expected Result:"The role is selected"
	* Test Step 7:"Change some remain required fields with valid data"
	* Expected Result:"All data is changed successfully"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"The user at step 6 and 7 is added to the system with correct input data"
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The user's name is displayed in the drop-down list."
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The user's name is displayed in the drop-down list."
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The user's name is displayed in the drop-down list."
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The user's name is displayed in the drop-down list."
	* Test Step 13:"Go to Unassign SRS page in Operation page(need manager account to see this page)"
	* Expected Result:"The user's name is displayed in the drop-down list. of [Sales Rep] column"
	*/
	@Test
	public void VAN1545_EditAActiveUserWithSaleOptsRole(){
		info("Edit a active user with Sale Opts role");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role = roleData.getContentByType(1);
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		String role1 = roleData.getContentByType(5);
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("","","", "","","","","","","", role1);
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Pipeline dashboard");
		dashboard.goToPipelineDashboard();
		dashboard.goToDroplist(droplist.SALESREP);
		dashboard.verifyDroplist("Sales Rep",fullName);
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Summary dashboard");
		dashboard.goToSummaryDashboard();
		sumDashboard.verifySaleRepInList(fullName);
		
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Lost dashboard");
		dashboard.goToLostDashboard();
		lostBUDash.verifySaleRepInList(fullName);
		lostBUDash.goToByReasonDashboard();
		lostByReasonDash.verifySaleRepInList(fullName);
		lostBUDash.goToChannelDashboard();
		lostChannelDash.verifySaleRepInList(fullName);
		lostBUDash.goToDealSizeDashboard();
		lostDealSizeDash.verifySaleRepInList(fullName);
		lostBUDash.goToDealSummaryDashboard();
		lostDealSumDash.verifySaleRepInList(fullName);
		lostBUDash.goToDurationDashboard();
		lostDuraDash.verifySaleRepInList(fullName);
		lostBUDash.goToProductLineDashboard();
		lostProDash.verifySaleRepInList(fullName);
		lostBUDash.goToRenewalTypeDashboard();
		lostRenewalDash.verifySaleRepInList(fullName);
		
		info("Go to Dashboard home page");
		navMenu.goToDashboard();
		info("Go to Renewal dashboard");
		dashboard.goToRenewalRate();
		renewalDash.verifySaleRepInList(fullName);
	}
		
		/**
		* Test case ID:VAN-1499
		* Test case name:"Cancel editing a user by admin"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Change data in some fields"
		* Expected Result:"The data is changed as input"
		* Test Step 7:"Click on [Cancel] button"
		* Expected Result:"The new data is not updated"
		* Test Step 8:"Open [User] list page"
		* Expected Result:"All old data of the user at step 5 are kept"
		*/
	@Test
	public void VAN1499_CancelEditingAUserByAdmin(){
		info("Cancel editing a user by admin");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role = roleData.getContentByType(1);
		String newFullName="user"+getRandomNumber();
		String newEmail =fullName+"@gmail.com";
		String newHpID=getRandomNumber();
		String newTelephone=getRandomNumber();
		String newCity=getRandomString();
		String newCountry=getRandomString();
		String newRegion =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit(newFullName, newEmail, newHpID, "", "", newRegion, newTelephone, newCity, newCountry, "","");
		userlist.cancel();
		
		info("Verify that user's information is not changed");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.verifyUserHASInforInTable(fullName,email);
		userlist.verifyUserHASInforInTable(fullName,hpID);
		userlist.verifyUserHASInforInTable(fullName,role);
		driver.navigate().refresh();
		userlist.searchBy(filters.FULL_NAME,newFullName);
		userlist.verifyUserNOTInforInTable(newFullName,newEmail);
		userlist.verifyUserNOTInforInTable(newFullName,newHpID);
	}
		
		/**
		* Test case ID:VAN-1498
		* Test case name:"Edit a user with leaving HPID field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Leave [HPID] field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:HPID was required."
		*/
	@Test
	public void VAN1498_EditAUserWithLeavingHPIDField(){
		info("Edit a user with leaving HPID field");
		String error = mesg.getContentByType(8);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.clear(fields.HPID);
		userlist.save(false);
		userlist.verifyErrorMessage(error);
	}
		
		/**
		* Test case ID:VAN-1497
		* Test case name:"Edit a user with leaving Email field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Leave [Email] field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:Email was required."
		*/
	@Test
	public void VAN1497_EditAUserWithLeavingEmailField(){
		info("Edit a user with leaving Email field");
		String error = mesg.getContentByType(9);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.clear(fields.EMAIL);
		userlist.save(false);
		userlist.verifyErrorMessage(error);
	}
		
		/**
		* Test case ID:VAN-1496
		* Test case name:"Edit a user with leaving Full Name field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Leave Full Name field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:Full Name was required."
		*/
	@Test
	public void VAN1496_EditAUserWithLeavingFullNameField(){
		info("Edit a user with leaving Full Name field");
		String error = mesg.getContentByType(10);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.clear(fields.FULL_NAME);
		userlist.save(false);
		userlist.verifyErrorMessage(error);
	}
		
		/**
		* Test case ID:VAN-1495
		* Test case name:"Edit a user with leaving all required fields"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Leave all required fields"
		* Expected Result:"All required fields are blank"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:Full Name was required.HPID was required.Email was required."
		*/
	@Test
	public void VAN1495_EditAUserWithLeavingAllRequiredFields(){
		info("Edit a user with leaving all required fields");
		String error1 = mesg.getContentByType(8);
		String error2 = mesg.getContentByType(9);
		String error3 = mesg.getContentByType(10);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.clear(fields.FULL_NAME);
		userlist.clear(fields.EMAIL);
		userlist.clear(fields.HPID);
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
		userlist.verifyErrorMessage(error2);
		userlist.verifyErrorMessage(error3);
	}
		
		/**
		* Test case ID:VAN-1494
		* Test case name:"Edit a user with a new invalid email's format"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new invalid email's format"
		* Test Data:"Example: testmail.com"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:Email is invalid (emailname@domain.com)."
		*/
	@Test
	public void VAN1494_EditAUserWithANewInvalidEmailsFormat(){
		info("Edit a user with a new invalid email's format");
		String error = mesg.getContentByType(11);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String newEmail=getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("", newEmail,"","","","","","","","","");
		userlist.save(false);
		userlist.verifyErrorMessage(error);
	}
		
		/**
		* Test case ID:VAN-1493
		* Test case name:"Edit a user with a new HPID is existed"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new [HPID] that is existed in the system"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:This HPID is already in use."
		*/
	@Test
	public void VAN1493_EditAUserWithANewHPIDIsExisted(){
		info("Edit a user with a new HPID is existed");
		String error = mesg.getContentByType(12);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("","","6666","","","","","","","","");
		userlist.save(false);
		userlist.verifyNotifcationMessage(error);
	}
		
		/**
		* Test case ID:VAN-1492
		* Test case name:"Edit a user with a new HPID is not existed"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new [HPID] that is not existed in the system"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The new data is updated"
		* Test Step 8:"Check the user at step 5 in the table"
		* Expected Result:"The user still is displayed in the table with new HPID at step 6"
		* Test Step 9:"Click on [Full Name] link of the user at step 5"
		* Expected Result:"The new data is displayed in corresponding field as input at step 6"
		* Test Step 10:"Logout and login with new HPID for the user at step 5"
		* Expected Result:"The user login successfully"
		* Test Step 11:"Open user's Profile page"
		* Expected Result:"All new data at step 6 is displayed in the page"
		*/
	@Test
	public void VAN1492_EditAUserWithANewHPIDIsNotExisted(){
		info("Edit a user with a new HPID is not existed");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String newHpID=getRandomNumber();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("","",newHpID,"","","","","","","","");
		userlist.save();
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.verifyUserHASInforInTable(fullName, newHpID);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(newHpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("All new data at step 6 is displayed in the page");
		userPro.verifyUserInfor(fullName);
		userPro.verifyUserInfor(email);
		userPro.verifyUserInfor(newHpID);
		userPro.verifyUserInfor("Manager");
		userPro.verifyUserInfor("RSR");
		userPro.verifyUserInfor(telephone);
		userPro.verifyUserInfor(city);
		userPro.verifyUserInfor(country);
		userPro.verifyUserInfor("Active");
		userPro.verifyUserInfor("Administrator");
	}
		
		/**
		* Test case ID:VAN-1491
		* Test case name:"Edit a user with a new Full Name is existed"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new Full name that is existed in the system"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The new data is updated"
		* Test Step 8:"Check the user at step 5 in the table"
		* Expected Result:"The user still is displayed in the table with a new full name"
		* Test Step 9:"Click on [Full Name] link of the user at step 5"
		* Expected Result:"The new full name is displayed in corresponding field as input at step 6"
		* Test Step 10:"Logout and login with the user at step 5"
		* Expected Result:"The user login successfully*The new full name at step 6 is displayed on navigation bar"
		* Test Step 11:"Open user's Profile page"
		* Expected Result:"All new full name at step 6 is displayed in the page"
		*/
	@Test
	public void VAN1491_EditAUserWithANewFullNameIsExisted(){
		info("Edit a user with a new Full Name is existed");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit(USER_ROOT_FULLNAME,"","","","","","","","","","");
		userlist.save();
		userlist.searchBy(filters.FULL_NAME,USER_ROOT_FULLNAME);
		userlist.verifyUserHASInforInTable(USER_ROOT_FULLNAME,email);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("All new data at step 6 is displayed in the page");
		userPro.verifyUserInfor(USER_ROOT_FULLNAME);
		userPro.verifyUserInfor(email);
		userPro.verifyUserInfor(hpID);
		userPro.verifyUserInfor("Manager");
		userPro.verifyUserInfor("RSR");
		userPro.verifyUserInfor(telephone);
		userPro.verifyUserInfor(city);
		userPro.verifyUserInfor(country);
		userPro.verifyUserInfor("Active");
		userPro.verifyUserInfor("Administrator");
	}
		
		/**
		* Test case ID:VAN-1490
		* Test case name:"Edit a user with a new valid email is existed"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new valid email that is existed in the system"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The user cannot update. A error message is displayed as:This Email is already in use."
		*/
	@Test
	public void VAN1490_EditAUserWithANewValidEmailIsExisted(){
		info("Edit a user with a new valid email is existed");
		String error = mesg.getContentByType(13);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("",USER_ROOT_EMAIL,"","","","","","","","","");
		userlist.save(false);
		userlist.verifyNotifcationMessage(error);
	}
		
		/**
		* Test case ID:VAN-1489
		* Test case name:"Edit a user with a new valid email is not existed"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new valid email that is not existed in the system"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The new data is updated"
		* Test Step 8:"Check the user at step 5 in the table"
		* Expected Result:"The user still is displayed in the table with new email at step 6"
		* Test Step 9:"Click on [Full Name] link of the user at step 5"
		* Expected Result:"The new data is displayed in corresponding field as input at step 6"
		* Test Step 10:"Logout and login with a new email for the user at step 5"
		* Expected Result:"The user login successfully"
		* Test Step 11:"Open user's Profile page"
		* Expected Result:"All new data at step 6 is displayed in the page"
		*/
	@Test
	public void VAN1489_EditAUserWithANewValidEmailIsNotExisted(){
		info("Edit a user with a new valid email is not existed");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String newEmail=getRandomString()+"@gmail.com";
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("",newEmail,"","","","","","","","","");
		userlist.save();
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.verifyUserHASInforInTable(fullName,newEmail);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("All new data at step 6 is displayed in the page");
		userPro.verifyUserInfor(fullName);
		userPro.verifyUserInfor(newEmail);
		userPro.verifyUserInfor(hpID);
		userPro.verifyUserInfor("Manager");
		userPro.verifyUserInfor("RSR");
		userPro.verifyUserInfor(telephone);
		userPro.verifyUserInfor(city);
		userPro.verifyUserInfor(country);
		userPro.verifyUserInfor("Active");
		userPro.verifyUserInfor("Administrator");
	}
		
		/**
		* Test case ID:VAN-1488
		* Test case name:"Edit a user with a new Full Name is not existed"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Update a new Full name that is not existed in the system"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The new data is updated"
		* Test Step 8:"Check the user at step 5 in the table"
		* Expected Result:"The user still is displayed in the table with a new full name"
		* Test Step 9:"Click on [Full Name] link of the user at step 5"
		* Expected Result:"The new full name is displayed in corresponding field as input at step 6"
		* Test Step 10:"Logout and login with the user at step 5"
		* Expected Result:"The user login successfully*The new full name at step 6 is displayed on navigation bar"
		* Test Step 11:"Open user's Profile page"
		* Expected Result:"All new full name at step 6 is displayed in the page"
		*/
	@Test
	public void VAN1488_EditAUserWithANewFullNameIsNotExisted(){
		info("Edit a user with a new Full Name is not existed");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String newFullName="user"+getRandomNumber();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit(newFullName,"","","","","","","","","","");
		userlist.save();
		userlist.searchBy(filters.FULL_NAME,newFullName);
		userlist.verifyUserInTheTable(newFullName);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("All new data at step 6 is displayed in the page");
		userPro.verifyUserInfor(newFullName);
		userPro.verifyUserInfor(email);
		userPro.verifyUserInfor(hpID);
		userPro.verifyUserInfor("Manager");
		userPro.verifyUserInfor("RSR");
		userPro.verifyUserInfor(telephone);
		userPro.verifyUserInfor(city);
		userPro.verifyUserInfor(country);
		userPro.verifyUserInfor("Active");
		userPro.verifyUserInfor("Administrator");
	}
		
		/**
		* Test case ID:VAN-1487
		* Test case name:"Edit a user without change required fields"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Full Name] link of a user in the table"
		* Expected Result:"Edit User page is shown*All old data still is displayed in corresponding fileds"
		* Test Step 6:"Change new data for some fields without required fields"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The new data is updated"
		* Test Step 8:"Check the user at step 5 in the table"
		* Expected Result:"The user still is displayed in the table with new data at step 6"
		* Test Step 9:"Click on [Full Name] link of the user at step 5"
		* Expected Result:"All change data is displayed in corresponding fields as input at step 6"
		* Test Step 10:"Logout and login with the user at step 5"
		* Expected Result:"The user login successfully"
		* Test Step 11:"Open user's Profile page"
		* Expected Result:"All new change data at step 6 is displayed in the page"
		*/
	@Test
	public void VAN1487_EditAUserWithoutChangeRequiredFields(){
		info("Edit a user without change required fields");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String newTelephone=getRandomNumber();
		String newCity=getRandomString();
		String newCountry=getRandomString();
		String newRegion =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Edit the user");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("","","", "", "", newRegion, newTelephone, newCity,newCountry,"","");
		userlist.save();
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("All new data at step 6 is displayed in the page");
		userPro.verifyUserInfor(fullName);
		userPro.verifyUserInfor(email);
		userPro.verifyUserInfor(hpID);
		userPro.verifyUserInfor("Manager");
		userPro.verifyUserInfor("RSR");
		userPro.verifyUserInfor(newRegion);
		userPro.verifyUserInfor(newTelephone);
		userPro.verifyUserInfor(newCity);
		userPro.verifyUserInfor(newCountry);
		userPro.verifyUserInfor("Active");
		userPro.verifyUserInfor("Administrator");
	}
		
		/**
		* Test case ID:VAN-1486
		* Test case name:"Check paging control"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Check paging control by default"
		* Expected Result:"Display the data correctly with corresponding first page*[Previous] button is hided*[Next] button still is shown"
		* Test Step 6:"Click on a number in the control"
		* Expected Result:"Display the data correctly with corresponding selected number"
		* Test Step 7:"Click on [Next] button"
		* Expected Result:"Display the data correctly with corresponding next page"
		* Test Step 8:"Click on [Previous] button"
		* Expected Result:"Display the data correctly with corresponding previous page"
		* Test Step 9:"Click at the end of the control"
		* Expected Result:"Display the data correctly with corresponding last page*[Next] button is hided*[Previous] button still is shown"
		* Test Step 10:"Check total number items"
		* Expected Result:"Display correct total number items"
		* PENDING: THIS SHOULD BE TESTED BY MANUAL
		*/
	@Test(groups="pending")
	public void VAN1486_CheckPagingControl(){
	}
		
		/**
		* Test case ID:VAN-1485
		* Test case name:"Check paging size"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Check paging size by default"
		* Expected Result:"Display 50 lines/page"
		* Test Step 6:"Select a value in the drop-down list"
		* Expected Result:"Display the data correctly with corresponding selected value"
		*/
	@Test
	public void VAN1485_CheckPagingSize(){
		info("Check paging size");
		String[] listSize={"10","20","50","100","200"};
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		Utils.pause(3000);
		info("Change the page size");
		userlist.checkPageSize(listSize);
	}
		
		/**
		* Test case ID:VAN-1484
		* Test case name:"Cancel Resetting password for a user by admin"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Reset] link of selected user in [Reset] column"
		* Expected Result:"Display a confirm popup with the text: Are you sure you want to reset password for <user_fullName> - <user_email>?"
		* Test Step 6:"Click [No] button on the popup"
		* Expected Result:"The confirm popup is closed"
		* Test Step 7:"Go to user's email inbox"
		* Expected Result:"The user doesn't receive a email with new password"
		* Test Step 8:"Logout and login with old password for the user at step 5"
		* Expected Result:"The user can access to the system"
		* PENDING: CANNOT CHECK EMAIL IN LOCAL TEST.
		*/
	@Test(groups="pending")
	public void VAN1484_CancelResettingPasswordForAUserByAdmin(){
	}
		
		/**
		* Test case ID:VAN-1483
		* Test case name:"Reset password for a user by admin"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Reset] link of selected user in [Reset] column"
		* Expected Result:"Display a confirm popup with the text: Are you sure you want to reset password for <user_fullName> - <user_email>?"
		* Test Step 6:"Click [Yes] button on the popup"
		* Expected Result:"A message is displayed as:Password has been reset and sent to user."
		* Test Step 7:"Go to user's email inbox"
		* Expected Result:"The user is received a email with new password"
		* Test Step 8:"Logout and login with new password for the user at step 5"
		* Expected Result:"The user login successfully"
		* PENDING: CANNOT CHECK EMAIL IN LOCAL TEST.
		*/
	@Test(groups="pending")
	public void VAN1483_ResetPasswordForAUserByAdmin(){
	}
		
		/**
		* Test case ID:VAN-1482
		* Test case name:"Unset Credential for a user that is no RSR role"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Unset] link of selected user"
		* Expected Result:"Open [Set Credential] page"
		* Test Step 6:"Click on [Unset] link in the [Unset] column"
		* Expected Result:"The selected credential is removed from the table"
		* Test Step 7:"Observer the user at step 5 in User list"
		* Expected Result:"[Set]link is changed to [Unset] link if has not any credential is set*The selected credential at step 6 is not displayed in Credential column"
		* Test Step 8:"Logout and login with the user at step 5"
		* Expected Result:"The user login successfully"
		* Test Step 9:"Go to Profile page from navigation bar"
		* Expected Result:"Profile page is shown"
		* Test Step 10:"Observer My Credential section"
		* Expected Result:"The selected credential at step 7 is not displayed in this section*if has not any credential is set at step 7
		* Test Step 11:"Go to pipeline list"
		* Expected Result:"The user will not see the contracts that belong to unset credential at step 6.*If the user has not any credentials are set at step 7
		*/
	@Test
	public void VAN1482_UnsetCredentialForAUserThatIsNoRSRRole(){
		info("Edit a user without change required fields");
		info("Create a new user");
		String preName=getRandomString();
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Set credential for the user");
		userlist.goToSetCredential(fullName);
		userlist.setCredential("","","");
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("Verify that the credential is shown in the user profile page");
		userPro.verifyUserInfor("WW");
		userPro.verifyUserInfor("All");
		userPro.verifyUserInfor("All");
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Set credential for the user");
		userlist.goToSetCredential(fullName);
		info("Unset an credential");
		userlist.unSetCredential("","","");
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("Verify that the credential is shown in the user profile page");
		userPro.verifyUserNOTInfor("WW");
		userPro.verifyUserNOTInfor("All");
		userPro.verifyUserNOTInfor("All");
	}
		
		/**
		* Test case ID:VAN-1481
		* Test case name:"Check setting credential for a RSR user"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Find a RSR user in the table and observe [Set Credential] column"
		* Expected Result:"[Set/Unset] link is not displayed"
		*/
	@Test
	public void VAN1481_CheckSettingCredentialForARSRUser(){
		info("Check setting credential for a RSR user");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role = roleData.getContentByType(5);
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("[Set/Unset] link is not displayed");
		userlist.verifyNOTCredentialLink(fullName);
	}
		
		/**
		* Test case ID:VAN-1480
		* Test case name:"Canceling setting credential for no RSR user"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Set/Unset] link of selected user"
		* Expected Result:"Open [Set Credential] page"
		* Test Step 6:"Change some fields"
		* Expected Result:"The field are changed data as input"
		* Test Step 7:"Click on [Cancel] button"
		* Expected Result:"The new credential is not added to the table"
		* Test Step 8:"Observer the user at step 5 in User list"
		* Expected Result:"The new credential is not displayed in Credential column"
		* Test Step 9:"Logout and login with the user at step 5"
		* Expected Result:"The user login successfully"
		* Test Step 10:"Go to Profile page from navigation bar"
		* Expected Result:"Profile page is shown"
		* Test Step 11:"Observer My Credential section"
		* Expected Result:"The new credential at step 7 is not displayed in this section"
		*/
	@Test
	public void VAN1480_CancelingSettingCredentialForNoRSRUser(){
		info("Canceling setting credential for no RSR user");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Set credential for the user");
		userlist.goToSetCredential(fullName);
		userlist.cancelBtn();
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("Verify that the credential is shown in the user profile page");
		userPro.verifyUserNOTInfor("WW");
		userPro.verifyUserNOTInfor("All");
		userPro.verifyUserNOTInfor("All");
	}
		
		/**
		* Test case ID:VAN-1479
		* Test case name:"Set Credential for a user that is no RSR role"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Set] link of selected user"
		* Expected Result:"Open [Set Credential] page"
		* Test Step 6:"Change some fields"
		* Expected Result:"The field are changed data as input"
		* Test Step 7:"Click on [Set] button"
		* Expected Result:"The new credential is added to a bellow table"
		* Test Step 8:"Observer the user at step 5 in User list"
		* Expected Result:"[Set]link is changed to [Unset] link*The new credential is displayed in Credential column"
		* Test Step 9:"Logout and login with the user at step 5"
		* Expected Result:"The user login successfully"
		* Test Step 10:"Go to Profile page from navigation bar"
		* Expected Result:"Profile page is shown"
		* Test Step 11:"Observer My Credential section"
		* Expected Result:"The new credential at step 7 is displayed in this section"
		* Test Step 12:"Go to pipeline list"
		* Expected Result:"The user only see contracts and orders that belongs to owner credential"
		*/
	@Test
	public void VAN1479_SetCredentialForAUserThatIsNoRSRRole(){
		info("Set Credential for a user that is no RSR role");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Set credential for the user");
		userlist.goToSetCredential(fullName);
		userlist.setCredential("","","");
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("Open user profile page");
		navMenu.goToUserProfile();
		info("Verify that the credential is shown in the user profile page");
		userPro.verifyUserInfor("WW");
		userPro.verifyUserInfor("All");
		userPro.verifyUserInfor("All");
		
	}
		
		/**
		* Test case ID:VAN-1478
		* Test case name:"Check multi-filters"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type some texts in some filter fields"
		* Expected Result:"The texts are displayed in the filter fields"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display data correctly with corresponding filter*if not found
		*/
	@Test
	public void VAN1478_CheckMultifilters(){
		info("Check multi-filters");
		info("Create a new user 1");
		String preName=getRandomString();
		String preHPID=getRandomNumber();
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		String telephone1=getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone1,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 3");
		String fullName2=preName+getRandomNumber();
		String email2 =fullName2+"@gmail.com";
		String hpID2=preHPID+getRandomNumber();
		String region1=getRandomString();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName2, email2, hpID2,USER_PASS, USER_PASS,false,false,"", "",region1, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search multi");
		userlist.searchBy(filters.FULL_NAME,preName);
		userlist.searchBy(filters.HPID,preHPID);
		userlist.searchBy(filters.REGION,region);
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyUserInTheTable(fullName);
		userlist.verifyNOTUserInTheTable(fullName2);
	}
		
		/**
		* Test case ID:VAN-1477
		* Test case name:"Check filter by default"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Clear all input text in filter fields"
		* Expected Result:"All filter fields are blank"
		* Test Step 6:"Press Enter key"
		* Expected Result:"All data in the system is shown"
		*/
	@Test
	public void VAN1477_CheckFilterByDefault(){
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("All data in the system is shown");
		int defaultData=userlist.getDefaulPageSize();
		int rowData=userlist.getNumberRow();
		if(defaultData!=rowData)assert false:"All data is not shown";
	}
		
		/**
		* Test case ID:VAN-1476
		* Test case name:"Check filter by Last Login Date"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of [Last Login Date] column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1476_CheckFilterByLastLoginDate(){
		info("Check filter by Last Login Date");
		info("Create a new user 1");
		String preName=getRandomString();
		String preHPID=getRandomNumber();
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		String telephone1=getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone1,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 3");
		String fullName2=preName+getRandomNumber();
		String email2 =fullName2+"@gmail.com";
		String hpID2=preHPID+getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName2, email2, hpID2,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		Utils.pause(2000);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID1, USER_PASS);
		Utils.pause(2000);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		
		info("Search by last login date");
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		String date = getCurrentDate("MMM d yyyy");
		info("date:"+date);
		userlist.searchBy(filters.LAST_LOGIN_DATE,date);
		userlist.searchBy(filters.FULL_NAME,preName);
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyUserInTheTable(fullName);
		userlist.verifyNOTUserInTheTable(fullName2);
	}
		
		/**
		* Test case ID:VAN-1475
		* Test case name:"Check filter by Login Count"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of [Login Count] column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1475_CheckFilterByLoginCount(){
		info("Check filter by Login Count");
		info("Create a new user 1");
		String preName=getRandomString();
		String preHPID=getRandomNumber();
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		String telephone1=getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone1,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		Utils.pause(2000);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		
		info("Search by login count");
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		userlist.searchBy(filters.FULL_NAME,preName);
		userlist.searchBy(filters.LOGIN_COUNT,"0");
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyNOTUserInTheTable(fullName);
	}
		
		/**
		* Test case ID:VAN-1474
		* Test case name:"Check filter by Status"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of [Status] column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1474_CheckFilterByStatus(){
		info("Check filter by Status");
		info("Create a new user 1");
		String preName=getRandomString();
		String preHPID=getRandomNumber();
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		String telephone1=getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone1,city,country,"Disabled","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by login count");
		userlist.searchBy(filters.FULL_NAME,preName);
		userlist.searchByStatus(false,false);
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyNOTUserInTheTable(fullName);
	}
		
		/**
		* Test case ID:VAN-1473
		* Test case name:"Check filter by Region"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of [Region] column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1473_CheckFilterByRegion(){
		info("Check filter by Region");
		info("Create a new user 1");
		String preName="user";
		String preHPID="8080";
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		String region1=getRandomString();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region1, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by login count");
		userlist.searchBy(filters.REGION,region1);
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyNOTUserInTheTable(fullName);
	}
		
		/**
		* Test case ID:VAN-1472
		* Test case name:"Check filter by HPID"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of [HPID] column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1472_CheckFilterByHPID(){
		info("Check filter by HPID");
		info("Create a new user 1");
		String preName="user";
		String preHPID="8080";
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by login count");
		userlist.searchBy(filters.HPID,hpID1);
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyNOTUserInTheTable(fullName);
	}
		
		/**
		* Test case ID:VAN-1471
		* Test case name:"Check filter by Email"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of Email column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1471_CheckFilterByEmail(){
		info("Check filter by Email");
		info("Create a new user 1");
		String preName="user";
		String preHPID="8080";
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by login count");
		userlist.searchBy(filters.EMAIL,email1);
		userlist.verifyUserInTheTable(fullName1);
		userlist.verifyNOTUserInTheTable(fullName);
	}
		
		/**
		* Test case ID:VAN-1470
		* Test case name:"Check filter by Role"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of Role column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1470_CheckFilterByRole(){
		info("Check filter by Role");
		info("Create a new user 1");
		String preName="user";
		String preHPID="8080";
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role=roleData.getContentByType(3);
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by login count");
		userlist.searchBy(filters.ROLE,role);
		userlist.verifyUserInTheTable(fullName);
		userlist.verifyNOTUserInTheTable(fullName1);
	}
		
		/**
		* Test case ID:VAN-1469
		* Test case name:"Check filter by Full name"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Type a text in the filter field of Full Name column"
		* Expected Result:"The text is input"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data correctly with corresponding input text*If not found
		*/
	@Test
	public void VAN1469_CheckFilterByFullName(){
		info("Check filter by Full name");
		info("Create a new user 1");
		String preName="user";
		String preHPID="8080";
		String fullName=preName+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=preHPID+getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Create a new user 2");
		String fullName1=preName+getRandomNumber();
		String email1 =fullName1+"@gmail.com";
		String hpID1=preHPID+getRandomNumber();
		
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName1, email1, hpID1,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by login count");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.verifyUserInTheTable(fullName);
		userlist.verifyNOTUserInTheTable(fullName1);
	}
		/**
		* Test case ID:VAN-1468
		* Test case name:"Add a new user with both passwords do not match"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Fill all required fields without password and confirm password"
		* Expected Result:"All data is input"
		* Test Step 7:"Input a valid password"
		* Test Data:Example:Test@123456
		* Expected Result:"A password is displayed and hides characters"
		* Test Step 8:"Input an invalid confirm password"
		* Test Data:"Example: 123456"
		* Expected Result:"A password is displayed and hides characters"
		* Test Step 9:"Click on [Save] button"
		* Expected Result:"Display an error message as:""'Confirm new password' and 'Password' do not match."""
		*/

	@Test
	public void VAN1468_AddANewUserWithBothPasswordsDoNotMatch(){
		info("Add a new user with both passwords do not match");
		String error=mesg.getContentByType(14);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String confirmPass="Dev@"+getRandomNumber();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS,confirmPass,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error);
	}
		
		/**
		* Test case ID:VAN-1467
		* Test case name:"Add a new user with an invalid password"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Fill all required fields without password and confirm password"
		* Expected Result:"All data is input"
		* Test Step 7:"Input an invalid password less than 8 characters"
		* Test Data:"Example: 123456"
		* Expected Result:"A password is displayed and hides characters"
		* Test Step 8:"Input a valid confirm password"
		* Test Data:"Example: 123456"
		* Expected Result:"A password is displayed and hides characters"
		* Test Step 9:"Click on [Save] button"
		* Expected Result:"Display an error message as:"" Your password must contain an uppercase
		* Test Step 10:"Input an invalid password at least 8 characters"
		* Test Data:"Example:Case1: 12345678Case2: e12345678Case3: Te12345678"
		* Expected Result:"A password is displayed and hides characters"
		* Test Step 11:"Input a valid confirm password"
		* Test Data:"Example:Case1: 12345678Case2: e12345678Case3: Te12345678"
		* Expected Result:"A password is displayed and hides characters"
		* Test Step 12:"Click on [Save] button"
		* Expected Result:"Display an error message as:"" Your password must contain an uppercase
		*/
	@Test
	public void VAN1467_AddANewUserWithAnInvalidPassword(){
		info("Add a new user with an invalid password");
		String error1=mesg.getContentByType(5);
		String error2=mesg.getContentByType(6);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String confirmPass=getRandomNumber();
		String confirmPass1=getRandomNumber()+"12";
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,confirmPass,confirmPass,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
		userlist.verifyErrorMessage(error2);
		userlist.add("","","",confirmPass1,confirmPass1,false,false,"", "","","","","","","");
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
		userlist.verifyNOTErrorMessage(error2);
	}
		
		/**
		* Test case ID:VAN-1466
		* Test case name:"Create a Random password when added a new user"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Fill all required fields without password and confirm password"
		* Expected Result:"All data is input"
		* Test Step 7:"Check [View] checkbox"
		* Expected Result:"The checkbox is checked"
		* Test Step 8:"Click on [Random Password] button"
		* Expected Result:"A random password is inserted to Password and Confirm Password fields"
		* Test Step 9:"Clear all random passwords in password and confirm password fields"
		* Expected Result:"All data is cleared"
		* Test Step 10:"Input a valid password to both password fields"
		* Expected Result:"The passwords are input"
		* Test Step 11:"Click on [Random Password] button again"
		* Expected Result:"All old passwords are replaced by random password in password and confirm password fileds"
		* Test Step 12:"Click on [Save] button"
		* Expected Result:"All information is saved"
		* Test Step 13:"Logout and login with a new user by a new random password"
		* Expected Result:"The new user can access to the system"
		* PENDING: CANNOT GET PASSWORD WHEN USING CREATE A PASSWORD BY RANDOM
		*/
	@Test(groups="pending")
	public void VAN1466_CreateARandomPasswordWhenAddedANewUser(){
	}
		
		/**
		* Test case ID:VAN-1465
		* Test case name:"Show/Hide password's characters when added a new user"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Fill all required fields"
		* Expected Result:"All data is input"
		* Test Step 7:"Check [View] check box"
		* Expected Result:"The checkbox is checked"
		* Test Step 8:"Check password's characters"
		* Expected Result:"All characters are shown"
		* Test Step 9:"Check confirm password's characters"
		* Expected Result:"All characters are shown"
		* Test Step 10:"Uncheck [View] checkbox"
		* Expected Result:"The checkbox is unchecked"
		* Test Step 11:"Check password's characters again"
		* Expected Result:"All characters are hided"
		* Test Step 12:"Check confirm password's characters again"
		* Expected Result:"All characters are hided"
		* PENDING: CANNOT CHECK AUTO WHEN PASSWORD IS HIDED OR SHOWN
		*/
	@Test(groups="pending")
	public void VAN1465_ShowHidePasswordsCharactersWhenAddedANewUser(){
	}
		
		/**
		* Test case ID:VAN-1464
		* Test case name:"Canceling adding a new user"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Fill all required fields"
		* Expected Result:"All data is input"
		* Test Step 7:"Click on [Cancel] button"
		* Expected Result:"The new user is not created"
		* Test Step 8:"Logout and login with new user"
		* Expected Result:"The new user cannot access to the system"
		*/
	@Test
	public void VAN1464_CancelingAddingANewUser(){
		info("Canceling adding a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.cancel();
		userlist.verifyNOTUserInTheTable(fullName);
		
	}
		
		/**
		* Test case ID:VAN-1463
		* Test case name:"Add a new user with leaving Confirm Password field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Leave Confirm Password field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Fill all other required fields"
		* Expected Result:"All data is input"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"Display an error message as: Confirm Password was required."
		*/
	@Test
	public void VAN1463_AddANewUserWithLeavingConfirmPasswordField(){
		info("Add a new user with leaving Confirm Password field");
		String error = mesg.getContentByType(15);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,USER_PASS,"",false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error);
	}
		
		/**
		* Test case ID:VAN-1462
		* Test case name:"Add a new user with leaving Password field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Leave Password field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Fill all other required fields"
		* Expected Result:"All data is input"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"Display an error message as: Password was required."
		*/
	@Test
	public void VAN1462_AddANewUserWithLeavingPasswordField(){
		info("Add a new user with leaving Password field");
		String error1 = mesg.getContentByType(16);
		String error2 = mesg.getContentByType(14);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email, hpID,"",USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
		userlist.verifyErrorMessage(error2);
	}
		
		/**
		* Test case ID:VAN-1461
		* Test case name:"Add a new user with leaving HPID field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Leave HP ID field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Fill all other required fields"
		* Expected Result:"All data is input"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"Display an error message as: HPID was required."
		*/
	@Test
	public void VAN1461_AddANewUserWithLeavingHPIDField(){
		info("Add a new user with leaving HPID field");
		String error1 = mesg.getContentByType(8);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName, email,"",USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
	}
		
		/**
		* Test case ID:VAN-1460
		* Test case name:"Add a new user with leaving Email field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Leave Email field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Fill all other required fields"
		* Expected Result:"All data is input"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"Display an error message as: Email was required."
		*/
	@Test
	public void VAN1460_AddANewUserWithLeavingEmailField(){
		info("Add a new user with leaving Email field");
		String error1 = mesg.getContentByType(9);
		String fullName="user"+getRandomNumber();
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName,"",hpID,USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
	}
		
		/**
		* Test case ID:VAN-1459
		* Test case name:"Add a new user with leaving full name field"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Leave Full name field"
		* Expected Result:"The field is blank"
		* Test Step 7:"Fill all other required fields"
		* Expected Result:"All data is input"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"Display an error message as: Full Name was required."
		*/
	@Test
	public void VAN1459_AddANewUserWithLeavingFullNameField(){
		info("Add a new user with leaving full name field");
		String error1 = mesg.getContentByType(10);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add("",email,hpID,USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyErrorMessage(error1);
	}
		
		/**
		* Test case ID:VAN-1458
		* Test case name:"Add a new user that is existed in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Input all required fields with valid data"
		* Expected Result:"All data is input successfully"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"Cannot create user. A error message is displayed as:""This email/HPID is already in use. """
		*/
	@Test
	public void VAN1458_AddANewUserThatIsExistedInTheSystem(){
		info("Add a new user that is existed in the system");
		String error1 = mesg.getContentByType(13);
		String error2 = mesg.getContentByType(12);
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName,USER_ROOT_EMAIL,hpID,USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyNotifcationMessage(error1);
		userlist.add(fullName,email,USER_ROOT,USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save(false);
		userlist.verifyNotifcationMessage(error2);
	}
		
		/**
		* Test case ID:VAN-1457
		* Test case name:"Add a new user that is not existed in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Click on [Add] button"
		* Expected Result:"Create User page is shown"
		* Test Step 6:"Input all required fields with valid data"
		* Expected Result:"All data is input successfully"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"The new user is added to the system with correct input data"
		* Test Step 8:"Logout and login with new user"
		* Expected Result:"The new user can access to the system"
		*/
	@Test
	public void VAN1457_AddANewUserThatIsNotExistedInTheSystem(){
		info("Add a new user that is not existed in the system");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgaHome.goToUser();
		info("Go to Add user page");
		userlist.goToAddUser();
		info("Add a new user");
		userlist.add(fullName,email,hpID,USER_PASS,USER_PASS,false,false,"", "",region, telephone,city,country,"","");
		userlist.save();
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.verifyUserInTheTable(fullName);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		navMenu.goToUserProfile();
	}
		
		/**
		* Test case ID:VAN-1456
		* Test case name:"Check breadcrumb on User Management page"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User page is shown"
		* Test Step 5:"Check breadcrumb"
		* Expected Result:"Display following direction as: Home->Administration->Organization->User"
		* Test Step 6:"Click on a link of the breadcrumb"
		* Test Data:"Example: Organization"
		* Expected Result:"Redirect to correct page. Here is Organization page"
		* PENDING: THIS CASE SHOULD BE TESTED BY MANUAL
		*/
	@Test(groups="pending")
	public void VAN1456_CheckBreadcrumbOnUserManagementPage(){
	}
}