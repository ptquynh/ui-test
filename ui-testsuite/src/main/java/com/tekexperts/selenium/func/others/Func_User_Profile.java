package com.tekexperts.selenium.func.others;
import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.organization.User.filters;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_User_Profile extends TestConfig{
		
	/**
	* Test case ID:VAN-1455
	* Test case name:"Go back to Home page from Profile page"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"From navigation bar
	* Test Data: click on [Profile] icon"
	* Test Step 4:"Click on [Return to Homepage] link in the left menu"
	* Expected Result:"Home page is shown"
	*/
	@Test
	public void VAN1455_GoBackToHomePageFromProfilePage(){
		info("Go back to Home page from Profile page");
		navMenu.goToUserProfile();
		info("Return to Homepage");
		userPro.returnHomePage();
		info("Verify that Home page is shown");
		waitForAndGetElement(navMenu.ELEMENT_HOMEPAGE_TEXT,3000,1);
		
	}
		
	/**
	* Test case ID:VAN-1436
	* Test case name:"Check breadcrumb on Profile page"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"From navigation bar
	* Test Data: click on [Profile] icon"
	* Test Step 4:"Verify direction on the breadcrumb"
	* Expected Result:"The breadcrumb is shown as: Home->Profile"
	* Test Step 5:"Click on a link on Breadcrumb"
	* Test Data:"Example: Click on Home link"
	* Expected Result:"Display correct page that is selected. For example here
	*/
	@Test
	public void VAN1436_CheckBreadcrumbOnProfilePage(){
		info("Go back to Home page from Profile page");
		navMenu.goToUserProfile();
		info("Verify direction on the breadcrumb");
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_BREADCRUMB_HOME,3000,1);
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_BREADCRUMB_PROFILE_ACTIVE,3000,1);
		info("Click on Home link on Breadcrumb");
		userPro.returnToHomeFromBreadcrumb();
		waitForAndGetElement(navMenu.ELEMENT_HOMEPAGE_TEXT,3000,1);
	}
		
	/**
	* Test case ID:VAN-1429
	* Test case name:"Cancel change password by owner"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with a normal user"
	* Test Data:"HPID: 0404Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Change your password] link"
	* Expected Result:"Change password page is shown"
	* Test Step 5:"Input a valid current password"
	* Test Data:Example:Test@123456
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 6:"Input a valid new password"
	* Test Data:Example:Test@12345678
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 7:"Input a valid confirm new password"
	* Test Data:Example:Test@12345678
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 8:"Click on [Cancel] button"
	* Expected Result:"The password is not changed"
	* Test Step 9:"Logout and log in with new password"
	* Expected Result:"User cannot access to the system"
	*/
	@Test
	public void VAN1429_CancelChangePasswordByOwner(){
		info("Cancel change password by owner");
		String currentPass=USER_PASS;
		String newPass="Dev@"+getRandomNumber();
		navMenu.goToUserProfile();
		info("Open change password page");
		userPro.goToChangePass();
		chagPass.changePass(currentPass, newPass, newPass);
		chagPass.cancel();
		info("Logout");
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(USER_ROOT, newPass);
		info("Login page is still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
	}
		
	/**
	* Test case ID:VAN-1428
	* Test case name:"Change password by owner with all invalid data"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with a normal user"
	* Test Data:"HPID: 0404Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Change your password] link"
	* Expected Result:"Change password page is shown"
	* Test Step 5:"Input an invalid current password"
	* Test Data:"Example: 123456"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 6:"Input an invalid new password"
	* Test Data:Example:12345678
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 7:"Input an invalid confirm new password"
	* Test Data:Example:123456
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"A error message is displayed as:"" Your password must be at least 8 characters. 'Confirm new password' and 'New password' do not match.Your password must contain an uppercase
	*/
	@Test
	public void VAN1428_ChangePasswordByOwnerWithAllInvalidData(){
		info("Change password by owner with all invalid data");
		String error1=mesg.getContentByType(4);
		String error2=mesg.getContentByType(5);
		String currentPass=getRandomNumber();
		String newPass=getRandomString();
		String confirmPass=getRandomString();
		navMenu.goToUserProfile();
		info("Open change password page");
		userPro.goToChangePass();
		chagPass.changePass(currentPass, newPass,confirmPass);
		chagPass.save(false);
		info("A error message is displayed as:'"
				+ "'Confirm new password' and 'New password' do not match.Your password must contain an uppercase, a lowercase, a number and a special character");
		chagPass.verifyErrorMessage(error1);
		chagPass.verifyErrorMessage(error2);
		
	}
		
	/**
	* Test case ID:VAN-1427
	* Test case name:"Change password by owner with an invalid confirm new password"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with a normal user"
	* Test Data:"HPID: 0404Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Change your password] link"
	* Expected Result:"Change password page is shown"
	* Test Step 5:"Input a valid current password"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 6:"Input a valid new password"
	* Test Data:Example:Test@123456
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 7:"Input a invalid confirm new password"
	* Test Data:Example:123456
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"A error message is displayed as:"" 'Confirm new password' and 'New password' do not match"""
	*/
	@Test
	public void VAN1427_ChangePasswordByOwnerWithAnInvalidConfirmNewPassword(){
		info("Change password by owner with an invalid confirm new password");
		String error1=mesg.getContentByType(4);
		String confirmPass="Dev@"+getRandomNumber();
		navMenu.goToUserProfile();
		info("Open change password page");
		userPro.goToChangePass();
		chagPass.changePass(USER_PASS,USER_PASS,confirmPass);
		chagPass.save(false);
		info("A error message is displayed as:'Confirm new password' and 'New password' do not match.");
		chagPass.verifyErrorMessage(error1);
	}
		
	/**
	* Test case ID:VAN-1426
	* Test case name:"Change password by owner with an invalid new password"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with a normal user"
	* Test Data:"HPID: 0404Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Change your password] link"
	* Expected Result:"Change password page is shown"
	* Test Step 5:"Input a valid current password"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 6:"Input an invalid new password less than 8 characters"
	* Test Data:Example:123456
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 7:"Input a valid confirm new password"
	* Test Data:"Example: 123456"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"A error message is displayed as:""Your password must be at least 8 characters. Your password must contain an uppercase
	* Test Step 9:"Input an invalid new password at least 8 characters"
	* Test Data:"New Password:case1: 12345678case2: Te12345678"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 10:"Execute step 7 and 8 again with correct confirm new password"
	* Expected Result:"A error message is displayed as:""Your password must contain an uppercase
	*/
	@Test
	public void VAN1426_ChangePasswordByOwnerWithAnInvalidNewPassword(){
		info("Change password by owner with an invalid new password");
		String error1=mesg.getContentByType(5);
		String error2=mesg.getContentByType(6);
		String newPass=getRandomString();
		navMenu.goToUserProfile();
		info("Open change password page");
		userPro.goToChangePass();
		chagPass.changePass(USER_PASS,newPass,newPass);
		chagPass.save(false);
		info("A error message is displayed as:Your password must contain an uppercase");
		chagPass.verifyErrorMessage(error1);
		chagPass.verifyErrorMessage(error2);
	}
		
	/**
	* Test case ID:VAN-1425
	* Test case name:"Change password by owner with an invalid current password"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with a normal user"
	* Test Data:"HPID: 0404Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Change your password] link"
	* Expected Result:"Change password page is shown"
	* Test Step 5:"Input an invalid current password"
	* Expected Result:"The password is displayed under hiding type in the field"
	* Test Step 6:"Input a valid new password"
	* Expected Result:"The password is displayed under hiding type in the field"
	* Test Step 7:"Input a valid confirm new password"
	* Expected Result:"The password is displayed under hiding type in the field"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"A error message is displayed as:""Old password is not correct"""
	*/
	@Test
	public void VAN1425_ChangePasswordByOwnerWithAnInvalidCurrentPassword(){
		info("Change password by owner with an invalid current password");
		String error1=mesg.getContentByType(7);
		String currentPass=getRandomString();
		String newPass="Dev@"+getRandomNumber();
		navMenu.goToUserProfile();
		info("Open change password page");
		userPro.goToChangePass();
		chagPass.changePass(currentPass,newPass,newPass);
		chagPass.save(false);
		info("A error message is displayed as:Old password is not correct");
		chagPass.verifyErrorMessage(error1);
	}
		
	/**
	* Test case ID:VAN-1424
	* Test case name:"Change password by owner"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with a normal user"
	* Test Data:"HPID: 0404Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Change your password] link"
	* Expected Result:"Change password page is shown"
	* Test Step 5:"Input a valid current password"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 6:"Input a valid new password"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 7:"Input a valid confirm new password"
	* Expected Result:"Display correctly password and hides characters"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"The new password is saved"
	* Test Step 9:"Logout and login with a old password"
	* Expected Result:"A error message is shown as:""Email/HP ID or password is not correct."""
	* Test Step 10:"Login with a new password"
	* Expected Result:"Go to Home page"
	*/
	@Test
	public void VAN1424_ChangePasswordByOwner(){
		info("Change password by owner");
		String error1=mesg.getContentByType(1);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String newPass="Dev@"+getRandomNumber();
		
		navMenu.goToOrganization();
		orgaHome.goToUser();
		userlist.goToAddUser();
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "", "", "","", "","", "");
		userlist.save();
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		
		navMenu.goToUserProfile();
		info("Open change password page");
		userPro.goToChangePass();
		chagPass.changePass(USER_PASS,newPass,newPass);
		chagPass.save(true);
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		info("A error message is shown as:'Email/HP ID or password is not correct.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",error1),2000,1);
		mgLogInOut.signIn(hpID,newPass);
		waitForElementNotPresent(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,3000,1);
		info("Login successfully");
		waitForAndGetElement(navMenu.ELEMENT_LEFT_MENU_ORGANIZATION,2000,1);
		
	}
		
	/**
	* Test case ID:VAN-1423
	* Test case name:"Cancel editing user's profile"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Edit] button"
	* Expected Result:"Edit Profile page is shown*All old information is kept on the page as input"
	* Test Step 5:"Input or change some information"
	* Test Data:"Exampale: Telephone
	* Expected Result: City or country..."
	* Test Step 6:"Click on [Cancel] button"
	* Expected Result:"All changes is not saved*Profile page is shown again*Profile link on left menu is highlighted"
	* Test Step 7:"Check user's information"
	* Expected Result:"The new information is not displayed.*All old information is not changed"
	*/
	@Test
	public void VAN1423_CancelEditingUsersProfile(){
		info("Cancel editing user's profile");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		
		String newTelephone=getRandomNumber();
		
		navMenu.goToOrganization();
		orgaHome.goToUser();
		userlist.goToAddUser();
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "", "", telephone,city,country,"", "");
		userlist.save();
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		
		navMenu.goToUserProfile();
		userPro.goToEditUserProfile();
		String editTelephone=waitForAndGetElement(userPro.ELEMENT_USERPROFILE_TELEPHONE,2000,1).getAttribute("value");
		String editCity=waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CITY,2000,1).getAttribute("value");
		String editCountry=waitForAndGetElement(userPro.ELEMENT_USERPROFILE_COUNTRY,2000,1).getAttribute("value");
		if(!telephone.equalsIgnoreCase(editTelephone)) assert false:"The telephone is not same as before";
		if(!city.equalsIgnoreCase(editCity)) assert false:"The city is not same as before";
		if(!country.equalsIgnoreCase(editCountry)) assert false:"The country is not same as before";
		userPro.edit(newTelephone, "", "", "");
		userPro.editCancel();
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",telephone),2000,1);
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newTelephone),2000,1);
	}
		
	/**
	* Test case ID:VAN-1422
	* Test case name:"Check user's information in my details when is changed by owner"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 4:"Click on [Edit] button"
	* Expected Result:"Edit Profile page is shown*All old information is kept on the page as input"
	* Test Step 5:"Input or change some information"
	* Test Data:"Exampale: Telephone
	* Expected Result: City or country..."
	* Test Step 6:"Save all changes"
	* Expected Result:"All changes is saved*Profile page is shown again*Profile link on left menu is highlighted"
	* Test Step 7:"Check user's information"
	* Expected Result:"The new information is displayed as edited"
	*/
	@Test
	public void VAN1422_CheckUsersInformationInMyDetailsWhenIsChangedByOwner(){
		info("Check user's information in my details when is changed by owner");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		
		String newTelephone=getRandomNumber();
		String newCity=getRandomNumber();
		String newCountry=getRandomNumber();
		
		navMenu.goToOrganization();
		orgaHome.goToUser();
		userlist.goToAddUser();
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "", "", telephone,city,country,"", "");
		userlist.save();
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		
		navMenu.goToUserProfile();
		userPro.goToEditUserProfile();
		String editTelephone=waitForAndGetElement(userPro.ELEMENT_USERPROFILE_TELEPHONE,2000,1).getAttribute("value");
		String editCity=waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CITY,2000,1).getAttribute("value");
		String editCountry=waitForAndGetElement(userPro.ELEMENT_USERPROFILE_COUNTRY,2000,1).getAttribute("value");
		if(!telephone.equalsIgnoreCase(editTelephone)) assert false:"The telephone is not same as before";
		if(!city.equalsIgnoreCase(editCity)) assert false:"The city is not same as before";
		if(!country.equalsIgnoreCase(editCountry)) assert false:"The country is not same as before";
		userPro.edit(newTelephone,newCity,newCountry, "");
		userPro.editSave();
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",telephone),2000,1);
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",city),2000,1);
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",country),2000,1);
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newTelephone),2000,1);
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newCity),2000,1);
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newCountry),2000,1);
	}
		
	/**
	* Test case ID:VAN-1421
	* Test case name:"Check user's information in my Details when is changed by Admin"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Go to [Organization] page"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [User] button"
	* Expected Result:"User list is shown"
	* Test Step 5:"Select a user in the list and Click on user's full name"
	* Expected Result:"Edit user page is shown"
	* Test Step 6:"Change user's information"
	* Test Data:"Example: Fullname
	* Expected Result: Email
	* Test Step 7:"Logout and login with the user at step 5"
	* Expected Result:"Go to Home page"
	* Test Step 8:"Click on [Profile] icon from navigation bar"
	* Expected Result:"Profile page is shown"
	* Test Step 9:"Check user' information in my detail"
	* Expected Result:"The information is changed as input at step 6"
	*/
	@Test
	public void VAN1421_CheckUsersInformationInMyDetailsWhenIsChangedByAdmin(){
		info("Check user's information in my Details when is changed by Admin");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		
		String newTelephone=getRandomNumber();
		String newCity=getRandomNumber();
		String newCountry=getRandomNumber();
		
		navMenu.goToOrganization();
		orgaHome.goToUser();
		userlist.goToAddUser();
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "", "", telephone,city,country,"", "");
		userlist.save();
		Utils.pause(3000);
		
		info("Search by full name");
		userlist.searchBy(filters.FULL_NAME,fullName);
		userlist.goToEdit(fullName);
		userlist.edit("","","","","","", newTelephone, newCity, newCountry,"","");
		userlist.save();
		Utils.pause(3000);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		navMenu.goToUserProfile();
		
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newTelephone),2000,1);
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newCity),2000,1);
		waitForAndGetElement(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",newCountry),2000,1);
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",telephone),2000,1);
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",city),2000,1);
		waitForElementNotPresent(userPro.ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",country),2000,1);
	}
		
	/**
	* Test case ID:VAN-1420
	* Test case name:"Check user's information in my Details"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"From navigation bar
	* Test Data: click on [Profile] icon"
	* Test Step 4:"Check user's information in My details"
	* Expected Result:"The information is shown correctly as input"
	*/
	@Test
	public void VAN1420_CheckUsersInformationInMyDetails(){
		info("Check user's information in my Details");
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		
		navMenu.goToOrganization();
		orgaHome.goToUser();
		userlist.goToAddUser();
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "", "", telephone,city,country,"", "");
		userlist.save();
		Utils.pause(3000);
		
		mgLogInOut.signOut(true);
		mgLogInOut.signIn(hpID, USER_PASS);
		navMenu.goToUserProfile();
		
		userPro.verifyUserInfor(fullName);
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
}