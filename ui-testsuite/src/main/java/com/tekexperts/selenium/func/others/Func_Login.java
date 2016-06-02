package com.tekexperts.selenium.func.others;
import org.testng.annotations.Test;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_Login extends TestConfig_Login{
		
	/**
	* Test case ID:VAN-1419
	* Test case name:"Verify that a user logout successfully"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Copy Home page link to clipboard"
	* Expected Result:"The link is copied"
	* Test Step 4:"Click on Logout link from navigation bar"
	* Expected Result:"Login page is shown"
	* Test Step 5:"Paste Home page link at step 3"
	* Expected Result:"Login page is shown"
	*/
	@Test
	public void VAN1419_VerifyThatAUserLogoutSuccessfully(){
		info("Verify that a user logout successfully");
		info("Login with an account");
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		info("Copy current url");
		String url=driver.getCurrentUrl();
		info("Logout");
		mgLogInOut.signOut(true);
		driver.get(url);
		info("Verify that login page is still shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
	}
		
	/**
	* Test case ID:VAN-1410
	* Test case name:"Check [Back to Sign in page] before recovered password"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Click on [I forgot my password] link"
	* Expected Result:"Password Recovery page is shown"
	* Test Step 3:"Click on [Back to Sign In page]link"
	* Expected Result:"Login page is shown"
	*/
	@Test
	public void VAN1410_CheckBackToSignInPageBeforeRecoveredPassword(){
		info("Check [Back to Sign in page] before recovered password");
		mgLogInOut.goToForgotPass();
		info("Back to Sign in page");
		mgLogInOut.goToSignIn();
	}
		
	/**
	* Test case ID:VAN-1409
	* Test case name:"Check [Back to Sign in page] after recovered password"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Click on [I forgot my password] link"
	* Expected Result:"Password Recovery page is shown"
	* Test Step 3:"Input an existed HP ID again"
	* Expected Result:"The HP ID is is input"
	* Test Step 4:"Click on [Submit] button"
	* Expected Result:"A message is displayed as:""Success! Your new password has been sent to your email."""
	* Test Step 5:"Click on [Back to Sign In page]link"
	* Expected Result:"Login page is shown"
	*/
	@Test
	public void VAN1409_CheckBackToSignInPageAfterRecoveredPassword(){
		info("Check [Back to Sign in page] after recovered password");
		info("Login with an account");
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		info("Create a new user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		
		navMenu.goToOrganization();
		orgaHome.goToUser();
		userlist.goToAddUser();
		userlist.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "", "", "","", "","", "");
		mgLogInOut.signOut(true);
		mgLogInOut.goToForgotPass();
		mgLogInOut.forgotPass(hpID);
		info("Verify that A message is displayed as:'Success! Your new password has been sent to your email.'");
		mgLogInOut.verifyRecoveryPassSucc();
		info("Back to Sign in page");
		mgLogInOut.goToSignIn();
	}
		
	/**
	* Test case ID:VAN-1408
	* Test case name:"Check [Forgot password] in the time more than 30 days"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Click on [I forgot my password] link"
	* Expected Result:"Password Recovery page is shown"
	* Test Step 3:"Input an existed HP ID again"
	* Expected Result:"The HP ID is is input"
	* Test Step 4:"Click on [Submit] button"
	* Expected Result:"A message is displayed as:""Success! Your new password has been sent to your email.""
	* Test Step 5:"Go to user's email"
	* Expected Result:"The user is received an email with new password"
	*/
	@Test(groups="pending")
	public void VAN1408_CheckForgotPasswordInTheTimeMoreThan30Days(){
	}
		
	/**
	* Test case ID:VAN-1407
	* Test case name:"Check [Forgot password] in the time less than 30 days"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Click on [I forgot my password] link"
	* Expected Result:"Password Recovery page is shown"
	* Test Step 3:"Input an existed HP ID again"
	* Expected Result:"The HP ID is is input"
	* Test Step 4:"Click on [Submit] button"
	* Expected Result:"A message is displayed as:""Success! Your new password has been sent to your email.""
	* Test Step 5:"Go to user's email"
	* Expected Result:"The user is received an email with new password"
	*  PENDING: CANNOT CHECK EMAIL IN TEST LOCAL. THIS WILL BE CHECKED BY MANUAL
	*/
	@Test(groups="pending")
	public void VAN1407_CheckForgotPasswordInTheTimeLessThan30Days(){
	}
		
	/**
	* Test case ID:VAN-1406
	* Test case name:"Check [Forgot password] with an not existed HPID"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Click on [I forgot my password] link"
	* Expected Result:"Password Recovery page is shown"
	* Test Step 3:"Input an not existed HP ID"
	* Expected Result:"The HP ID is is input"
	* Test Step 4:"Click on [Submit] button"
	* Expected Result:"A message is displayed as:""HP ID is not existed."""
	* Test Step 5:"Go to user's email"
	* Expected Result:"The user is not received an email with new password"
	* PENDING: CANNOT CHECK EMAIL IN TEST LOCAL. THIS WILL BE CHECKED BY MANUAL
	*/
	@Test(groups="pending")
	public void VAN1406_CheckForgotPasswordWithAnNotExistedHPID(){
	}
		
	/**
	* Test case ID:VAN-1405
	* Test case name:"Check [Forgot password] with an existed HPID"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Click on [I forgot my password] link"
	* Expected Result:"Password Recovery page is shown"
	* Test Step 3:"Input an existed HP ID"
	* Expected Result:"The HP ID is is input"
	* Test Step 4:"Click on [Submit] button"
	* Expected Result:"A message is displayed as:""Success! Your new password has been sent to your email."""
	* Test Step 5:"Go to user's email"
	* Expected Result:"The user is received an email with new password"
	* PENDING: CANNOT CHECK EMAIL IN TEST LOCAL. THIS WILL BE CHECKED BY MANUAL
	*/
	@Test(groups="pending")
	public void VAN1405_CheckForgotPasswordWithAnExistedHPID(){
	}
		
	/**
	* Test case ID:VAN-1404
	* Test case name:"Check [Remember my Email/HPID] with logging out"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input a valid Email/HPID"
	* Expected Result:"The email/HPID is input"
	* Test Step 3:"Input a valid password"
	* Expected Result:"The password is input"
	* Test Step 4:"Check on Remember my Email/HPID checkbox"
	* Expected Result:"The checkbox is checked"
	* Test Step 5:"Click on Sign In button"
	* Expected Result:"Go to Home page"
	* Test Step 6:Logout
	* Expected Result:"Login page is displayed"
	* Test Step 8:"Check email/HPID field"
	* Expected Result:"Email/HPID that is input at step 2 is shown"
	* PENDING: CANNOT CHECKED BY AUTO.BECAUSE THE EMAIL FIELD HAS INVISIBLED VALUE.
	*/
	@Test(groups="pending")
	public void VAN1404_CheckRememberMyEmailHPIDWithLoggingOut(){
		
	}
		
	/**
	* Test case ID:VAN-1403
	* Test case name:"Check [Remember my Email/HPID] without logging out"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input a valid Email/HPID"
	* Expected Result:"The email/HPID is input"
	* Test Step 3:"Input a valid password"
	* Expected Result:"The password is input"
	* Test Step 4:"Check on Remember my Email/HPID checkbox"
	* Expected Result:"The checkbox is checked"
	* Test Step 5:"Click on Sign In button"
	* Expected Result:"Go to Home page"
	* Test Step 6:"Close the browser"
	* Expected Result:"The browser is closed"
	* Test Step 7:"Check email/HPID field"
	* Expected Result:"Email/HPID that is input at step 2 is shown"
	* PENDING: CANNOT CHECKED BY AUTO.BECAUSE THE EMAIL FIELD HAS INVISIBLED VALUE.
	*/
	@Test(groups="pending")
	public void VAN1403_CheckRememberMyEmailHPIDWithoutLoggingOut(){
	}
		
	/**
	* Test case ID:VAN-1402
	* Test case name:"Verify that Email/HPID and Password fields are both required"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Leave Email/HPID field"
	* Expected Result:"The email/HPID is blank"
	* Test Step 3:"Leave password field"
	* Expected Result:"The password is blank"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page
	* *Display a error message as: ""Email/HP ID was required. Password was required."""
	*/
	@Test
	public void VAN1402_VerifyThatEmailHPIDAndPasswordFieldsAreBothRequired(){
		info("Verify that Email/HPID and Password fields are both required");
		String errorMess1=mesg.getContentByType(3);
		String errorMess2=mesg.getContentByType(2);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID was required. Password was required.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess2),2000,1);
	}
		
	/**
	* Test case ID:VAN-1401
	* Test case name:"Verify that Password field is required"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input an email/HPID"
	* Expected Result:"The email/HPID is input"
	* Test Step 3:"Leave password field"
	* Expected Result:"The password is blank"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page*Display a error message as: ""Password was required."""
	*/
	@Test
	public void VAN1401_VerifyThatPasswordFieldIsRequired(){
		info("Verify that Password field is required");
		String errorMess2=mesg.getContentByType(2);
		info("Type a hpID to the email/HPID field");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,USER_ROOT,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Password was required.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess2),2000,1);
	}
		
	/**
	* Test case ID:VAN-1400
	* Test case name:"Verify that Email/HPID is required"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Leave Email/HPID field"
	* Expected Result:"The email/HPID is blank"
	* Test Step 3:"Input a password"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"4. Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page*Display a error message as: ""Email/HP ID was required."""
	*/
	@Test
	public void VAN1400_VerifyThatEmailHPIDIsRequired(){
		info("Verify that Email/HPID is required");
		String errorMess1=mesg.getContentByType(3);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,USER_PASS,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID was required.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
	}
		
	/**
	* Test case ID:VAN-1399
	* Test case name:"Verify that login unsuccessfully with an invalid password and HPID"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input an invalid HPID"
	* Expected Result:"The input HPID is displayed in the field"
	* Test Step 3:"Input a invalid password"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page
	* *Display a error message as:""Email/HP ID or password is not correct."""
	*/
	@Test
	public void VAN1399_VerifyThatLoginUnsuccessfullyWithAnInvalidPasswordAndHPID(){
		info("Verify that login unsuccessfully with an invalid password and HPID");
		String errorMess1=mesg.getContentByType(1);
		String hpid=getRandomNumber();
		String pass=getRandomString();
		info("Type a emial/HPID");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,hpid,true);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,pass,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID or password is not correct.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
	}
		
	/**
	* Test case ID:VAN-1398
	* Test case name:"Verify that login unsuccessfully with an invalid password and email"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input an invalid email"
	* Expected Result:"The input Email is displayed in the field"
	* Test Step 3:"Input a invalid password"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page*Display a error message as:""Email/HP ID or password is not correct."""
	*/
	@Test
	public void VAN1398_VerifyThatLoginUnsuccessfullyWithAnInvalidPasswordAndEmail(){
		info("Verify that login unsuccessfully with an invalid password and Email");
		String errorMess1=mesg.getContentByType(1);
		String email="user"+getRandomNumber()+"@gmail.com";
		String pass=getRandomString();
		info("Type a emial/HPID");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,email,true);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,pass,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID or password is not correct.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
	}
		
	/**
	* Test case ID:VAN-1397
	* Test case name:"Verify that login unsuccessfully with an invalid password"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input a valid email/HPID"
	* Test Data:HPID:2222Email:quynh.pham-thuy@tek-experts.com
	* Expected Result:"The input Email/HPID is displayed in the field"
	* Test Step 3:"Input a invalid password"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page*Display a error message as:""Email/HP ID or password is not correct."""
	*/
	@Test
	public void VAN1397_VerifyThatLoginUnsuccessfullyWithAnInvalidPassword(){
		info("Verify that login unsuccessfully with an invalid password");
		String errorMess1=mesg.getContentByType(1);
		String pass=getRandomString();
		info("Type a emial/HPID");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,USER_ROOT,true);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,pass,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID or password is not correct.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
	}
		
	/**
	* Test case ID:VAN-1396
	* Test case name:"Verify that a user login successfully with a valid HPID"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to the <test_environment>"
	* Test Step 2:"Input a valid HP ID"
	* Test Data:"HPID: 2222"
	* Expected Result:"HPID is displayed in the field"
	* Test Step 3:"Input a valid password"
	* Test Data:"Pass: Test@123456"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Go to Home page*Display correct user's name on navigation bar"
	*/
	@Test
	public void VAN1396_VerifyThatAUserLoginSuccessfullyWithAValidHPID(){
		info("Verify that login unsuccessfully with an invalid password");
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		info("Verify that sign in page still is shown");
		waitForElementNotPresent(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("The login successfully");
		waitForAndGetElement(navMenu.ELEMENT_NAVIGATION_BAR_LOGGED_IN_LABEL.replace("$value",USER_ROOT_FULLNAME));
	}
		
	/**
	* Test case ID:VAN-1395
	* Test case name:"Verify that login unsuccessfully with an invalid HPID"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input an invalid HPID (not existed in the system)"
	* Test Data:HPID:a23a322
	* Expected Result:"The input HPID is displayed in the field"
	* Test Step 3:"Input a valid password"
	* Test Data:"Pass: Test@123456"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page*Display a error message as:""Email/HP ID or password is not correct."""
	*/
	@Test
	public void VAN1395_VerifyThatLoginUnsuccessfullyWithAnInvalidHPID(){
		info("Verify that login unsuccessfully with an invalid HPID");
		String errorMess1=mesg.getContentByType(1);
		String hpid=getRandomNumber();
		info("Type a emial/HPID");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,hpid,true);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,USER_PASS,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID or password is not correct.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
	}
		
	/**
	* Test case ID:VAN-1394
	* Test case name:"Verify that login unsuccessfully with an invalid email"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Input an invalid email's format or an existed email in the system"
	* Test Data:"Email: abc@gmail.com"
	* Expected Result:"The email is displayed in the field"
	* Test Step 3:"Input an valid password"
	* Test Data:"Pass: Test@123456"
	* Expected Result:"Display a password under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Cannot go to Home page. Stay in Login page*Display a error message as: ""Email/HP ID or password is not correct."""
	*/
	@Test
	public void VAN1394_VerifyThatLoginUnsuccessfullyWithAnInvalidEmail(){
		info("Verify that login unsuccessfully with an invalid email");
		String errorMess1=mesg.getContentByType(1);
		String email="user"+getRandomNumber()+"@mail";
		info("Type a emial/HPID");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,email,true);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,USER_PASS,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Display a error message as: 'Email/HP ID or password is not correct.'");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errorMess1),2000,1);
	}
	
	/**
	* Test case ID:VAN-1393
	* Test case name:"Verify that a user login successfully with a valid email"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to the <test_environment>"
	* Test Step 2:"Input a valid email"
	* Test Data:Email:quynh.pham-thuy@tek-experts.com
	* Expected Result:"The email is displayed in the field"
	* Test Step 3:"Input a valid password"
	* Test Data:"Pass: Test@123456"
	* Expected Result:"The password is displayed in the field under hiding type"
	* Test Step 4:"Click on Sign In button"
	* Expected Result:"*Go to Home page*Display correct user's name on navigation bar"
	*/
	@Test
	public void VAN1393_VerifyThatAUserLoginSuccessfullyWithAValidEmail(){
		info("Verify that a user login successfully with a valid email");
		info("Type a emial/HPID");
		type(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,USER_ROOT_EMAIL,true);
		info("Type a password");
		type(mgLogInOut.ELEMENT_LOGIN_PASS_FIELD,USER_PASS,true);
		info("Click on Sign In button");
		click(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN);
		info("Verify that sign in page still is shown");
		waitForElementNotPresent(mgLogInOut.ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("The login successfully");
		waitForAndGetElement(navMenu.ELEMENT_NAVIGATION_BAR_LOGGED_IN_LABEL.replace("$value",USER_ROOT_FULLNAME),3000,1);
	}
}