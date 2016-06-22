package com.tekexperts.pipeline.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class ManageLogInOut extends PipelineBase {
	//*********LOGIN************\\
	//Email/HPID filed
	public By ELEMENT_LOGIN_EMAIL_FIELD=By.xpath(".//*[@id='txtUserName']");
	//Password field
	public By ELEMENT_LOGIN_PASS_FIELD=By.xpath(".//*[@id='txtPassword']");
	//Remember my Email/ID
	public By ELEMENT_LOGIN_REMEMBERMYEMAIL_CHECKBOX=By.xpath(".//*[@id='Remember']");
	//Sign in button
	public By ELEMENT_LOGIN_SIGNIN_BTN=By.xpath(".//*[@id='btnLogin']");
	//Forgot my password link
	public By ELEMENT_LOGIN_FORGOTPASS_LINK=By.xpath(".//*[@id='frmLogin']//*[@href='/ForgotPassword']");
	
	//**********************FORGOT PASSWORD**************************\\
	public By ELEMENT_FORGOTPASS_BACKTOSIGNIN=By.xpath(".//*[@id='form0']//a[@href='/Login']");
	public By ELEMENT_FORGOTPASS_HPID_FIELD=By.xpath(".//*[@id='HPID']");
	public By ELEMENT_FORGOTPASS_SUBMIT_BTN=By.xpath(".//*[@id='form0']//button");
	public By ELEMENT_FORGOTPASS_SUCCESS_MESSAGE_RECOVERYPASS=By.xpath(".//*[@id='form0']//*[contains(@class,'alert-success')][contains(.,'Your new password has been sent to your email.')]");
	
	//*********LOGOUT**************\\
	//Logout icon
	public By ELEMENT_LOGOUT_ICON=By.xpath("//*[contains(@href,'/Login/Logout')]//i");
	
	//************MESSAGE****************\\
	public String ELEMENT_LOGIN_ERROR_MESSAGE=".//*[@id='validationSummary']//*[contains(text(),'$error')]";
	
	//********************************FUNCTIONS******************************\\
	public ManageLogInOut(WebDriver dr){
		driver = dr;
	}
	/**
	 * Sign in to the pipeline
	 * @param emailHPID
	 * @param password
	 * @param opParams
	 */
	public void signIn(String emailHPID, String password,Boolean...opParams){
		info("Starting sign in the system");
		Boolean verify = (Boolean) (opParams.length > 0 ? opParams[0]: false);
		info("login normally with email/HPID " + emailHPID + " and pass " + password);
		type(ELEMENT_LOGIN_EMAIL_FIELD, emailHPID,true);
		type(ELEMENT_LOGIN_PASS_FIELD, password,true);
		clickByJavascript(ELEMENT_LOGIN_SIGNIN_BTN, 2);
		if(verify)
			waitForElementNotPresent(ELEMENT_LOGIN_SIGNIN_BTN);
	}
   /**
    * Logout the system
    */
   public void signOut(Boolean...opParams){
	    Boolean verify = (Boolean) (opParams.length > 0 ? opParams[0]: false);
		info("Sign out");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LOGOUT_ICON);
				break;
			}
			if (waitForAndGetElement(ELEMENT_LOGOUT_ICON, 5000, 0) != null){
				info("Element " + ELEMENT_LOGOUT_ICON + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LOGOUT_ICON);
		if(waitForAndGetElement(ELEMENT_LOGOUT_ICON,2000,0)!=null){
			info("Clear cache and reconnect to the page");
			driver.manage().deleteAllCookies();
			driver.get(baseUrl);
		}
			
		Utils.pause(3000);
		if(verify)
			waitForAndGetElement(ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
		info("Logout sucessfully");
	}
   /**
    * Open forgot password page
    */
   public void goToForgotPass(){
	   info("Click on the link");
	   click(ELEMENT_LOGIN_FORGOTPASS_LINK);
	   info("Verify that Forgot pass page is shown");
	   waitForAndGetElement(ELEMENT_FORGOTPASS_BACKTOSIGNIN,3000,1);
   }
   /**
    * Back to Sign in page from forgot pass page
    */
   public void goToSignIn(){
	   info("Click on Back To Sign In link");
	   click(ELEMENT_FORGOTPASS_BACKTOSIGNIN);
	   info("Verify that sign in page is shown");
	   waitForAndGetElement(ELEMENT_LOGIN_SIGNIN_BTN,3000,1);
   }
   
   public void forgotPass(String hpID){
	   info("Type a ID to the field");
	   type(ELEMENT_FORGOTPASS_HPID_FIELD,hpID,true);
	   info("Click on Submit button");
	   click(ELEMENT_FORGOTPASS_SUBMIT_BTN);
   }
   /**
    * Verify that success message is shown 
    */
   public void verifyRecoveryPassSucc(){
	   info("Verify that recovery password is success with success mess");
	   waitForAndGetElement(ELEMENT_FORGOTPASS_SUCCESS_MESSAGE_RECOVERYPASS,6000,1);
   }
   /**
    * Select remember checkbox
    */
   public void remember(){
	   info("Click on Remember checkbox");
	   check(ELEMENT_LOGIN_REMEMBERMYEMAIL_CHECKBOX,2);
	   Utils.pause(2000);
   }
}
