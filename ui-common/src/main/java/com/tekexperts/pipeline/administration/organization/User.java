package com.tekexperts.pipeline.administration.organization;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class User extends PipelineBase{
	//User page title
	public By ELEMENT_USER_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'User')]");
    //Add button
	public By ELEMENT_USER_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/User/Create?Length=4']");
	//Edit a user
	public String ELEMENT_USER_FULLNAME_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]";
	//Unset credential
	public String ELEMENT_USER_CREDENTIAL_UNSET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Unset')]";
	//Set credential
	public String ELEMENT_USER_CREDENTIAL_SET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Set')]";
	//Reset link
	public String ELEMENT_USER_RESET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Reset')]";
	//Change password link
	public String ELEMENT_USER_CHANGEPASS_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Change')]";
	
	//****************************ADD/EDIT USER**********************************\\
	//Add User page title
	public By ELEMENT_USER_ADD_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Create user')]");
	//Full Name field
	public By ELEMENT_USER_ADDEDIT_FULLNAME_FIELD=By.xpath(".//*[@id='FullName']");
	//Email field
	public By ELEMENT_USER_ADDEDIT_EMAIL_FIELD=By.xpath(".//*[@id='Email']");
	//HPID field
	public By ELEMENT_USER_ADDEDIT_HPID_FIELD=By.xpath(".//*[@id='HPID']");
	//Password field
	public By ELEMENT_USER_ADD_PASSWORD_FIELD=By.xpath(".//*[@id='txtPassword']");
	//Confirm password
	public By ELEMENT_USER_ADD_CONFIRM_FIELD=By.xpath(".//*[@id='txtConfirmPassword']");
	//View checkbox
	public By ELEMENT_USER_ADD_VIEW_CHECKBOX=By.xpath(".//input[@id='ckViewPassword']");
	//Random password
	public By ELEMENT_USER_ADD_RANDOMPASS_BTN=By.xpath(".//*[@id='btnGeneratePassword']");
	//Job title field
	public By ELEMENT_USER_ADDEDIT_JOBTITLE_FIELD=By.xpath(".//*[@id='ddlJobTitle']");
	//RTM field
	public By ELEMENT_USER_ADDEDIT_RTM_FIELD=By.xpath(".//*[@id='Department']");
	//Region field
	public By ELEMENT_USER_ADDEDIT_REGION_FIELD=By.xpath(".//*[@id='Region']");
	//Telephone field
	public By ELEMENT_USER_ADDEDIT_TELEPHONE_FIELD=By.xpath(".//*[@id='Telephone']");
	//City field
	public By ELEMENT_USER_ADDEDIT_CITY_FIELD=By.xpath(".//*[@id='City']");
	//Country field
	public By ELEMENT_USER_ADDEDIT_COUNTRY_FIELD=By.xpath(".//*[@id='Country']");
	//Status field
	public By ELEMENT_USER_ADDEDIT_STATUS_DROPBOX=By.xpath(".//*[@id='Status']");
	//Role field
	public By ELEMENT_USER_ADDEDIT_ROLE_DROPBOX=By.xpath(".//*[@id='RoleID']");
	//Cancel button
	public By ELEMENT_USER_ADDEDIT_CANCEL_BTN=By.xpath(".//*[@id='form0']//*[contains(@class,'box-footer')]//button[1]");
	//Save button
	public By ELEMENT_USER_ADDEDIT_SAVE_BTN=By.xpath(".//*[@id='form0']//*[contains(@class,'box-footer')]//button[2]");
	
	//****************************SET CREDENTIAL*****************************\\
	//Region dropbox
	public By ELEMENT_USER_CREDENTIAL_REGION_DROPBOX=By.xpath(".//*[@id='select2-ddlRegion-container']");
	//RTM dropbox
	public By ELEMENT_USER_CREDENTIAL_RTM_DROPBOX=By.xpath(".//*[@id='gvCredential_DXFREditorcol3_I']");
	//Business Unit dropbox
	public By ELEMENT_USER_CREDENTIAL_BUSINESSUNIT_DROPBOX=By.xpath(".//*[@id='select2-ddlBusinessUnit-container']");
	//Cancel button
	public By ELEMENT_USER_CREDENTIAL_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Set button
	public By ELEMENT_USER_CREDENTIAL_SET_BTN=By.xpath(".//*[@id='form0']//button[2]");
	//Region filter
	public By ELEMENT_USER_CREDENTIAL_REGION_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol2_I']");
	//RTM fiter
	public By ELEMENT_USER_CREDENTIAL_RTM_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol3_I']");
	//Business Unit filter
	public By ELEMENT_USER_CREDENTIAL_BUSINESS_UNIT_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol4_I']");
	//Set Date filter
	public By ELEMENT_USER_CREDENTIAL_SET_DATE_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol5_I']");
	//Set By filter
	public By ELEMENT_USER_CREDENTIAL_SET_BY_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol6_I']");
	//Unset
	public String ELEMENT_USER_CREDENTIAL_UNSET=".//*[@id='gvCredential']//*[contains(text(),'$region')]/..//*[contains(text(),'Unset')]";
	
	//****************************CHANGE PASSWORD*****************************\\
	//OK button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_OK_BTN=By.xpath(".//*[@id='confirm']//*[contains(@class,'modal-footer')]//button[2]");
	//No button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_NO_BTN=By.xpath(".//*[@id='confirm']//*[contains(@class,'modal-footer')]//button[1]");
	//Close button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_CLOSE_BTN=By.xpath(".//*[@id='confirm']//*[contains(@class,'modal-header')]//button");
	//New password filed
	public By ELEMENT_CHANGEPASS_NEWPASSWORD_FIELD=By.xpath(".//*[@id='NewPassword']");
	//Confirm new password filed
	public By ELEMENT_CHANGEPASS_CONFIRMNEWPASS_FIELD=By.xpath(".//*[@id='ConfirmNewPassword']");
	//Cancel button
	public By ELEMENT_CHANGEPASS_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Save button
	public By ELEMENT_CHANGEPASS_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	//**********************************FILTER FIELDS*****************************\\
	//Full Name field filter
	public By ELEMENT_USER_FULLNAME_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol1_I']");
	//Status field filter
	public By ELEMENT_USER_STATUS_FILTER_ACTIVE=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_LBI1T0']");
	public By ELEMENT_USER_STATUS_FILTER_DISABLE=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_LBI2T0']");
	public By ELEMENT_USER_STATUS_FILTER_ALL=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_LBI0T0']");
	public By ELEMENT_USER_STATUS_FILTER_ARROW=By.xpath(".//input[@id='gvUser_DXFREditorcol7_I']");
	public By ELEMENT_USER_STATUS_FILTER_DROPLIST=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_D']");
	
	public User(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Add user page
	 */
	public void goToAddUser(){
		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_USER_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_USER_ADD_BTN);
		info("Add User page is shown");
		waitForAndGetElement(ELEMENT_USER_ADD_TITLE,3000,1);
	}
	/**
	 * Add a new user
	 * @param fullName
	 * @param email
	 * @param hpID
	 * @param pass
	 * @param confirmPass
	 * @param isView
	 * @param isRandomPass
	 * @param jobTitle
	 * @param rtm
	 * @param region
	 * @param telephone
	 * @param city
	 * @param country
	 * @param status
	 * @param role
	 */
	public void add(String fullName,String email,String hpID,String pass,String confirmPass,
			boolean isView,boolean isRandomPass,String jobTitle,String rtm,String region,String telephone,
			String city,String country,String status,String role){
		if(!fullName.isEmpty())
			type(ELEMENT_USER_ADDEDIT_FULLNAME_FIELD,fullName,true);
		if(!email.isEmpty())
			type(ELEMENT_USER_ADDEDIT_EMAIL_FIELD,email,true);
		if(!hpID.isEmpty())
			type(ELEMENT_USER_ADDEDIT_HPID_FIELD,hpID,true);
		if(!pass.isEmpty())
			type(ELEMENT_USER_ADD_PASSWORD_FIELD,pass,true);
		if(!confirmPass.isEmpty())
			type(ELEMENT_USER_ADD_CONFIRM_FIELD,confirmPass,true);
		if(isView)
			check(ELEMENT_USER_ADD_VIEW_CHECKBOX,2);
		if(isRandomPass){
			info("Click on Random Password button");
			click(ELEMENT_USER_ADD_RANDOMPASS_BTN);
			info("Get random password");
			USER_RANDOM_PASSWORD =getRandomPass();
		}
		if(!jobTitle.isEmpty())
			select(ELEMENT_USER_ADDEDIT_JOBTITLE_FIELD,jobTitle,2);
		if(!rtm.isEmpty())
			select(ELEMENT_USER_ADDEDIT_RTM_FIELD,rtm,2);
		if(!region.isEmpty())
			type(ELEMENT_USER_ADDEDIT_REGION_FIELD,region,true);
		if(!telephone.isEmpty())
			type(ELEMENT_USER_ADDEDIT_TELEPHONE_FIELD,telephone,true);
		if(!city.isEmpty())
			type(ELEMENT_USER_ADDEDIT_CITY_FIELD,city,true);
		if(!country.isEmpty())
			type(ELEMENT_USER_ADDEDIT_COUNTRY_FIELD,country,true);
		if(!status.isEmpty())
			select(ELEMENT_USER_ADDEDIT_STATUS_DROPBOX,status,2);
		if(!role.isEmpty())
			select(ELEMENT_USER_ADDEDIT_ROLE_DROPBOX,status,2);
			
		save();
	}
	/**
	 * Get Random password
	 * @return randomPass
	 */
	public String getRandomPass(){
		String randomPass=waitForAndGetElement(ELEMENT_USER_ADD_PASSWORD_FIELD).getText();
		info("Random password:"+randomPass);
		return randomPass;
		
	}
	/**
	 * Save all changes
	 */
	public void save(){
		info("Click on Save button");
		click(ELEMENT_USER_ADDEDIT_SAVE_BTN);
		info("Verify that User home page is shown");
		waitForAndGetElement(ELEMENT_USER_TITLE,3000,1);
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_USER_ADDEDIT_CANCEL_BTN);
		info("Verify that User home page is shown");
		waitForAndGetElement(ELEMENT_USER_TITLE,3000,1);
	}
	
	/**
	 * Verify that a user is shown in the table
	 * @param user
	 */
	public void verifyUserInTheTable(String user){
		info("Verify that the user is shown in the table");
		waitForAndGetElement(ELEMENT_USER_FULLNAME_LINK.replace("$fullname",user),3000,1);
		info("The user is shown in the table");
	}
	/**
	 * Search a user by fullName
	 * @param fullName
	 */
	public void searchByFullName(String fullName){
		info("Search a user in the table");
		type(ELEMENT_USER_FULLNAME_FILTER,fullName,true);
		Utils.pause(3000);
	}
	/**
	 * Search a user by status
	 * @param isActive
	 * @param isAll
	 */
	public void searchByStatus(Boolean isActive, Boolean isAll){
		info("Search a user in the table by status");
		waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_ARROW).click();
		waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_DROPLIST,3000,1,2);
		info("Status drop list is shown");
		if(!isActive)
			waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_DISABLE).click();
		if(isAll)
			waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_ALL).click();
		Utils.pause(3000);
	}
}
