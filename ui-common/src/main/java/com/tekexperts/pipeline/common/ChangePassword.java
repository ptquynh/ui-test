package com.tekexperts.pipeline.common;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword extends PipelineBase {
	//******************LEFT MENU*******************\\
	public By ELEMENT_CHANGEPASS_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Change password')]");
	public By ELEMENT_CHANGEPASS_CURRENTPASS=By.xpath(".//*[@id='OldPassword']");
	public By ELEMENT_CHANGEPASS_NEWPASSS=By.xpath(".//*[@id='NewPassword']");
	public By ELEMENT_CHANGEPASS_CONFIRMPASS=By.xpath(".//*[@id='ConfirmNewPassword']");
	public By ELEMENT_CHANGEPASS_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	public By ELEMENT_CHANGEPASS_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	public By ELEMENT_CHANGEPASS_NOTIFICATION_SUCCESS=By.xpath(".//*[@id='NotificationBox'][contains(text(),'Your password has been changed successfully.')]");
	public String ELEMENT_CHANGEPASS_ERRORMESSAGE=".//*[@id='validationSummary']//*[contains(text(),\"$error\")]";
	
	
	public ChangePassword(WebDriver dr){
		driver = dr;
	}
	/**
	 * change password
	 * @param currentPass
	 * @param newPass
	 * @param confirmPass
	 */
	public void changePass(String currentPass,String newPass,String confirmPass){
		if(!currentPass.isEmpty()){
			info("Type current passs");
			type(ELEMENT_CHANGEPASS_CURRENTPASS,currentPass,true);
		}
		
		if(!newPass.isEmpty()){
			info("Type new passs");
			type(ELEMENT_CHANGEPASS_NEWPASSS,newPass,true);
		}
		
		if(!confirmPass.isEmpty()){
			info("Type confirm passs");
			type(ELEMENT_CHANGEPASS_CONFIRMPASS,confirmPass,true);
		}
		Utils.pause(3000);
		
	}
	/**
	 * Save all changes
	 */
	public void save(Boolean isSuccess){
		info("Click on Save button");
		click(ELEMENT_CHANGEPASS_SAVE_BTN);
		if(isSuccess)
		waitForAndGetElement(ELEMENT_CHANGEPASS_NOTIFICATION_SUCCESS,2000,1);
		Utils.pause(2000);
		info("Save successfully");
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_CHANGEPASS_CANCEL_BTN);
		waitForElementNotPresent(ELEMENT_CHANGEPASS_TITLE,2000,1);
		info("Cancelling successfully");
	}
	/**
	 * Verify that error message is shown
	 * @param error
	 */
	public void verifyErrorMessage(String error){
		info("Verify that error message is shown");
		info("error:"+error);
		waitForAndGetElement(ELEMENT_CHANGEPASS_ERRORMESSAGE.replace("$error",error),3000,1);
	}
	
}
