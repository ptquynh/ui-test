package com.tekexperts.selenium.func.administration;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.organization.User.filters;
public class Func_Organization_User extends TestConfig{
		
		/**
		* Test case ID:VAN-1435
		* Test case name:"Canceling change password by admin"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization]link in left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User list is shown"
		* Test Step 5:"Click on [Change] link in [Change Password] column of a user"
		* Expected Result:"Change password page is shown"
		* Test Step 6:"Input a valid new password"
		* Test Data:Example:Test@123456
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 7:"Input a valid confirm new password"
		* Test Data:Example:Test@123456
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 8:"Click on [Cancel] button"
		* Expected Result:"The password is not changed"
		* Test Step 9:"Logout and login with a new password for the user at step 5"
		* Expected Result:"The user cannot access to the system"
		* Test Step 10:"Login with a old password for the user at step 5"
		* Expected Result:"The user can access to the system normaly"
		*/
	@Test
	public void VAN1435_CancelingChangePasswordByAdmin(){
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
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Open Change password page");
		String newPass="Dev@"+getRandomNumber();
		user.changePass(fullName,newPass,newPass);
		user.cancelChangePass();
		
		info("Login with old password");
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, newPass);
		info("Verify that the login page still shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,2000,1);
		
		info("Login with new password");
		mgLogInOut.signIn(hpID,pass);
		info("Verify that The user is login successfully");
		waitForElementNotPresent(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,2000,1);
		waitForAndGetElement(navMenu.ELEMENT_NAVIGATION_BAR_LOGGED_IN_LABEL.replace("$value",fullName),2000,1);
	}
		
		/**
		* Test case ID:VAN-1434
		* Test case name:"Change password by admin with all invalid data"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization]link in left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User list is shown"
		* Test Step 5:"Click on [Change] link in [Change Password] column of a user"
		* Expected Result:"Change password page is shown"
		* Test Step 6:"Input an invalid new password"
		* Test Data:Example:123456
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 7:"Input an invalid confirm new password"
		* Test Data:"Example: 12345678"
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"A error message is displayed as:Your password must be at least 8 characters. 'Confirm new password' and 'New password' do not match.Your password must contain an uppercase
		*/
	@Test
	public void VAN1434_ChangePasswordByAdminWithAllInvalidData(){
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
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Open Change password page");
		String newPass=getRandomNumber();
		String confPass=getRandomNumber();
		String message1=mesg.getContentByType(4);
		String message2=mesg.getContentByType(5);
		user.changePass(fullName,newPass,confPass);
		user.saveChangePass(false);
		info("Verify that error messages are shown");
		user.verifyErrorMessage(message1);
		user.verifyErrorMessage(message2);
		
	}
		
		/**
		* Test case ID:VAN-1433
		* Test case name:"Change password by admin with an invalid confirm new password"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization]link in left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User list is shown"
		* Test Step 5:"Click on [Change] link in [Change Password] column of a user"
		* Expected Result:"Change password page is shown"
		* Test Step 6:"Input a valid new password"
		* Test Data:Example:Test@123456
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 7:"Input an invalid confirm new password"
		* Test Data:"Example: 123456"
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"A error message is displayed as:"" 'Confirm new password' and 'New password' do not match"""
		*/
	@Test
	public void VAN1433_ChangePasswordByAdminWithAnInvalidConfirmNewPassword(){
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
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Open Change password page");
		String newPass="Dev@"+getRandomNumber();
		String confPass=getRandomNumber();
		String message1=mesg.getContentByType(4);
		user.changePass(fullName,newPass,confPass);
		user.saveChangePass(false);
		info("Verify that error message is shown");
		user.verifyErrorMessage(message1);
	}
		
		/**
		* Test case ID:VAN-1431
		* Test case name:"Change password by admin with an invalid new password"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization]link in left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User list is shown"
		* Test Step 5:"Click on [Change] link in [Change Password] column of a user"
		* Expected Result:"Change password page is shown"
		* Test Step 6:"Input an invalid new password less than 8 characters"
		* Test Data:Example:123456
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 7:"Input a valid confirm new password"
		* Test Data:"Example: 123456"
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"A error message is displayed as:""Your password must be at least 8 characters. Your password must contain an uppercase
		* Test Step 9:"Input an invalid new password at least 8 characters"
		* Test Data:"New Password:case1: 12345678case2: Te12345678case3: e12345678"
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 10:"Execute step 7 and 8 again with correct confirm new password"
		* Expected Result:"A error message is displayed as:""Your password must contain an uppercase
		*/
	@Test
	public void VAN1431_ChangePasswordByAdminWithAnInvalidNewPassword(){
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
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Open Change password page");
		String newPass=getRandomNumber();
		String confPass="Dev@"+getRandomNumber();
		String message2=mesg.getContentByType(5);
		user.changePass(fullName,newPass,confPass);
		user.saveChangePass(false);
		info("Verify that error messages are shown");
		user.verifyErrorMessage(message2);
	}
		
		/**
		* Test case ID:VAN-1430
		* Test case name:"Change password by admin"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on Organization link in left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [User] button"
		* Expected Result:"User list is shown"
		* Test Step 5:"Find a user in the list and click on [Change] link in [Change password] column"
		* Test Data:Example:user3
		* Expected Result:"Change password page is shown"
		* Test Step 6:"Input a valid new password"
		* Test Data:Example:Test@12345678
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 7:"Input a valid confirm new password"
		* Test Data:Example:Test@12345678
		* Expected Result:"Display correctly password and hides characters"
		* Test Step 8:"Click on [Save] button"
		* Expected Result:"The password is changed"
		* Test Step 9:"Logout and log in with new password for the user at step 5"
		* Expected Result:"User can access to the system"
		*/
	@Test
	public void VAN1430_ChangePasswordByAdmin(){
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
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Open Change password page");
		String newPass="Dev@"+getRandomNumber();
		user.changePass(fullName,newPass,newPass);
		user.saveChangePass();
		
		info("Login with old password");
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, pass);
		info("Verify that the login page still shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,2000,1);
		
		info("Login with new password");
		mgLogInOut.signIn(hpID, newPass);
		info("Verify that The user is login successfully");
		waitForElementNotPresent(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,2000,1);
		waitForAndGetElement(navMenu.ELEMENT_NAVIGATION_BAR_LOGGED_IN_LABEL.replace("$value",fullName),2000,1);
	}
}