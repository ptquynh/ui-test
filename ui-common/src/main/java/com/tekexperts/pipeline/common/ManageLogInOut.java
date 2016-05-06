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
	public By ELEMENT_LOGIN_FORGOTPASS_LINK=By.xpath("");
	
	//*********LOGOUT**************\\
	//Logout icon
	public By ELEMENT_LOGOUT_ICON=By.xpath("//*[contains(@href,'/Login/Logout')]//i");
	
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
			click(ELEMENT_LOGOUT_ICON);
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
			waitForAndGetElement(ELEMENT_LOGIN_SIGNIN_BTN);
		info("Logout sucessfully");
	}
}
