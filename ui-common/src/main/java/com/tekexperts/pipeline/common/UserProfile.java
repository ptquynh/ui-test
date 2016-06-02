package com.tekexperts.pipeline.common;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfile extends PipelineBase {
	//******************LEFT MENU*******************\\
	public By ELEMENT_USERPROFILE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Profile')]");
	public By ELEMENT_USERPROFILE_RETURNTOHOMEPAGE=By.xpath(".//*[@id='left-side']//*[@href='/Home/Index']");
	public By ELEMENT_USERPROFILE_PIPELINESETTING=By.xpath(".//*[@href='/CustomDisplaySetting?listAlias=Pipeline']");
	public By ELEMENT_PIPELINE_SETTING_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Custom display settings for Pipeline')]");
	//Breadcrumb
	public By ELEMENT_USERPROFILE_BREADCRUMB_HOME=By.xpath(".//*[@id='right-side']//a[@href='/']");
	public By ELEMENT_USERPROFILE_BREADCRUMB_PROFILE_ACTIVE=By.xpath(".//*[@id='right-side']//*[@class='active'][contains(text(),'Profile')]");
	
	public By ELEMENT_USERPROFILE_EDIT_BTN=By.xpath(".//*[@id='right-side']//button[contains(text(),'Edit')]");
	//************************MY DETAIL**********************\\
	public By ELEMENT_USERPROFILE_CHANGEPASS_LINK=By.xpath(".//*[@id='right-side']//*[@href='/ChangePassword']");
	public String ELEMENT_USERPROFILE_CONTENT_TEXT=".//*[@id='right-side']//*[contains(text(),'$text')]";
	
	//************************EDIT USER PROFILE***************************\\
	public By ELEMENT_USERPROFILE_TELEPHONE=By.xpath(".//*[@id='Telephone']");
	public By ELEMENT_USERPROFILE_CITY=By.xpath(".//*[@id='City']");
	public By ELEMENT_USERPROFILE_COUNTRY=By.xpath(".//*[@id='Country']");
	public By ELEMENT_USERPROFILE_DATEFORMAT=By.xpath(".//*[@id='form0']//select");
	public By ELEMENT_USERPROFILE_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	public By ELEMENT_USERPROFILE_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	public UserProfile(WebDriver dr){
		driver = dr;
	}
	/**
	 * Return to Home page from left menu
	 */
	public void returnHomePage(){
		info("Click on Return to Home page");
		click(ELEMENT_USERPROFILE_RETURNTOHOMEPAGE);
		waitForElementNotPresent(ELEMENT_USERPROFILE_TITLE,3000,1);
	}
	/**
	 * Return to Home page from Breadcrumb
	 */
	public void returnToHomeFromBreadcrumb(){
		info("Click on Home link on Breadcrumb");
		click(ELEMENT_USERPROFILE_BREADCRUMB_HOME);
		Utils.pause(3000);
	}
	/**
	 * Open change password page
	 */
	public void goToChangePass(){
		info("Click on Change Password link");
		click(ELEMENT_USERPROFILE_CHANGEPASS_LINK);
		Utils.pause(3000);
	}
	/**
	 * Open Edit user profile page
	 */
	public void goToEditUserProfile(){
		info(",Click on Edit button");
		click(ELEMENT_USERPROFILE_EDIT_BTN);
		waitForElementNotPresent(ELEMENT_USERPROFILE_EDIT_BTN,3000,1);
	}
	/**
	 * Edit a user profile
	 * @param telephone
	 * @param city
	 * @param country
	 * @param dateFormat
	 *                 =DD/MM/YYYY or MM/DD/YYYY
	 */
	public void edit(String telephone,String city,String country,String dateFormat){
		if(!telephone.isEmpty()){
			info("Type a new telephone");
			type(ELEMENT_USERPROFILE_TELEPHONE,telephone,true);
		}
		if(!city.isEmpty()){
			info("Type a new city");
			type(ELEMENT_USERPROFILE_CITY,city,true);
		}
		if(!country.isEmpty()){
			info("Type a new country");
			type(ELEMENT_USERPROFILE_COUNTRY,country,true);
		}
		if(!dateFormat.isEmpty()){
			info("Set Datetime format");
			select(ELEMENT_USERPROFILE_DATEFORMAT,dateFormat,2);
		}
	}
	/**
	 * Cancel all changes
	 */
	public void editCancel(){
		info("Click on cancel button");
		click(ELEMENT_USERPROFILE_CANCEL_BTN);
		waitForElementNotPresent(ELEMENT_USERPROFILE_CANCEL_BTN,2000,1);
		waitForAndGetElement(ELEMENT_USERPROFILE_TITLE,2000,1);
	}
	/**
	 * Save all changes
	 */
	public void editSave(){
		info("Click on save button");
		click(ELEMENT_USERPROFILE_SAVE_BTN);
		waitForElementNotPresent(ELEMENT_USERPROFILE_SAVE_BTN,2000,1);
		waitForAndGetElement(ELEMENT_USERPROFILE_TITLE,2000,1);
	}
	/**
	 * Verify user's information 
	 * @param text
	 */
	public void verifyUserInfor(String text){
		info("Verify that the info:"+text+" is displayed in the My Detail");
		waitForAndGetElement(ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",text),2000,1);
	}
	/**
	 * Verify that user's information is shown 
	 * @param text
	 */
	public void verifyUserNOTInfor(String text){
		info("Verify that the info:"+text+" isnot displayed in the My Detail");
		waitForElementNotPresent(ELEMENT_USERPROFILE_CONTENT_TEXT.replace("$text",text),2000,1);
	}
	/**
	 * Open pipeline setting page
	 */
	public void goToPipelineSetting(){
		info("Click on Pipeline setting link");
		click(ELEMENT_USERPROFILE_PIPELINESETTING);
		waitForAndGetElement(ELEMENT_PIPELINE_SETTING_TITLE,3000,1);
	}
}
