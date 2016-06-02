package com.tekexperts.selenium.smoke;

import org.testng.annotations.Test;
import static com.tekexperts.pipeline.common.TestLogger.info;

public class Smoke_LoginOut extends TestConfig_LoginOut{
	/**
	 * Test case ID: VAN-1726
	 * Test case name: Login successfully with valid data
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Input a valid data to Email/HPID field
	 * Test Step 3: Input a valid password to Password field
	 * Test Step 4: Click on [Sign In] button
	 * Test Step 5: Click on [Sign Out] icon
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. The Email/HPID is input 
	 * 3. The password is input
	 * 4. Home page is shown
	 * 5. Sign in page is shown
	 */
	@Test
	public void VAN1726_LoginSuccessfully(){
		info("USER_ROOT:"+USER_ROOT);
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		info("Verify that log in successfully with correct user");
		waitElementAndTryGetElement(navMenu.ELEMENT_NAVIGATION_BAR_LOGGED_IN_LABEL.replace("$value",USER_ROOT_FULLNAME));
		info("Click on Sign out icon");
		mgLogInOut.signOut();
		info("Verify that Sign in page is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,3000,1);
	}
	
	/**
	 * Test case ID: VAN-1727
	 * Test case name: Login unsuccessfully with invalid data
	 * Precondition: User A hasnot an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Input a invalid data to Email/HPID field
	 * Test Step 3: Input a valid password to Password field
	 * Test Step 4: Click on [Sign In] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. The Email/HPID is input 
	 * 3. The password is input
	 * 4. An error message is shown as [Email/HP ID or password is not correct.]
	 */
	@Test
	public void VAN1727_LoginUnsuccessfully(){
		info("Get error message's content");
		String errormesg=mesg.getContentByType(1);
		String invalid_user=getRandomString();
		String pass=getRandomString();
		info("Login with invalid user");
		mgLogInOut.signIn(invalid_user, pass);
		info("Verify that An error message is shown as [Email/HP ID or password is not correct.]");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errormesg));
		info("Verify that Sign in page is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,3000,1);
	}
	
	/**
	 * Test case ID: VAN-1728
	 * Test case name: Recovery password
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Click on [I forgot my password]link
	 * Test Step 3: Input a valid HPID
	 * Test Step 4: Click on [Submit] button
	 * Test Step 5: Go to the email
	 * Test Step 6: Login with new password
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Recover password page is shown
	 * 3. HPID is input
	 * 4. A message is shown as [Success! Your new password has been sent to your email.]
	 * 5. A new password is sent to the email
	 * 6. User log in successfully with new password
	 * PENDING: WAITING FOR CONFIGURATION EMAIL SEVER
	 */
	@Test(groups="pending")
	public void VAN1728_RecoverPassword(){
		info("Get error message's content");
		String errormesg=mesg.getContentByType(1);
		String invalid_user=getRandomString();
		String pass=getRandomString();
		info("Login with invalid user");
		mgLogInOut.signIn(invalid_user, pass);
		info("Verify that An error message is shown as [Email/HP ID or password is not correct.]");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_ERROR_MESSAGE.replace("$error",errormesg));
		info("Verify that Sign in page is shown");
		waitForAndGetElement(mgLogInOut.ELEMENT_LOGIN_EMAIL_FIELD,3000,1);
	}
}
